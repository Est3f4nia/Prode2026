package com.programacion4tpi.prode.feature.pronostico.dtos.req;


public record PronosticoRequestDto(
        Long partidoId,
        Integer golesLocalPredicho,
        Integer golesVisitantePredicho
) {}
