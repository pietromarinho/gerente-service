package com.gerente.rest.controller;


import com.gerente.model.dto.AmbulanciaDTO;
import com.gerente.rest.service.AmbulanciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/rest/ambulancia")
public class AmbulanciaController {
    @Autowired
    private AmbulanciaService service;

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<AmbulanciaDTO> findOne(@PathVariable("id") Long id) {
        AmbulanciaDTO response = this.service.findOne(id);

        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity<Collection<AmbulanciaDTO>> findAll() {
        Collection<AmbulanciaDTO> response = this.service.findAll();

        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/")
    public ResponseEntity<?> save(@Valid @RequestBody AmbulanciaDTO ambulanciaDto, BindingResult result) {

        return getResponseEntity(ambulanciaDto, result);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/")
    public ResponseEntity<?> update(@Valid @RequestBody AmbulanciaDTO ambulanciaDto, BindingResult result) {

        return getResponseEntity(ambulanciaDto, result);
    }

    private ResponseEntity<?> getResponseEntity(@RequestBody @Valid AmbulanciaDTO ambulanciaDto, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = new ArrayList<>();
            result.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }

        AmbulanciaDTO response = this.service.save(ambulanciaDto);

        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        this.service.delete(id);
        return ResponseEntity.ok(null);
    }
}
