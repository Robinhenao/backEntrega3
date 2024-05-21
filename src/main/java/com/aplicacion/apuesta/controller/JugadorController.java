package com.aplicacion.apuesta.controller;

import com.aplicacion.apuesta.dto.JugadorData;
import com.aplicacion.apuesta.dto.RegistroJugadorData;
import com.aplicacion.apuesta.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/jugador")
public class JugadorController {

   @Autowired
    private JugadorService jugadorService;

    @PostMapping
    public JugadorData registrarJugador(@RequestBody RegistroJugadorData registroJugadorData) {
        return jugadorService.registrarJugador(registroJugadorData);
    }

    @GetMapping("/{id}")
    public JugadorData getJugadorById(@PathVariable Long id) {
        return jugadorService.getJugadorById(id);
    }

    @GetMapping
    public List<JugadorData> getJugadores() {
        return jugadorService.getJugadores();
    }


}
