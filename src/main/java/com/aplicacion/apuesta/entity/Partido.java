package com.aplicacion.apuesta.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "partido")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_partido")
    private Long idPartido;

    @Column(nullable = false, name = "fecha_inicio")
    private Date fechaInicio;

    @Column(nullable = false)
    private String lugar;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private Long arbitro;

    @Column(nullable = false)
    private Boolean apuesta;

    @Column(nullable = false)
    private Long equipo1;

    @Column(nullable = false)
    private Long equipo2;

    public Partido(Date fechaInicio, String lugar, String estado, Long arbitro, Boolean apuesta, Long equipo1, Long equipo2) {
        this.fechaInicio = fechaInicio;
        this.lugar = lugar;
        this.estado = estado;
        this.arbitro = arbitro;
        this.apuesta = apuesta;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }
}
