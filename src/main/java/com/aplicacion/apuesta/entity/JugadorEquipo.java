package com.aplicacion.apuesta.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "jugador_equipo")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class JugadorEquipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jugador_Equipo")
    private Long jugadorEquipo;

    @Column(nullable = false)
    private Long jugador;

    @Column(nullable = false)
    private Long equipo;

    public JugadorEquipo(Long jugador, Long equipo) {
        this.jugador = jugador;
        this.equipo = equipo;
    }
}
