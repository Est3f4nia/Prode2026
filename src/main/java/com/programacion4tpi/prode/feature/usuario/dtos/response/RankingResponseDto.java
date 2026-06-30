package com.programacion4tpi.prode.feature.usuario.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RankingResponseDto {
    private Long usuarioId;
    private String usuarioNombre;
    private Integer puntosTotal;
    private Integer planosExactos;
}
