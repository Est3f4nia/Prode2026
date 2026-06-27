package com.programacion4tpi.prode.feature.partido.services.impl;

import com.programacion4tpi.prode.config.TimeConfig;
import com.programacion4tpi.prode.exceptions.global.BadRequestException;
import com.programacion4tpi.prode.exceptions.global.ResourceNotFoundException;
import com.programacion4tpi.prode.feature.equipo.models.Equipo;
import com.programacion4tpi.prode.feature.equipo.repository.EquipoRepository;
import com.programacion4tpi.prode.feature.fecha.models.Fecha;
import com.programacion4tpi.prode.feature.fecha.repository.FechaRepository;
import com.programacion4tpi.prode.feature.fecha.services.interfaces.IFechaService;
import com.programacion4tpi.prode.feature.partido.dtos.request.CargarResultadoRequestDto;
import com.programacion4tpi.prode.feature.partido.dtos.request.PartidoCreateRequestDto;
import com.programacion4tpi.prode.feature.partido.dtos.request.PartidoUpdateRequestDto;
import com.programacion4tpi.prode.feature.partido.dtos.response.HistorialPartidoResponseDto;
import com.programacion4tpi.prode.feature.partido.dtos.response.PartidoResponseDto;
import com.programacion4tpi.prode.feature.partido.mappers.PartidoMapper;
import com.programacion4tpi.prode.feature.partido.models.Partido;
import com.programacion4tpi.prode.feature.partido.models.enums.EstadoPartido;
import com.programacion4tpi.prode.feature.partido.models.enums.ResultadoPartido;
import com.programacion4tpi.prode.feature.partido.repository.PartidoRepository;
import com.programacion4tpi.prode.feature.partido.services.impl.intefaces.PartidoService;
import com.programacion4tpi.prode.feature.pronostico.services.domain.interfaces.PuntuacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PartidoServiceImpl implements PartidoService {

    private final PartidoRepository partidoRepository;
    private final FechaRepository fechaRepository;
    private final EquipoRepository equipoRepository;
    private final PartidoMapper partidoMapper;
    private final PuntuacionService puntuacionService;
    private final IFechaService fechaService;
    private final Clock clock;

    @Override
    @Transactional
    public PartidoResponseDto update(Long id, PartidoUpdateRequestDto dto) {

        Partido existing = partidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Partido no encontrado"));

        Long localIdFinal = dto.getEquipoLocalId() != null
                ? dto.getEquipoLocalId() : existing.getEquipoLocal().getId();
        Long visitanteIdFinal = dto.getEquipoVisitanteId() != null
                ? dto.getEquipoVisitanteId() : existing.getEquipoVisitante().getId();

        validarEquiposDistintos(localIdFinal, visitanteIdFinal);

        if (dto.getFechaId() != null) {
            Fecha fecha = fechaRepository.findById(dto.getFechaId())
                    .orElseThrow(() -> new ResourceNotFoundException("Fecha no encontrada"));
            existing.setFecha(fecha);
        }

        if (dto.getEquipoLocalId() != null) {
            Equipo local = equipoRepository.findById(dto.getEquipoLocalId())
                    .orElseThrow(() -> new ResourceNotFoundException("Equipo local no encontrado"));
            existing.setEquipoLocal(local);
        }

        if (dto.getEquipoVisitanteId() != null) {
            Equipo visitante = equipoRepository.findById(dto.getEquipoVisitanteId())
                    .orElseThrow(() -> new ResourceNotFoundException("Equipo visitante no encontrado"));
            existing.setEquipoVisitante(visitante);
        }

        if (dto.getFechaHoraInicio() != null) {

            LocalDateTime localDateTime = dto.getFechaHoraInicio();

            Instant inicio = localDateTime
                    .atZone(TimeConfig.ZONE)
                    .toInstant();

            if (inicio.isBefore(Instant.now(clock))) {
                throw new BadRequestException("La fecha de inicio debe ser futura.");
            }

            existing.setFechaHoraInicio(inicio);
        }

        if (dto.getEstado() != null) {
            existing.setEstado(dto.getEstado());
        }

        if (dto.getGolesLocal() != null || dto.getGolesVisitante() != null) {

            Integer golesLocal = dto.getGolesLocal() != null
                    ? dto.getGolesLocal()
                    : existing.getGolesLocal();

            Integer golesVisitante = dto.getGolesVisitante() != null
                    ? dto.getGolesVisitante()
                    : existing.getGolesVisitante();

            existing.setResultado(determinarResultado(golesLocal, golesVisitante));
        }

        Partido updated = partidoRepository.save(existing);

        Fecha fechaActual = updated.getFecha();
        List<EstadoPartido> estados = partidoRepository.findByFechaId(fechaActual.getId())
                .stream()
                .map(Partido::getEstado)
                .toList();
        fechaService.actualizarEstadoFecha(fechaActual, estados);

        return partidoMapper.toResponseDto(updated);
    }

    @Override
    @Transactional
    public PartidoResponseDto create(PartidoCreateRequestDto dto) {
        validarEquiposDistintos(dto.getEquipoLocalId(), dto.getEquipoVisitanteId());

        if (partidoRepository.existePartidoEnFechaEntreEquipos(
                dto.getFechaId(), dto.getEquipoLocalId(), dto.getEquipoVisitanteId())) {
            throw new BadRequestException(
                    "Ya existe un partido entre estos equipos en la fecha seleccionada.");
        }

        Fecha fecha = fechaRepository.findById(dto.getFechaId())
                .orElseThrow(() -> new ResourceNotFoundException("Fecha no encontrada"));

        Equipo local = equipoRepository.findById(dto.getEquipoLocalId())
                .orElseThrow(() -> new ResourceNotFoundException("Equipo local no encontrado"));

        Equipo visitante = equipoRepository.findById(dto.getEquipoVisitanteId())
                .orElseThrow(() -> new ResourceNotFoundException("Equipo visitante no encontrado"));

        LocalDateTime localDateTime = dto.getFechaHoraInicio();
        Instant inicio = localDateTime.atZone(TimeConfig.ZONE).toInstant();

        if (inicio.isBefore(Instant.now(clock))) {
            throw new BadRequestException("La fecha de inicio debe ser futura.");
        }

        Partido partido = partidoMapper.toEntity(dto, fecha, local, visitante);
        return partidoMapper.toResponseDto(partidoRepository.save(partido));
    }

    @Override
    @Transactional(readOnly = true)
    public List<PartidoResponseDto> listar() {
        return partidoRepository.findAll().stream()
                .map(partidoMapper::toResponseDto)
                .toList();
    }

    @Override
    @Transactional
    public PartidoResponseDto cargarResultado(Long id, CargarResultadoRequestDto dto) {

        Partido partido = partidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Partido no encontrado"));

        if (partido.getEstado() != EstadoPartido.EN_JUEGO) {
            throw new BadRequestException(
                    "Solo se puede cargar resultado de un partido en estado EN_JUEGO");
        }

        partido.setGolesLocal(dto.getGolesLocal());
        partido.setGolesVisitante(dto.getGolesVisitante());
        partido.setResultado(determinarResultado(dto.getGolesLocal(), dto.getGolesVisitante()));
        partido.setEstado(EstadoPartido.FINALIZADO);

        Partido saved = partidoRepository.save(partido);
        puntuacionService.calcularYAsignarPuntos(saved);

        Fecha fechaActual = saved.getFecha();
        List<EstadoPartido> estados = partidoRepository.findByFechaId(fechaActual.getId())
                .stream()
                .map(Partido::getEstado)
                .toList();
        fechaService.actualizarEstadoFecha(fechaActual, estados);

        return partidoMapper.toResponseDto(saved);
    }

    @Override
    @Transactional(readOnly = true)
    public List<HistorialPartidoResponseDto> getHistorialByEquipo(Long equipoId) {

        equipoRepository.findById(equipoId)
                .orElseThrow(() -> new ResourceNotFoundException("Equipo no encontrado"));

        List<Partido> partidos = partidoRepository.findHistorialByEquipoId(equipoId);

        return partidos.stream()
                .map(p -> HistorialPartidoResponseDto.builder()
                        .partidoId(p.getId())
                        .equipoLocal(p.getEquipoLocal().getNombre())
                        .equipoVisitante(p.getEquipoVisitante().getNombre())
                        .golesLocal(p.getGolesLocal())
                        .golesVisitante(p.getGolesVisitante())
                        .resultado(p.getResultado())
                        .fechaHoraInicio(p.getFechaHoraInicio())
                        .build())
                .toList();
    }

    // --- Helpers ---

    private ResultadoPartido determinarResultado(Integer golesLocal, Integer golesVisitante) {
        if (golesLocal > golesVisitante) return ResultadoPartido.LOCAL;
        if (golesLocal < golesVisitante) return ResultadoPartido.VISITANTE;
        return ResultadoPartido.EMPATE;
    }

    private void validarEquiposDistintos(Long equipoLocalId, Long equipoVisitanteId) {
        if (equipoLocalId.equals(equipoVisitanteId)) {
            throw new BadRequestException(
                    "El equipo local y el equipo visitante no pueden ser el mismo.");
        }
    }

    // --- Tasks ---

    @Scheduled(fixedRate = 10000)
    @Transactional
    public void iniciarPartidos() {
        Instant ahora = Instant.now(clock);

        List<Partido> partidos = partidoRepository
                .findByEstadoAndFechaHoraInicioLessThanEqual(
                        EstadoPartido.POR_JUGARSE,
                        ahora
                );

        partidos.forEach(p -> p.setEstado(EstadoPartido.EN_JUEGO));
    }
}