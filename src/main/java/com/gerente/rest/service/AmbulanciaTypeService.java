package com.gerente.rest.service;

import com.gerente.exception.BOException;
import com.gerente.model.dto.AmbulanciaTypeDTO;
import com.gerente.model.entity.AmbulanciaType;
import com.gerente.repository.AmbulanciaTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class AmbulanciaTypeService {
    @Autowired
    private AmbulanciaTypeRepository repository;

    public AmbulanciaTypeDTO save(AmbulanciaTypeDTO dto) {
        AmbulanciaType model = new AmbulanciaType(dto);

        return new AmbulanciaTypeDTO(this.repository.save(model));
    }

    public AmbulanciaTypeDTO findOne(Long id) {
        AmbulanciaType model = this.repository.getOne(id);

        if (model == null) {
            throw new BOException("ambulancia inexistente.", new Throwable("ambulancia.notfound"));
        }

        return new AmbulanciaTypeDTO(model);
    }

    public Collection<AmbulanciaTypeDTO> findAll() {
        Collection<AmbulanciaType> ambulancias = this.repository.findAll();
        Collection<AmbulanciaTypeDTO> ambulanciasDto = new ArrayList<>();

        ambulancias.forEach((item) -> {
            ambulanciasDto.add(new AmbulanciaTypeDTO(item));
        });

        return ambulanciasDto;
    }

    public void delete(Long id) {

        this.repository.deleteById(id);
    }
}
