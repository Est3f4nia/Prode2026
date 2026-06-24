package com.programacion4tpi.prode.feature.equipo.services.interfaces;

import com.programacion4tpi.prode.feature.equipo.dtos.request.EquipoCreateRequestDto;
import com.programacion4tpi.prode.feature.equipo.dtos.response.EquipoResponseDto;

import java.util.List;

public interface EquipoService {

    EquipoResponseDto crearEquipo(EquipoCreateRequestDto requestDto);

    List<EquipoResponseDto> listarEquipos();

    EquipoResponseDto obtenerEquipoPorId(Long id);

    void eliminarEquipo(Long id);
}