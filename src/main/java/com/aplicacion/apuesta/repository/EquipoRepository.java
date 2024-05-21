package com.aplicacion.apuesta.repository;

import com.aplicacion.apuesta.entity.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Long> {
    Equipo findByIdEquipo(Long id);
}
