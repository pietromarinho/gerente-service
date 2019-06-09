package com.gerente.model.dto;

import com.gerente.model.entity.Zona;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ZonaDTO {
    private Long id;

    @NotNull(message = "Nome não pode estar vazio.")
    private String name;

    public ZonaDTO() {
    }

    public ZonaDTO(Zona model) {
        this.id = model.getId();
        this.name = model.getName();
    }
}
