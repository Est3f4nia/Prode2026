package com.programacion4tpi.prode.feature.pronostico.dtos.request;


public record PronosticoCreateRequestDto(
        Long partidoId,
        Integer golesLocalPredicho,
        Integer golesVisitantePredicho
) {}
