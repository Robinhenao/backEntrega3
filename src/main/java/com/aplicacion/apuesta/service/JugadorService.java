package com.aplicacion.apuesta.service;

import com.aplicacion.apuesta.dto.JugadorData;
import com.aplicacion.apuesta.dto.RegistroJugadorData;
import com.aplicacion.apuesta.entity.Jugador;
import com.aplicacion.apuesta.entity.Role;
import com.aplicacion.apuesta.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JugadorService  {
    @Autowired
    JugadorRepository jugadorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public JugadorData registrarJugador(RegistroJugadorData registroJugadorData) {
        Jugador jugador = new Jugador(
                registroJugadorData.nombre(),
                registroJugadorData.apellido(),
                registroJugadorData.identificacion(),
                registroJugadorData.telefono(),
                registroJugadorData.correoElectronico(),
                passwordEncoder.encode(registroJugadorData.contrasena()),
                Role.USER
        );
        jugador = jugadorRepository.save(jugador);
        return new JugadorData(jugador);
    }

    public JugadorData getJugadorById(Long id) {
        Jugador jugador = jugadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado con id: " + id));
        return new JugadorData(jugador);
    }

    public List<JugadorData> getJugadores() {
        return jugadorRepository.findAll().stream().map(JugadorData::new).toList();
    }



}
