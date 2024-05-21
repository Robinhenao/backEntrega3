package com.aplicacion.apuesta.repository;

import com.aplicacion.apuesta.entity.JugadorEquipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JugadorEquipoRepository extends JpaRepository<JugadorEquipo, Long> {

    List<JugadorEquipo> findByEquipo(Long idEquipo);
}
