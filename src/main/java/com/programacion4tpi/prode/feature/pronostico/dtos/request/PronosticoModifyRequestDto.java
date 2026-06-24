package com.programacion4tpi.prode.feature.pronostico.dtos.request;

public record PronosticoModifyRequestDto(
        Long partidoId,
        Integer golesLocalPredicho,
        Integer puntosOtorgados
) {}
