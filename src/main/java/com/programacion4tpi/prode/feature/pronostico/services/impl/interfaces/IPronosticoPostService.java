package com.programacion4tpi.prode.feature.pronostico.services.impl.interfaces;

import com.programacion4tpi.prode.feature.pronostico.dtos.request.PronosticoCreateRequestDto;
import com.programacion4tpi.prode.feature.pronostico.dtos.response.PronosticoResponseDto;

public interface IPronosticoPostService {
    PronosticoResponseDto create(PronosticoCreateRequestDto dto);
}
