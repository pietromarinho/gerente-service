package com.gerente.model.dto;

import com.gerente.model.entity.Funcionario;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class FuncionarioDTO {
    private Long id;

    @NotNull(message = "Nome não pode estar vazio.")
    private String name;
    @NotNull(message = "função não pode estar vazio.")
    private String funcao;

    public FuncionarioDTO() {
    }

    public FuncionarioDTO(Funcionario model) {
        this.id = model.getId();
        this.name = model.getName();
        this.funcao = model.getFuncao();
    }
}
