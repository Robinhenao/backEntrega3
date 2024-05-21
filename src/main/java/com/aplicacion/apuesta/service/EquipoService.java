package com.aplicacion.apuesta.service;


import com.aplicacion.apuesta.dto.EquipoData;
import com.aplicacion.apuesta.dto.RegistroEquipoData;
import com.aplicacion.apuesta.entity.Equipo;
import com.aplicacion.apuesta.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {
    @Autowired
    EquipoRepository equipoRepository;

    public EquipoData registrarEquipo(RegistroEquipoData registroEquipoData) {
        Equipo equipo= new Equipo(
                registroEquipoData.nombre(),
                registroEquipoData.estado()
        );
        equipo = this.equipoRepository.save(equipo);
        return new EquipoData(equipo);
    }

    public EquipoData getEquipoById(Long id){
        Equipo equipo = this.equipoRepository.findByIdEquipo(id);
        return new EquipoData(equipo);
    }

    public List<EquipoData> getEquipos() {
        return this.equipoRepository.findAll().stream().map(EquipoData::new).toList();
    }

}
