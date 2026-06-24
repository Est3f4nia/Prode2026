package com.programacion4tpi.prode.feature.pronostico.services.impl;

import com.programacion4tpi.prode.exceptions.global.BadRequestException;
import com.programacion4tpi.prode.exceptions.jwt.UnauthorizedException;
import com.programacion4tpi.prode.feature.partido.models.Partido;
import com.programacion4tpi.prode.feature.partido.services.domain.ValidatePartido;
import com.programacion4tpi.prode.feature.pronostico.repository.IPronosticoRepository;
import com.programacion4tpi.prode.feature.pronostico.mappers.PronosticoMapper;
import com.programacion4tpi.prode.feature.pronostico.dtos.request.PronosticoModifyRequestDto;
import com.programacion4tpi.prode.feature.pronostico.dtos.response.PronosticoResponseDto;
import com.programacion4tpi.prode.feature.pronostico.models.Pronostico;
import com.programacion4tpi.prode.feature.pronostico.services.impl.interfaces.IPronosticoModifyService;
import com.programacion4tpi.prode.feature.usuario.models.Usuario;
import com.programacion4tpi.prode.feature.usuario.services.domain.ValidateUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
@AllArgsConstructor
public class PronosticoModifyService implements IPronosticoModifyService {

    private final IPronosticoRepository repository;
    private final ValidateUser validateUser;
    private final ValidatePartido validatePartido;
    private final PronosticoMapper mapper;

    @Override
    @Transactional
    public PronosticoResponseDto actualizarPronostico(PronosticoModifyRequestDto dto) {

        // hacer esto más dry
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new UnauthorizedException("Usuario no autenticado");
        }

        String email = authentication.getName();
        Usuario usuario = validateUser.validateUserByEmail(email);
        Partido partido = validatePartido.validatePartidoById(dto.partidoId());

        Instant ahora = Instant.now();
        if (!ahora.isBefore(partido.getFechaHoraInicio().minus(30, ChronoUnit.MINUTES))) {
            throw new BadRequestException(
                    "No se pueden realizar pronósticos cuando faltan menos de 30 minutos para el partido"
            );
        }

        Pronostico pronostico = repository
                .findByUsuarioIdAndPartidoId(usuario.getId(), partido.getId())
                .orElseThrow(() ->
                        new BadRequestException("No existe un pronóstico para este partido")
                );

        pronostico.setGolesLocalPredicho(dto.golesLocalPredicho());
        pronostico.setGolesVisitantePredicho(dto.golesLocalPredicho());

        Pronostico actualizado = repository.save(pronostico);

        return mapper.toDto(actualizado);
    }
}
