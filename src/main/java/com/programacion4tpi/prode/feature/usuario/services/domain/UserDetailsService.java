package com.programacion4tpi.prode.feature.usuario.services.domain;

import com.programacion4tpi.prode.feature.usuario.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final UsuarioRepository userRepository;

    /**
     * Para simplificar: se modifica loadUserByUsername para que reciba un mail
     */

    @Override
    public UserDetails loadUserByUsername(@NonNull String mail) throws UsernameNotFoundException {

        return userRepository.findByEmail(mail)
                .orElseThrow(() ->
                        new UsernameNotFoundException("Usuario no encontrado"));
    }
}