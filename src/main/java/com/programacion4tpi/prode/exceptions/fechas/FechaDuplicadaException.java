package com.programacion4tpi.prode.exceptions.fechas;

import com.programacion4tpi.prode.exceptions.CustomException;
import org.springframework.http.HttpStatus;
import java.net.URI;


public class FechaDuplicadaException extends CustomException {

    public FechaDuplicadaException(String message) {
        super(message, HttpStatus.BAD_REQUEST, null, URI.create("/errors/bad-request-fecha"), null);
    }
}