package com.programacion4tpi.prode.feature.fecha.services;

import com.programacion4tpi.prode.exceptions.fechas.FechaDuplicadaException;
import com.programacion4tpi.prode.feature.fecha.dtos.request.FechaRequestDto;
import com.programacion4tpi.prode.feature.fecha.dtos.response.FechaResponseDto;
import com.programacion4tpi.prode.feature.fecha.models.enums.EstadoFecha;
import com.programacion4tpi.prode.feature.fecha.models.enums.EstadoPartido;
import com.programacion4tpi.prode.feature.fecha.models.Fecha;
import com.programacion4tpi.prode.feature.fecha.repository.FechaRepository;
import com.programacion4tpi.prode.feature.fecha.services.interfaces.FechaService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FechaServiceImpl implements FechaService {

    private final FechaRepository fechaRepository;

    @Override
    @Transactional
    public FechaResponseDto crear(FechaRequestDto dto) {

        if (fechaRepository.existsByNombre(dto.getNombre())) {
            throw new FechaDuplicadaException(
                    "Ya existe una fecha con ese nombre"
            );
        }

        Fecha fecha = new Fecha(dto.getNombre());

        Fecha guardada = fechaRepository.save(fecha);

        return mapToResponse(guardada);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FechaResponseDto> listar() {

        return fechaRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    @Transactional
    public void actualizarEstadoFecha(
            Fecha fecha,
            List<EstadoPartido> estados
    ) {

        if (estados.isEmpty()) {
            fecha.setEstado(EstadoFecha.PROGRAMADA);
            return;
        }

        boolean algunoEnJuego = estados.stream()
                .anyMatch(e -> e == EstadoPartido.EN_JUEGO);

        if (algunoEnJuego) {
            fecha.setEstado(EstadoFecha.EN_JUEGO);
            return;
        }

        boolean todosFinalizados = estados.stream()
                .allMatch(e -> e == EstadoPartido.FINALIZADO);

        if (todosFinalizados) {
            fecha.setEstado(EstadoFecha.FINALIZADA);
            return;
        }

        fecha.setEstado(EstadoFecha.PROGRAMADA);
    }

    private FechaResponseDto mapToResponse(Fecha fecha) {

        return new FechaResponseDto(
                fecha.getId(),
                fecha.getNombre(),
                fecha.getEstado()
        );
    }
}