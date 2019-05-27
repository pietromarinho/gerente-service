package com.gerente.rest.controller;


import com.gerente.model.dto.FuncaoDTO;
import com.gerente.rest.service.FuncaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/rest/funcao")
public class FuncaoController {
    @Autowired
    private FuncaoService service;

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<FuncaoDTO> findOne(@PathVariable("id") Long id) {
        FuncaoDTO response = this.service.findOne(id);

        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity<Collection<FuncaoDTO>> findAll() {
        Collection<FuncaoDTO> response = this.service.findAll();

        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/")
    public ResponseEntity<?> save(@Valid @RequestBody FuncaoDTO funcionarioDto, BindingResult result) {

        return getResponseEntity(funcionarioDto, result);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/")
    public ResponseEntity<?> update(@Valid @RequestBody FuncaoDTO funcionarioDto, BindingResult result) {

        return getResponseEntity(funcionarioDto, result);
    }

    private ResponseEntity<?> getResponseEntity(@RequestBody @Valid FuncaoDTO funcionarioDto, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = new ArrayList<>();
            result.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }

        FuncaoDTO response = this.service.save(funcionarioDto);

        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        this.service.delete(id);
        return ResponseEntity.ok(null);
    }
}
