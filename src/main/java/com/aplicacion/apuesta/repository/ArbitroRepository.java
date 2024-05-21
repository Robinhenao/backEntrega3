package com.aplicacion.apuesta.repository;

import com.aplicacion.apuesta.entity.Arbitro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public  interface ArbitroRepository extends JpaRepository<Arbitro, Long> {
    Arbitro   findByCorreoElectronico(String correoElectronico);

    Arbitro findByIdArbitro(Long id);
}
