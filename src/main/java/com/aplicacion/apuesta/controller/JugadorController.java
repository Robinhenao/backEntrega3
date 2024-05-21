package com.aplicacion.apuesta.controller;

import com.aplicacion.apuesta.dto.JugadorData;
import com.aplicacion.apuesta.dto.RegistroJugadorData;
import com.aplicacion.apuesta.service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/jugador")
@CrossOrigin("*")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    @PostMapping
    public ResponseEntity<JugadorData> registrarJugador(@RequestBody RegistroJugadorData registroJugadorData) {
        JugadorData jugadorData = jugadorService.registrarJugador(registroJugadorData);
        return ResponseEntity.ok(jugadorData);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JugadorData> getJugadorById(@PathVariable Long id) {
        JugadorData jugadorData=jugadorService.getJugadorById(id);
        return ResponseEntity.ok(jugadorData);
    }

    @GetMapping
    public ResponseEntity<List<JugadorData>> getJugadores() {
        List<JugadorData>  jugadorData= jugadorService.getJugadores();
        return ResponseEntity.ok(jugadorData);
    }

}
