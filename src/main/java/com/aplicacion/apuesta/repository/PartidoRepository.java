package com.aplicacion.apuesta.repository;

import com.aplicacion.apuesta.entity.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartidoRepository extends JpaRepository<Partido, Long> {
    Partido findByIdPartido(Long id);
}
