package com.programacion4tpi.prode.feature.usuario.services.domain.interfaces;

import com.programacion4tpi.prode.feature.usuario.models.Usuario;

public interface IValidateUser {
    Usuario validateUserByEmail(String email);
    Usuario getAuthenticatedUserSession();
}
