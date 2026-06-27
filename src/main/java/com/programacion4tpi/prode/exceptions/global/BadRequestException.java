package com.programacion4tpi.prode.exceptions.global;

import com.programacion4tpi.prode.exceptions.CustomException;
import org.springframework.http.HttpStatus;

import java.net.URI;
import java.util.List;

// tener en cuenta para las demás excepciones

public class BadRequestException extends CustomException {

    public BadRequestException(String message) {
        super(message, HttpStatus.BAD_REQUEST, null,
                URI.create("/errors/bad-request"), null);
    }

    public BadRequestException(String message, List<String> errors) {
        super(message, HttpStatus.BAD_REQUEST, errors,
                URI.create("/errors/bad-request"), null);
    }
}
