package com.aplicacion.apuesta.controller;


import com.aplicacion.apuesta.dto.PartidoData;
import com.aplicacion.apuesta.dto.RegistroPartidoData;
import com.aplicacion.apuesta.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partido")
@CrossOrigin("*")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    @PostMapping("/registrar")
    public PartidoData registrarPartido(@RequestBody RegistroPartidoData registroPartidoData) {
        return partidoService.registrarPartido(registroPartidoData);
    }

    @GetMapping("/{id}")
    public PartidoData getPartidoById(@PathVariable Long id) {
        return partidoService.getPartidoById(id);
    }

    @GetMapping
    public List<PartidoData> getPartidos() {
        return partidoService.getPartidos();
    }
}
