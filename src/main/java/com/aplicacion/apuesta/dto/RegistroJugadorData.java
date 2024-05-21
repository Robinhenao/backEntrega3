package com.aplicacion.apuesta.dto;

public record RegistroJugadorData(
        String nombre,
        String apellido,
        String identificacion,
        String telefono,
        String correoElectronico,
        String contrasena
) {
}
