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

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name="jugador_role",
            joinColumns = @JoinColumn(
                    name = "id_jugador",referencedColumnName = "id_jugador"
            ),
            inverseJoinColumns = @JoinColumn(name = "id_role",referencedColumnName = "id")
    )
    private Collection<Role> role;


    public Jugador(String nombre, String apellido, String identificacion, String telefono, String correoElectronico, String contrasena, Collection<Role> role) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
        this.role = role;
    }
}
