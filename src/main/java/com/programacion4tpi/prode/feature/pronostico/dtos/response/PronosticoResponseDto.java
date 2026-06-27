package com.programacion4tpi.prode.feature.pronostico.dtos.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record PronosticoResponseDto(
        Long id,
        Long usuarioId,
        Long partidoId,
        Integer golesLocalPredicho,
        Integer golesVisitantePredicho,
        Integer puntosOtorgados,
        LocalDateTime fechaCreacion
) {}
