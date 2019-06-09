package com.gerente.model.entity;


import com.gerente.model.dto.AmbulanciaDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "ambulancia")
public class Ambulancia extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_ambulancia_type"))
    private AmbulanciaType ambulanciaType;

    public Ambulancia() {
    }

    public Ambulancia(AmbulanciaDTO dto) {
        if (dto.getId() != null) {
            super.setId(dto.getId());
        }
        setName(dto.getName());
        setAmbulanciaType(new AmbulanciaType(dto.getAmbulanciaType()));
    }
}
