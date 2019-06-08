package com.gerente.model.entity;


import com.gerente.model.dto.FuncionarioDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "funcionario")
public class Funcionario extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_funcao"))
    private Funcao funcao;
    @Column(nullable = false)
    @JoinColumn(unique = true)
    private String matricula;

    public Funcionario() {
    }

    public Funcionario(FuncionarioDTO dto) {
        if (dto.getId() != null) {
            super.setId(dto.getId());
        }
        setName(dto.getName());
        setMatricula((dto.getMatricula()));
        setFuncao(new Funcao(dto.getFuncao()));
    }
}
