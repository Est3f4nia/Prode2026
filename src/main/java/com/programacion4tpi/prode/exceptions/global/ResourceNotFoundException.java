package com.programacion4tpi.prode.exceptions.global;

import com.programacion4tpi.prode.exceptions.CustomException;
import org.springframework.http.HttpStatus;

import java.net.URI;
import java.util.List;

public class ResourceNotFoundException extends CustomException {

    public ResourceNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND, null, URI.create("/errors/not-found"), null);
    }

    public ResourceNotFoundException(String message, List<String> errors) {
        super(message, HttpStatus.NOT_FOUND, errors, URI.create("/errors/unauthorized"), null);
    }
}