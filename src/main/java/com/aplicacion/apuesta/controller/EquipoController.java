package com.aplicacion.apuesta.controller;

import com.aplicacion.apuesta.dto.EquipoData;
import com.aplicacion.apuesta.dto.RegistroEquipoData;
import com.aplicacion.apuesta.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipo")
@CrossOrigin("*")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;


    @PostMapping
    public ResponseEntity<EquipoData> registrarEquipo(@RequestBody RegistroEquipoData registroEquipoData) {
        EquipoData equipoData = equipoService.registrarEquipo(registroEquipoData);
        return ResponseEntity.ok(equipoData);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipoData> getEquipoById(@PathVariable Long id) {
        EquipoData equipoData = equipoService.getEquipoById(id);
        return  ResponseEntity.ok(equipoData);
    }

    @GetMapping
    public ResponseEntity<List<EquipoData>> getEquipos() {
        List<EquipoData> equipoData = equipoService.getEquipos();
        return ResponseEntity.ok(equipoData);
    }
}
