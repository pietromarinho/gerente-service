package com.gerente.model.dto;

import com.gerente.model.entity.Ambulancia;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AmbulanciaDTO {
    private Long id;

    @NotNull(message = "Nome não pode estar vazio.")
    private String name;
    @NotNull(message = "Tipo de Ambulância não pode estar vazio.")
    private AmbulanciaTypeDTO ambulanciaType;

    public AmbulanciaDTO() {
    }

    public AmbulanciaDTO(Ambulancia model) {
        this.id = model.getId();
        this.name = model.getName();
        this.ambulanciaType = new AmbulanciaTypeDTO(model.getAmbulanciaType());
    }
}
