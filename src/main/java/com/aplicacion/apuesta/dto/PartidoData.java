package com.aplicacion.apuesta.dto;


import com.aplicacion.apuesta.entity.Equipo;
import com.aplicacion.apuesta.entity.Partido;

import java.util.Date;

public record PartidoData(
        Date fechaInicio,
        String lugar,
        String estado,
        Long arbitro,
        Boolean apuesta,
        Long equipo1,
        Long equipo2

) {
    public PartidoData(Partido partido) {
        this(
                partido.getFechaInicio(),
                partido.getLugar(),
                partido.getEstado(),
                partido.getArbitro(),
                partido.getApuesta(),
                partido.getEquipo1(),
                partido.getEquipo2()

        );
    }
}
