package com.aplicacion.apuesta.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "equipo")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_equipo")
    private Long idEquipo;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private Boolean estado;

    public Equipo(String nombre, Boolean estado) {
        this.nombre = nombre;
        this.estado = estado;
    }
}
