package com.programacion4tpi.prode.feature.usuario.services.domain;

import com.programacion4tpi.prode.exceptions.jwt.UnauthorizedException;
import com.programacion4tpi.prode.exceptions.jwt.UserNotFoundException;
import com.programacion4tpi.prode.feature.usuario.models.Usuario;
import com.programacion4tpi.prode.feature.usuario.repository.UsuarioRepository;
import com.programacion4tpi.prode.feature.usuario.services.domain.interfaces.IValidateUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *  Pensado para validar usuario desde otra feature
 */

@Service
@AllArgsConstructor
public class ValidateUser implements IValidateUser {

    private final UsuarioRepository repository;

    @Override
    public Usuario validateUserByEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));
    }

    @Override
    public Usuario getAuthenticatedUserSession() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new UnauthorizedException("Usuario no autenticado");
        }

        return validateUserByEmail(authentication.getName());
    }
}
