package com.programacion4tpi.prode.feature.partido.services.impl.intefaces;

import com.programacion4tpi.prode.feature.partido.dtos.request.CargarResultadoRequestDto;
import com.programacion4tpi.prode.feature.partido.dtos.request.PartidoCreateRequestDto;
import com.programacion4tpi.prode.feature.partido.dtos.request.PartidoUpdateRequestDto;
import com.programacion4tpi.prode.feature.partido.dtos.response.HistorialPartidoResponseDto;
import com.programacion4tpi.prode.feature.partido.dtos.response.PartidoResponseDto;

import java.util.List;

public interface PartidoService {
    PartidoResponseDto create(PartidoCreateRequestDto dto);
    PartidoResponseDto update(Long id, PartidoUpdateRequestDto dto);
    List<PartidoResponseDto> listar();
    PartidoResponseDto cargarResultado(Long id, CargarResultadoRequestDto dto);
    List<HistorialPartidoResponseDto> getHistorialByEquipo(Long equipoId);
}