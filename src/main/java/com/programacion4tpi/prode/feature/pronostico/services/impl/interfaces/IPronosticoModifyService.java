package com.programacion4tpi.prode.feature.pronostico.services.impl.interfaces;

import com.programacion4tpi.prode.feature.pronostico.dtos.request.PronosticoModifyRequestDto;
import com.programacion4tpi.prode.feature.pronostico.dtos.response.PronosticoResponseDto;

public interface IPronosticoModifyService {
    PronosticoResponseDto actualizarPronostico(PronosticoModifyRequestDto dto);
}
