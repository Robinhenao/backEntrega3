package com.aplicacion.apuesta.dto;

import com.aplicacion.apuesta.entity.Arbitro;

public record ArbitroData(
        String nombre,
        String apellido,
        String identificacion,
        String telefono,
        String correoElectronico
) {
    public ArbitroData(Arbitro arbitro) {
        this(
                arbitro.getNombre(),
                arbitro.getApellido(),
                arbitro.getIdentificacion(),
                arbitro.getTelefono(),
                arbitro.getCorreoElectronico());

    }
}
