package com.programacion4tpi.prode.exceptions.equipo;

import com.programacion4tpi.prode.exceptions.CustomException;
import org.springframework.http.HttpStatus;
import java.net.URI;


public class ConflictException extends CustomException {

    public ConflictException(String message) {
        super(message, HttpStatus.CONFLICT, null, URI.create("/errors/conflict"), null);
    }
}