package com.aplicacion.apuesta.controller;

import com.aplicacion.apuesta.dto.PartidoData;
import com.aplicacion.apuesta.dto.RegistroPartidoData;
import com.aplicacion.apuesta.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partido")
@CrossOrigin("*")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    @PostMapping
    public ResponseEntity<PartidoData> registrarPartido(@RequestBody RegistroPartidoData registroPartidoData) {
        PartidoData partidoData = partidoService.registrarPartido(registroPartidoData);
        return ResponseEntity.ok(partidoData);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartidoData> getPartidoById(@PathVariable Long id) {
        PartidoData partidoData = partidoService.getPartidoById(id);
        return ResponseEntity.ok(partidoData);
    }

    @GetMapping
    public ResponseEntity<List<PartidoData>> getPartidos() {
        List<PartidoData> partidos = partidoService.getPartidos();
        return ResponseEntity.ok(partidos);
    }
}
