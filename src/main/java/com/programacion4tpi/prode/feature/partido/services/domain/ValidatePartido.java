package com.programacion4tpi.prode.feature.partido.services.domain;

import com.programacion4tpi.prode.exceptions.partido.PartidoNotFoundException;
import com.programacion4tpi.prode.feature.partido.models.Partido;
import com.programacion4tpi.prode.feature.partido.repository.PartidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidatePartido {

    private final PartidoRepository repository;

    public Partido validatePartidoById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new PartidoNotFoundException("Partido no encontrado"));
    }

}
