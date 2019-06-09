package com.gerente.rest.service;

import com.gerente.exception.BOException;
import com.gerente.model.dto.ZonaDTO;
import com.gerente.model.entity.Zona;
import com.gerente.repository.ZonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class ZonaService {
    @Autowired
    private ZonaRepository repository;

    public ZonaDTO save(ZonaDTO dto) {
        Zona model = new Zona(dto);

        return new ZonaDTO(this.repository.save(model));
    }

    public ZonaDTO findOne(Long id) {
        Zona model = this.repository.getOne(id);

        if (model == null) {
            throw new BOException("Zona inexistente.", new Throwable("zona.notfound"));
        }

        return new ZonaDTO(model);
    }

    public Collection<ZonaDTO> findAll() {
        Collection<Zona> zonas = this.repository.findAll();
        Collection<ZonaDTO> zonasDto = new ArrayList<>();

        zonas.forEach((item) -> {
            zonasDto.add(new ZonaDTO(item));
        });

        return zonasDto;
    }

    public void delete(Long id) {

        this.repository.deleteById(id);
    }
}
