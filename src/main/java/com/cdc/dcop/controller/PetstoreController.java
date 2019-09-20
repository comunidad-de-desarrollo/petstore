package com.cdc.dcop.controller;


import com.cdc.dcop.entity.Pet;
import com.cdc.dcop.services.PetstoreService;
import com.cdc.dcop.utils.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pet")
public class PetstoreController {

    Utilities u = new Utilities();

    @Autowired
    private PetstoreService petstoreService;

    // Agregar Mascota
    @PostMapping(value = "/pet", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody Pet pet) {
        ResponseEntity<Object> response = null;
        petstoreService.savePet(pet);
        response = u.buildResponseEntity(HttpStatus.CREATED, pet);
        return response;
    }

    // Actualizar Mascota
    @PutMapping(value = "/pet", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> update(@RequestBody Pet pet) {
        ResponseEntity<Object> response = null;
        petstoreService.updatePet(pet);
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
    public ResponseEntity<Object> findById(@PathVariable long id) {
        ResponseEntity<Object> response = null;
        Pet pet = petstoreService.findById(id);
        response = u.buildResponseEntity(HttpStatus.OK, pet);
        return response;
    }

}
