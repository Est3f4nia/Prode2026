package com.programacion4tpi.prode.feature.usuario.services.domain;

import com.programacion4tpi.prode.exceptions.jwt.UserNotFoundException;
import com.programacion4tpi.prode.feature.usuario.models.Usuario;
import com.programacion4tpi.prode.feature.usuario.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *  Pensado para validar usuario desde otra feature
 */

@Service
@AllArgsConstructor
public class ValidateUser {

    private final UsuarioRepository repository;

    public Usuario validateUserByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));
    }
}
