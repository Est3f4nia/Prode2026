// feature/pronostico/models/Pronostico.java
package com.programacion4tpi.prode.feature.pronostico.models;

import com.programacion4tpi.prode.feature.partido.models.Partido;
import com.programacion4tpi.prode.feature.usuario.models.Usuario;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "pronostico",
        uniqueConstraints = @UniqueConstraint(columnNames = {"usuario_id", "partido_id"})
)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Pronostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partido_id", nullable = false)
    private Partido partido;

    @Column(name = "goles_local_pronosticado", nullable = false)
    private Integer golesLocalPronosticado;

    @Column(name = "goles_visitante_pronosticado", nullable = false)
    private Integer golesVisitantePronosticado;

    @Column(name = "puntos_obtenidos")
    @Builder.Default
    private Integer puntosObtenidos = 0;
}