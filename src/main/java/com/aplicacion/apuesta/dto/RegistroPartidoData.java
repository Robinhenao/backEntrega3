package com.aplicacion.apuesta.dto;

import com.aplicacion.apuesta.entity.Equipo;

import java.util.Date;

public record RegistroPartidoData(
        Date fechaInicio,
        String lugar,
        String estado,
        Long arbitro,
        Boolean apuesta,
        Long equipo1,
        Long equipo2
) {
}
