package com.gerente.model.dto;

import com.gerente.model.entity.Equipe;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class EquipeDTO {
    private Long id;

    @NotNull(message = "Nome não pode estar vazio.")
    private String name;
    @NotNull(message = "Ambulancia não pode estar vazio.")
    private AmbulanciaDTO ambulancia;
    @NotNull(message = "Funcionarios não pode estar vazio.")
    private List<FuncionarioDTO> funcionarios;

    public EquipeDTO() {
    }

    public EquipeDTO(Equipe model) {
        this.id = model.getId();
        this.name = model.getName();
        this.ambulancia = new AmbulanciaDTO(model.getAmbulancia());
        this.funcionarios = model.getFuncionrios().stream().map(funcionario -> new FuncionarioDTO(funcionario)).collect(Collectors.toList());
    }
}
