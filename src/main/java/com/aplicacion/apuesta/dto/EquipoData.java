package com.aplicacion.apuesta.dto;

import com.aplicacion.apuesta.entity.Equipo;
import com.aplicacion.apuesta.entity.JugadorEquipo;

import java.util.List;

public record EquipoData(
        Long idEquipo,
        String nombre,
        Boolean estado,
        List<JugadorEquipoData> jugadores
) {
    public EquipoData(Equipo equipo, List<JugadorEquipo> jugadores) {
        this(
                equipo.getIdEquipo(),
                equipo.getNombre(),
                equipo.getEstado(),
                jugadores.stream().map(JugadorEquipoData::new).toList());
    }
}
