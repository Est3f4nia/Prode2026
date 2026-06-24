package com.programacion4tpi.prode.feature.partido.dtos.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartidoCreateRequestDto {

    @NotNull(message = "El ID de la fecha es obligatorio")
    @Positive(message = "El ID de la fecha debe ser mayor a 0.")
    private Long fechaId;

    @NotNull(message = "El ID del equipo local es obligatorio")
    @Positive(message = "El ID del equipo debe ser mayor a 0.")
    private Long equipoLocalId;

    @NotNull(message = "El ID del equipo visitante es obligatorio")
    @Positive(message = "El ID del equipo debe ser mayor a 0.")
    private Long equipoVisitanteId;

    @NotNull(message = "La fecha y hora de inicio es obligatoria")
    @Future(message = "La fecha de inicio debe ser futura.")
    private Instant fechaHoraInicio;
}