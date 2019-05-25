package com.gerente.model.entity;


import com.gerente.model.dto.FuncionarioDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "funcionario")
public class Funcionario extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String name;
    private String funcao;

    public Funcionario() {
    }

    public Funcionario(FuncionarioDTO dto) {
        if (dto.getId() != null) {
            super.setId(dto.getId());
        }
        setName(dto.getName());
        setFuncao(dto.getFuncao());
    }
}
