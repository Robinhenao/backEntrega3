package com.aplicacion.apuesta.dto;

import com.aplicacion.apuesta.entity.JugadorEquipo;

public record JugadorEquipoData(
        Long jugadorId,
        Long equipoId) {
    public JugadorEquipoData(JugadorEquipo jugadorEquipo) {
        this(
                jugadorEquipo.getJugador(),
                jugadorEquipo.getEquipo()
        );
    }
}
