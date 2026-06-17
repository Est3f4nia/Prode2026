package com.programacion4tpi.prode.feature.pronostico.services;

import com.programacion4tpi.prode.exceptions.global.BadRequestException;
import com.programacion4tpi.prode.exceptions.global.UnauthorizedException;
import com.programacion4tpi.prode.feature.partido.models.Partido;
import com.programacion4tpi.prode.feature.partido.repository.ValidatePartido;
import com.programacion4tpi.prode.feature.pronostico.IPronosticoRepository;
import com.programacion4tpi.prode.feature.pronostico.PronosticoMapper;
import com.programacion4tpi.prode.feature.pronostico.dtos.req.PronosticoRequestDto;
import com.programacion4tpi.prode.feature.pronostico.dtos.resp.PronosticoResponseDto;
import com.programacion4tpi.prode.feature.pronostico.models.Pronostico;
import com.programacion4tpi.prode.feature.pronostico.services.interfaces.IPronosticoPostService;
import com.programacion4tpi.prode.feature.usuario.models.Usuario;
import com.programacion4tpi.prode.feature.usuario.services.domain.ValidateUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class PronosticoPostService implements IPronosticoPostService {

    private final IPronosticoRepository repository;
    private final ValidateUser validateUser;
    private final ValidatePartido validatePartido;
    private final PronosticoMapper mapper;

    @Override
    public PronosticoResponseDto create(PronosticoRequestDto dto) {
        // falta validar 30' antes partido

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new UnauthorizedException("Usuario no autenticado");
        }

        String email = authentication.getName();
        Usuario usuario = validateUser.validateUserByEmail(email);
        Partido partido = validatePartido.validatePartidoById(dto.partidoId());

        if (repository.existsByUsuarioIdAndPartidoId(usuario.getId(), dto.partidoId())) {
            throw new BadRequestException("Ya existe un pronóstico para este partido");
        }

        Pronostico pronostico = mapper.toEntity(dto);
        pronostico.setUsuario(usuario);
        pronostico.setPartido(partido);

        Pronostico saved = repository.save(pronostico);
        return mapper.toDto(saved);
    }
}