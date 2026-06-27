package com.programacion4tpi.prode.feature.fecha.dtos.response;

import com.programacion4tpi.prode.feature.fecha.models.enums.EstadoFecha;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FechaResponseDto {

    private Long id;
    private String nombre;
    private EstadoFecha estado;

}
