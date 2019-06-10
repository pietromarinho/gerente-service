package com.gerente.model.entity;


import com.gerente.model.dto.AmbulanciaTypeDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "ambulanciaType")
public class AmbulanciaType extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String name;
    @ManyToMany()
    private List<Funcao> funcoes;

    public AmbulanciaType() {
    }

    public AmbulanciaType(AmbulanciaTypeDTO dto) {
        if (dto.getId() != null) {
            super.setId(dto.getId());
        }
        setName(dto.getName());
        setFuncoes(dto.getFuncoes().stream().map(funcao -> new Funcao(funcao)).collect(Collectors.toList()));
    }
}
