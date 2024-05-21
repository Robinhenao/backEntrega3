package com.aplicacion.apuesta.dto;

import com.aplicacion.apuesta.entity.Jugador;
import com.aplicacion.apuesta.entity.Role;

import java.util.Collection;


public record JugadorData(
        String nombre,
        String apellido,
        String identificacion,
        String telefono,
        String correoElectronico



) {
    public JugadorData(Jugador jugador) {
        this(
                jugador.getNombre(),
                jugador.getApellido(),
                jugador.getIdentificacion(),
                jugador.getTelefono(),
                jugador.getCorreoElectronico()
        );

    }
}
