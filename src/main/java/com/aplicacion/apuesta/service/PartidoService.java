package com.aplicacion.apuesta.service;

import com.aplicacion.apuesta.dto.PartidoData;
import com.aplicacion.apuesta.dto.RegistroPartidoData;
import com.aplicacion.apuesta.entity.Partido;
import com.aplicacion.apuesta.repository.EquipoRepository;
import com.aplicacion.apuesta.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidoService {

    @Autowired
    PartidoRepository partidoRepository;

    @Autowired
    EquipoRepository equipoRepository;


    public PartidoData registrarPartido(RegistroPartidoData registroPartidoData) {
        Partido partido = new Partido(
                registroPartidoData.fechaInicio(),
                registroPartidoData.lugar(),
                registroPartidoData.estado(),
                registroPartidoData.arbitro(),
                registroPartidoData.apuesta(),
                registroPartidoData.equipo1(),
                registroPartidoData.equipo2()
        );
        partido = partidoRepository.save(partido);
        return new PartidoData(partido);
    }

    public PartidoData getPartidoById(Long id){
        Partido partido = this.partidoRepository.findByIdPartido(id);
        return new PartidoData(partido);
    }

    public List<PartidoData> getPartidos() {
        return this.partidoRepository.findAll().stream().map(PartidoData::new).toList();
    }
}
