package com.gerente.model.dto;

import com.gerente.model.entity.AmbulanciaType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class AmbulanciaTypeDTO {
    private Long id;

    @NotNull(message = "Nome não pode estar vazio.")
    private String name;
    @NotNull(message = "Funcões não pode estar vazio.")
    private List<FuncaoDTO> funcoes;

    public AmbulanciaTypeDTO() {
    }

    public AmbulanciaTypeDTO(AmbulanciaType model) {
        this.id = model.getId();
        this.name = model.getName();
        this.funcoes = model.getFuncoes().stream().map(funcao -> new FuncaoDTO(funcao)).collect(Collectors.toList());
    }
}
