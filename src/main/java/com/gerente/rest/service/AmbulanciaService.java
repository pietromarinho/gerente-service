package com.gerente.rest.service;

import com.gerente.exception.BOException;
import com.gerente.model.dto.AmbulanciaDTO;
import com.gerente.model.entity.AmbulanciaType;
import com.gerente.model.entity.Ambulancia;
import com.gerente.repository.AmbulanciaRepository;
import com.gerente.repository.AmbulanciaTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class AmbulanciaService {

    @Autowired
    private AmbulanciaTypeRepository ambulanciaTypeRepository;

    @Autowired
    private AmbulanciaRepository repository;

    public AmbulanciaDTO save(AmbulanciaDTO dto) {
        Ambulancia model = new Ambulancia(dto);
        AmbulanciaType ambulanciaType= ambulanciaTypeRepository.getOne(model.getAmbulanciaType().getId());

        model.setAmbulanciaType(ambulanciaType);

        return new AmbulanciaDTO(this.repository.save(model));
    }

    public AmbulanciaDTO findOne(Long id) {
        Ambulancia model = this.repository.getOne(id);

        if (model == null) {
            throw new BOException("ambulancia inexistente.", new Throwable("ambulancia.notfound"));
        }

        return new AmbulanciaDTO(model);
    }

    public Collection<AmbulanciaDTO> findAll() {
        Collection<Ambulancia> ambulancias = this.repository.findAll();
        Collection<AmbulanciaDTO> ambulanciasDto = new ArrayList<>();

        ambulancias.forEach((item) -> {
            ambulanciasDto.add(new AmbulanciaDTO(item));
        });

        return ambulanciasDto;
    }

    public void delete(Long id) {

        this.repository.deleteById(id);
    }
}
