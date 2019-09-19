package com.cdc.dcop.controller;

import com.cdc.dcop.dto.PetDTO;
import com.cdc.dcop.entity.Pet;
import com.cdc.dcop.services.IPetstoreService;
import com.cdc.dcop.utils.Utilities;
import com.cdc.utility.controller.BaseController;
import com.cdc.utility.model.dto.request.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/petstore")
public class PetstoreController {

    Utilities u = new Utilities();

    @Autowired
    private IPetstoreService petstoreService;

    // Agregar Mascota
    @PostMapping(value = "/pet", produces = MediaType.APPLICATION_JSON_VALUE)
    public GenericResponse create(@RequestBody PetDTO pet) {
        PetDTO petsaved = petstoreService.save(pet);
        return BaseController.getResponse(true, null, null, petsaved, HttpStatus.CREATED);
    }

    // Actualizar Mascota
    @PutMapping(value = "/pet", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> update(@RequestBody Pet pet) {
        ResponseEntity<Object> response = null;
        response = u.buildResponseEntity(HttpStatus.NO_CONTENT, pet);
        return response;
    }

    // Buscar Macota por estatus
    @GetMapping(value = "/pet", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findByStatus(@RequestParam String status) {
        ResponseEntity<Object> response = null;
        Pet pet = petstoreService.findByStatus(status);
        response = u.buildResponseEntity(HttpStatus.OK, pet);
        return response;
    }

    // Buscar Macota por id
    @GetMapping(value = "/pet/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        ResponseEntity<Object> response = null;
        Pet pet = petstoreService.findById(id);
        response = u.buildResponseEntity(HttpStatus.OK, pet);
        return response;
    }

    // Actualiza mascota en base a su ID
    @PostMapping(value = "/pet/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateById(@RequestBody Pet pet, @PathVariable int id) {
        ResponseEntity<Object> response = null;
        response = u.buildResponseEntity(HttpStatus.OK, pet);
        return response;
    }

}
