package com.aplicacion.apuesta.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Getter
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    public Role(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Role(String nombre) {
        this.nombre = nombre;
    }
}
