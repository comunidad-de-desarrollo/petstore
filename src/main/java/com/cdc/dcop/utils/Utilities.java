package com.cdc.dcop.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.cdc.dcop.models.Pet;

public class Utilities {
	
    public ResponseEntity<Object> buildResponseEntity(HttpStatus status, Pet pet) {
        return new ResponseEntity<Object>(pet, status);
    }

}
