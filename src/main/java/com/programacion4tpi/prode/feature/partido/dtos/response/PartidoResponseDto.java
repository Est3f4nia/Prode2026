package com.programacion4tpi.prode.feature.partido.dtos.response;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PartidoResponseDto {
    private Long id;
    private String fechaNombre;
    private String equipoLocalNombre;
    private String equipoVisitanteNombre;
    private Instant fechaHoraInicio;
    private String estado;
}
