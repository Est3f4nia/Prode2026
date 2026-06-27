package com.programacion4tpi.prode.feature.pronostico.services.domain.interfaces;

import com.programacion4tpi.prode.feature.partido.models.Partido;

public interface PuntuacionService {
    void calcularYAsignarPuntos(Partido partido);
}