package com.gerente.rest.service;

import com.gerente.exception.BOException;
import com.gerente.model.dto.FuncaoDTO;
import com.gerente.model.entity.Funcao;
import com.gerente.repository.FuncaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class FuncaoService {
    @Autowired
    private FuncaoRepository repository;

    public FuncaoDTO save(FuncaoDTO dto) {
        Funcao model = new Funcao(dto);

        return new FuncaoDTO(this.repository.save(model));
    }

    public FuncaoDTO findOne(Long id) {
        Funcao model = this.repository.getOne(id);

        if (model == null) {
            throw new BOException("funcionario inexistente.", new Throwable("funcionario.notfound"));
        }

        return new FuncaoDTO(model);
    }

    public Collection<FuncaoDTO> findAll() {
        Collection<Funcao> funcionarios = this.repository.findAll();
        Collection<FuncaoDTO> funcionariosDto = new ArrayList<>();

        funcionarios.forEach((item) -> {
            funcionariosDto.add(new FuncaoDTO(item));
        });

        return funcionariosDto;
    }

    public void delete(Long id) {

        this.repository.deleteById(id);
    }
}
