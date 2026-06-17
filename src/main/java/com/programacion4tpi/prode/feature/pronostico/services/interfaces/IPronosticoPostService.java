package com.programacion4tpi.prode.feature.pronostico.services.interfaces;

import com.programacion4tpi.prode.feature.pronostico.dtos.req.PronosticoRequestDto;
import com.programacion4tpi.prode.feature.pronostico.dtos.resp.PronosticoResponseDto;

public interface IPronosticoPostService {
    PronosticoResponseDto create(PronosticoRequestDto dto);
}
