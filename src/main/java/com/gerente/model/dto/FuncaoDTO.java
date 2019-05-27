package com.gerente.model.dto;

import com.gerente.model.entity.Funcao;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class FuncaoDTO {
    private Long id;

    @NotNull(message = "Nome não pode estar vazio.")
    private String name;

    public FuncaoDTO() {
    }

    public FuncaoDTO(Funcao model) {
        this.id = model.getId();
        this.name = model.getName();
    }
}
