package com.aplicacion.apuesta.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "jugador")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jugador")
    private Long idJugador;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private  String identificacion;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false, name = "correo_electronico")
    private String correoElectronico;

    @Column(nullable = false)
    private String contrasena;




    public Jugador(String nombre, String apellido, String identificacion, String telefono, String correoElectronico, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;

    }
}
