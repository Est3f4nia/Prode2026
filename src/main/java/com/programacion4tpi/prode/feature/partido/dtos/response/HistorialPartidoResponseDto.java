package com.programacion4tpi.prode.feature.partido.dtos.response;

import com.programacion4tpi.prode.feature.partido.models.enums.ResultadoPartido;
import lombok.*;

import java.time.Instant;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class HistorialPartidoResponseDto {
    private Long partidoId;
    private String equipoLocal;
    private String equipoVisitante;
    private Integer golesLocal;
    private Integer golesVisitante;
    private ResultadoPartido resultado;
    private Instant fechaHoraInicio;
}