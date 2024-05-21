package com.aplicacion.apuesta.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "role")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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
}
