package com.aplicacion.apuesta.service;


import com.aplicacion.apuesta.dto.EquipoData;
import com.aplicacion.apuesta.dto.RegistroEquipoData;
import com.aplicacion.apuesta.entity.Equipo;
import com.aplicacion.apuesta.entity.JugadorEquipo;
import com.aplicacion.apuesta.repository.EquipoRepository;
import com.aplicacion.apuesta.repository.JugadorEquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EquipoService {
    @Autowired
    EquipoRepository equipoRepository;

    @Autowired
    JugadorEquipoRepository jugadorEquipoRepository;


    public EquipoData registrarEquipo(RegistroEquipoData registroEquipoData) {
        Equipo equipo = new Equipo(
                registroEquipoData.nombre(),
                registroEquipoData.estado()
        );
        equipo = equipoRepository.save(equipo);

        for (Long jugadorId : registroEquipoData.idsJugadores()) {
            JugadorEquipo jugadorEquipo = new JugadorEquipo(
                    jugadorId,
                    equipo.getIdEquipo()
            );
            jugadorEquipoRepository.save(jugadorEquipo);
        }
        List<JugadorEquipo> jugadores = jugadorEquipoRepository.findByEquipo(equipo.getIdEquipo());
        return new EquipoData(equipo,jugadores);
    }

    public EquipoData getEquipoById(Long id) {
        Equipo equipo = equipoRepository.findByIdEquipo(id);
        List<JugadorEquipo> jugadores = jugadorEquipoRepository.findByEquipo(id);
        return new EquipoData(equipo, jugadores);
    }

    public List<EquipoData> getEquipos() {
        List<Equipo> equipos = equipoRepository.findAll();
        return equipos.stream()
                .map(equipo -> {
                    List<JugadorEquipo> jugadores = jugadorEquipoRepository.findByEquipo(equipo.getIdEquipo());
                    return new EquipoData(equipo, jugadores);
                })
                .collect(Collectors.toList());
    }


}
