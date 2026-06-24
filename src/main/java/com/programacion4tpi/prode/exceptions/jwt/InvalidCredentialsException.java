package com.programacion4tpi.prode.exceptions.jwt;

import com.programacion4tpi.prode.exceptions.CustomException;
import org.springframework.http.HttpStatus;

import java.net.URI;
import java.util.List;

public class InvalidCredentialsException extends CustomException {

    public InvalidCredentialsException(String message) {
        super(message, HttpStatus.UNAUTHORIZED, null, URI.create("/errors/unauthorized"), null);
    }
}
