package com.aplicacion.apuesta.repository;

import com.aplicacion.apuesta.entity.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public   interface JugadorRepository extends JpaRepository<Jugador, Long> {
    Jugador findByCorreoElectronico(String correoElectronico);
}
