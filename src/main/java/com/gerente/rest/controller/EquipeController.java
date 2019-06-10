package com.gerente.rest.controller;


import com.gerente.model.dto.EquipeDTO;
import com.gerente.rest.service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/rest/equipe")
public class EquipeController {
    @Autowired
    private EquipeService service;

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<EquipeDTO> findOne(@PathVariable("id") Long id) {
        EquipeDTO response = this.service.findOne(id);

        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity<Collection<EquipeDTO>> findAll() {
        Collection<EquipeDTO> response = this.service.findAll();

        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/")
    public ResponseEntity<?> save(@Valid @RequestBody EquipeDTO equipeDto, BindingResult result) {

        return getResponseEntity(equipeDto, result);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/")
    public ResponseEntity<?> update(@Valid @RequestBody EquipeDTO equipeDto, BindingResult result) {

        return getResponseEntity(equipeDto, result);
    }

    private ResponseEntity<?> getResponseEntity(@RequestBody @Valid EquipeDTO equipeDto, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = new ArrayList<>();
            result.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }

        EquipeDTO response = this.service.save(equipeDto);

        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        this.service.delete(id);
        return ResponseEntity.ok(null);
    }
}
