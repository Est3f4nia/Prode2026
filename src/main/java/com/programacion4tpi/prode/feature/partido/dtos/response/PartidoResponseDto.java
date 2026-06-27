package com.programacion4tpi.prode.feature.partido.dtos.response;

import lombok.*;
import java.time.Instant;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class PartidoResponseDto {
    private Long id;
    private String fechaNombre;
    private Long equipoLocalId;
    private String equipoLocalNombre;
    private String equipoLocalEscudo;
    private Long equipoVisitanteId;
    private String equipoVisitanteNombre;
    private String equipoVisitanteEscudo;
    private Instant fechaHoraInicio;
    private String estado;
    private Integer golesLocal;
    private Integer golesVisitante;
    private String resultado;
}