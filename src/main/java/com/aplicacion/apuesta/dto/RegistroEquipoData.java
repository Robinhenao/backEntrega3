package com.aplicacion.apuesta.dto;

import java.util.List;

public record RegistroEquipoData(
        String nombre,
        Boolean estado,
        List<Long> idsJugadores
) {
}

