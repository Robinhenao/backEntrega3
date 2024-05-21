package com.aplicacion.apuesta.controller;

import com.aplicacion.apuesta.dto.EquipoData;
import com.aplicacion.apuesta.dto.RegistroEquipoData;
import com.aplicacion.apuesta.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipo")
@CrossOrigin("*")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    @PostMapping
    public EquipoData registrarEquipo(@RequestBody RegistroEquipoData registroEquipoData) {
        return equipoService.registrarEquipo(registroEquipoData);
    }

    @GetMapping("/{id}")
    public EquipoData getEquipoById(@PathVariable Long id) {
        return equipoService.getEquipoById(id);
    }

    @GetMapping
    public List<EquipoData> getEquipos() {
        return equipoService.getEquipos();
    }
}
