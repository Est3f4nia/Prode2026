package com.programacion4tpi.prode.feature.usuario.dtos.response;


public record AuthResponseDto(
        Long id,
        String accessToken,
        String refreshToken,
        String tokenType,
        long expiresInMs,
        String email,
        String rol
) {}