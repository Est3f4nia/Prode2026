package com.programacion4tpi.prode.feature.usuario.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RegisterRequestDto {
    private String nombre;
    private String email;
    private String password;
}