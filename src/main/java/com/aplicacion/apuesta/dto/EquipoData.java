package com.aplicacion.apuesta.dto;

import com.aplicacion.apuesta.entity.Equipo;

public record EquipoData(
        String nombre,
        Boolean estado
) {
    public EquipoData(Equipo equipo){
        this(equipo.getNombre(), equipo.getEstado());
    }
}
