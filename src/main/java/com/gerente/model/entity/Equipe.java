package com.gerente.model.entity;


import com.gerente.model.dto.EquipeDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "equipe")
public class Equipe extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_ambulancia"))
    private Ambulancia ambulancia;
    @ManyToMany()
    private List<Funcionario> funcionrios;

    public Equipe() {
    }

    public Equipe(EquipeDTO dto) {
        if (dto.getId() != null) {
            super.setId(dto.getId());
        }
        setName(dto.getName());
        setAmbulancia(new Ambulancia(dto.getAmbulancia()));
        setFuncionrios(dto.getFuncionarios().stream().map(funcionario -> new Funcionario(funcionario)).collect(Collectors.toList()));
    }
}
