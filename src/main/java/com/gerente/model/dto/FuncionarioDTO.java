package com.gerente.model.dto;

import com.gerente.model.entity.Funcao;
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
    @NotNull(message = "Matrícula não pode estar vazio.")
    private String matricula;
    @NotNull(message = "função não pode estar vazio.")
    private FuncaoDTO funcao;

    public FuncionarioDTO() {
    }

    public FuncionarioDTO(Funcionario model) {
        this.id = model.getId();
        this.name = model.getName();
        this.matricula = model.getMatricula();
        this.funcao = new FuncaoDTO(model.getFuncao());
    }
}
