package com.aplicacion.apuesta.dto;


import com.aplicacion.apuesta.entity.Partido;

import java.util.Date;

public record PartidoData(
        Date fechaInicio,
        String lugar,
        String estado,
        Long arbitro,
        Boolean apuesta
) {
    public PartidoData(Partido partido){
        this(
                partido.getFechaInicio(),
                partido.getLugar(),
                partido.getEstado(),
                partido.getArbitro(),
                partido.getApuesta());
    }
}
