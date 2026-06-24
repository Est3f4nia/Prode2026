package com.programacion4tpi.prode.feature.partido.dtos.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartidoUpdateRequestDto {

    private Long fechaId;
    private Long equipoLocalId;
    private Long equipoVisitanteId;
    private Instant fechaHoraInicio;
    private String estado;
    private Integer golesLocal;
    private Integer golesVisitante;
    private String resultado;
}