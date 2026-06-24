package com.programacion4tpi.prode.feature.equipo.dtos.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EquipoCreateRequestDto {

    @NotBlank(message = "El nombre del equipo no puede estar vacío.")
    @Size(max = 50, message = "El nombre no puede superar los 50 caracteres.")
    private String nombre;

    @Size(max = 150, message = "La URL del escudo no puede superar los 150 caracteres.")
    @URL(message = "Debe ingresar una URL válida.")
    private String escudoUrl;
}