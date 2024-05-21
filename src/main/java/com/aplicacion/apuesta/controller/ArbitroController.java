package com.aplicacion.apuesta.controller;

import com.aplicacion.apuesta.dto.ArbitroData;
import com.aplicacion.apuesta.dto.RegistroArbitroData;
import com.aplicacion.apuesta.entity.Arbitro;
import com.aplicacion.apuesta.service.ArbitroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/arbitro")
@CrossOrigin("*")
public class ArbitroController {

    @Autowired
    private ArbitroService arbitroService;

    @PostMapping
    public ResponseEntity<ArbitroData> registrarArbitro(@RequestBody RegistroArbitroData registroArbitroData) {
        ArbitroData arbitroData = arbitroService.registrarArbitro(registroArbitroData);
        return ResponseEntity.ok(arbitroData);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArbitroData> getArbitroById(@PathVariable Long id) {
        ArbitroData arbitroData = arbitroService.getArbitroById(id);
        return ResponseEntity.ok(arbitroData);
    }

    @GetMapping
    public ResponseEntity<List<ArbitroData>> getArbitros() {
        List<ArbitroData> arbitros = arbitroService.getArbitros();
        return ResponseEntity.ok(arbitros);
    }

}
