package com.gerente.model.dto;

import com.gerente.model.entity.AmbulanciaType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AmbulanciaTypeDTO {
    private Long id;

    @NotNull(message = "Nome não pode estar vazio.")
    private String name;

    public AmbulanciaTypeDTO() {
    }

    public AmbulanciaTypeDTO(AmbulanciaType model) {
        this.id = model.getId();
        this.name = model.getName();
    }
}
