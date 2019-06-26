package com.cdc.dcop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdc.dcop.models.Pet;
import com.cdc.dcop.services.IPetstoreService;
import com.cdc.dcop.utils.Utilities;

@RestController
@RequestMapping("/petstore")
public class PetstoreController {

	Utilities u = new Utilities();

	@Autowired
	private IPetstoreService petstoreService;

	// Agregar Mascota
	@PostMapping(value = "/pet", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(@RequestBody Pet pet) {
		ResponseEntity<Object> response = null;
		response = u.buildResponseEntity(HttpStatus.CREATED, pet);
		return response;
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
	public ResponseEntity<Object> findById(@PathVariable int id) {
		ResponseEntity<Object> response = null;
		Pet pet = petstoreService.findById(id);
		response = u.buildResponseEntity(HttpStatus.OK, pet);
		return response;
	}

}
