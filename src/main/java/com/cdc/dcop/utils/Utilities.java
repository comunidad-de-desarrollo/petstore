package com.cdc.dcop.utils;

import com.cdc.dcop.models.Pet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Utilities {

    public ResponseEntity<Object> buildResponseEntity(HttpStatus status, Pet pet) {
        return new ResponseEntity<Object>(pet, status);
    }

    public static final String EMPTY_RESPONSE_SUCCESS = "OK";
    public static final String PROCESS_SUCCESS = "Todo de manera exitosa";
    public static final String REQUEST_SUCCESS = "Peticion exitosa";
    public static final String REQUEST_NO_SUCCESS = "Petición no exitosa";
}
