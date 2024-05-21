package com.aplicacion.apuesta.service;

import com.aplicacion.apuesta.dto.ArbitroData;
import com.aplicacion.apuesta.dto.RegistroArbitroData;
import com.aplicacion.apuesta.entity.Arbitro;
import com.aplicacion.apuesta.repository.ArbitroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArbitroService {

    @Autowired
    ArbitroRepository arbitroRepository;

    public ArbitroData registrarArbitro(RegistroArbitroData registroArbitroData) {
        Arbitro arbitro = new Arbitro(
                registroArbitroData.nombre(),
                registroArbitroData.apellido(),
                registroArbitroData.identificacion(),
                registroArbitroData.telefono(),
                registroArbitroData.correoElectronico(),
                registroArbitroData.contrasena()
        );
        arbitro = arbitroRepository.save(arbitro);
        return new ArbitroData(arbitro);
    }

    public ArbitroData getArbitroById(Long id) {
        Arbitro arbitro = arbitroRepository.findByIdArbitro(id);
        return new ArbitroData(arbitro);
    }

    public List<ArbitroData> getArbitros() {
        return arbitroRepository.findAll().stream().map(ArbitroData::new).toList();
    }



}
