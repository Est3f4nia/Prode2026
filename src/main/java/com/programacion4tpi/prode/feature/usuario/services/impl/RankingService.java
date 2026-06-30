package com.programacion4tpi.prode.feature.usuario.services.impl;

import com.programacion4tpi.prode.feature.usuario.dtos.response.RankingResponseDto;
import com.programacion4tpi.prode.feature.usuario.models.Usuario;
import com.programacion4tpi.prode.feature.usuario.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RankingService {

    private final UsuarioRepository usuarioRepository;

    public List<RankingResponseDto> obtenerRanking() {
        return usuarioRepository.findAll().stream()
                .map(usuario -> RankingResponseDto.builder()
                        .usuarioId(usuario.getId())
                        .usuarioNombre(usuario.getUsername())
                        .puntosTotal(usuario.getPuntosTotales())
                        .planosExactos(usuario.getResultadosExactos())
                        .build())
                .sorted((a, b) -> {
                    // Ordenar por puntos totales descendente
                    int compareByPuntos = Integer.compare(b.getPuntosTotal(), a.getPuntosTotal());
                    if (compareByPuntos != 0) {
                        return compareByPuntos;
                    }
                    // Luego por plenos exactos descendente
                    return Integer.compare(b.getPlanosExactos(), a.getPlanosExactos());
                })
                .collect(Collectors.toList());
    }
}
