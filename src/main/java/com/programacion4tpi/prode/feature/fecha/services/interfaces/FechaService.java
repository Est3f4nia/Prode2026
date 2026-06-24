package com.programacion4tpi.prode.feature.fecha.services.interfaces;

import com.programacion4tpi.prode.feature.fecha.dtos.request.FechaRequestDto;
import com.programacion4tpi.prode.feature.fecha.dtos.response.FechaResponseDto;
import com.programacion4tpi.prode.feature.fecha.models.enums.EstadoPartido;
import com.programacion4tpi.prode.feature.fecha.models.Fecha;

import java.util.List;

public interface FechaService {

    FechaResponseDto crear(FechaRequestDto dto);

    List<FechaResponseDto> listar();

    void actualizarEstadoFecha(
            Fecha fecha,
            List<EstadoPartido> estados
    );
}