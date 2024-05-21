package com.aplicacion.apuesta.dto;

import java.util.Date;

public record RegistroPartidoData(
        Date fechaInicio,
        String lugar,
        String estado,
        Long arbitro,
        Boolean apuesta
) {
}
