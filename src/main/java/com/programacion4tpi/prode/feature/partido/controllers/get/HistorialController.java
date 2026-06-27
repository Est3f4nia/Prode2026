package com.programacion4tpi.prode.feature.partido.controllers.get;

import com.programacion4tpi.prode.config.BaseResponse;
import com.programacion4tpi.prode.feature.partido.dtos.response.HistorialPartidoResponseDto;
import com.programacion4tpi.prode.feature.partido.services.impl.intefaces.PartidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
@RequiredArgsConstructor
public class HistorialController {

    private final PartidoService partidoService;

    @GetMapping("/{equipoId}/historial")
    public ResponseEntity<BaseResponse<List<HistorialPartidoResponseDto>>> getHistorial(
            @PathVariable Long equipoId) {

        List<HistorialPartidoResponseDto> historial = partidoService.getHistorialByEquipo(equipoId);
        return ResponseEntity.ok(BaseResponse.ok(historial, "Historial obtenido correctamente"));
    }
}