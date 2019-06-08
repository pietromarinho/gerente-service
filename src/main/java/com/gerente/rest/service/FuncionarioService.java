package com.gerente.rest.service;

import com.gerente.exception.BOException;
import com.gerente.model.dto.FuncaoDTO;
import com.gerente.model.dto.FuncionarioDTO;
import com.gerente.model.entity.Funcao;
import com.gerente.model.entity.Funcionario;
import com.gerente.repository.FuncaoRepository;
import com.gerente.repository.FuncionarioRepository;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class FuncionarioService {

    @Autowired
    private FuncaoRepository funcaoRepository;

    @Autowired
    private FuncionarioRepository repository;

    public FuncionarioDTO save(FuncionarioDTO dto) {
        Funcionario model = new Funcionario(dto);
        Funcao funcao= funcaoRepository.getOne(model.getFuncao().getId());

        model.setFuncao(funcao);

        return new FuncionarioDTO(this.repository.save(model));
    }

    public FuncionarioDTO findOne(Long id) {
        Funcionario model = this.repository.getOne(id);

        if (model == null) {
            throw new BOException("funcionario inexistente.", new Throwable("funcionario.notfound"));
        }

        return new FuncionarioDTO(model);
    }

    public Collection<FuncionarioDTO> findAll() {
        Collection<Funcionario> funcionarios = this.repository.findAll();
        Collection<FuncionarioDTO> funcionariosDto = new ArrayList<>();

        funcionarios.forEach((item) -> {
            funcionariosDto.add(new FuncionarioDTO(item));
        });

        return funcionariosDto;
    }

    public void delete(Long id) {

        this.repository.deleteById(id);
    }
}
