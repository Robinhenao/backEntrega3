package com.aplicacion.apuesta.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "arbitro")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Arbitro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_arbitro")
    private Long idArbitro;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private  String identificacion;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false ,name = "correo_electronico")
    private String correoElectronico;

    @Column(nullable = false)
    private String contrasena;

    public Arbitro(String nombre, String apellido, String identificacion, String telefono, String correoElectronico, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
    }
}
