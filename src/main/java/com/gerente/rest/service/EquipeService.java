package com.gerente.rest.service;

import com.gerente.exception.BOException;
import com.gerente.model.dto.EquipeDTO;
import com.gerente.model.entity.Ambulancia;
import com.gerente.model.entity.Equipe;
import com.gerente.repository.AmbulanciaRepository;
import com.gerente.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class EquipeService {

    @Autowired
    private AmbulanciaRepository ambulanciaRepository;

    @Autowired
    private EquipeRepository repository;

    public EquipeDTO save(EquipeDTO dto) {
        Equipe model = new Equipe(dto);
        Ambulancia abulancia = ambulanciaRepository.getOne(model.getAmbulancia().getId());

        model.setAmbulancia(abulancia);

        return new EquipeDTO(this.repository.save(model));
    }

    public EquipeDTO findOne(Long id) {
        Equipe model = this.repository.getOne(id);

        if (model == null) {
            throw new BOException("equipe inexistente.", new Throwable("equipe.notfound"));
        }

        return new EquipeDTO(model);
    }

    public Collection<EquipeDTO> findAll() {
        Collection<Equipe> equipes = this.repository.findAll();
        Collection<EquipeDTO> equipesDto = new ArrayList<>();

        equipes.forEach((item) -> {
            equipesDto.add(new EquipeDTO(item));
        });

        return equipesDto;
    }

    public void delete(Long id) {

        this.repository.deleteById(id);
    }
}
