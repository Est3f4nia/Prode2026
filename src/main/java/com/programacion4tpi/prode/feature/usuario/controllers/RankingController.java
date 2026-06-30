package com.programacion4tpi.prode.feature.usuario.controllers;

import com.programacion4tpi.prode.feature.usuario.dtos.response.RankingResponseDto;
import com.programacion4tpi.prode.feature.usuario.services.impl.RankingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ranking")
@AllArgsConstructor
public class RankingController {

    private final RankingService rankingService;

    @GetMapping
    public ResponseEntity<List<RankingResponseDto>> obtenerRanking() {
        return ResponseEntity.ok(rankingService.obtenerRanking());
    }
}
