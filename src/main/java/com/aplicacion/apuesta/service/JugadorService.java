package com.aplicacion.apuesta.service;

import com.aplicacion.apuesta.dto.JugadorData;
import com.aplicacion.apuesta.dto.RegistroJugadorData;
import com.aplicacion.apuesta.entity.Jugador;
import com.aplicacion.apuesta.entity.Role;
import com.aplicacion.apuesta.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JugadorService implements UserDetailsService {
    @Autowired
    JugadorRepository jugadorRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    public JugadorData registrarJugador(RegistroJugadorData registroJugadorData) {
        Jugador jugador = new Jugador(
                registroJugadorData.nombre(),
                registroJugadorData.apellido(),
                registroJugadorData.identificacion(),
                registroJugadorData.telefono(),
                registroJugadorData.correoElectronico(),
                passwordEncoder.encode(registroJugadorData.contrasena()),
                Arrays.asList(new Role("ROLE_JUGADOR"))
        );
        jugador = jugadorRepository.save(jugador);
        return new JugadorData(jugador);
    }

    public JugadorData getJugadorById(Long id) {
        Jugador jugador = jugadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Jugador no encontrado con id: " + id));
        return new JugadorData(jugador);
    }

    public List<JugadorData> getJugadores() {
        return jugadorRepository.findAll().stream().map(JugadorData::new).toList();
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Jugador jugador = jugadorRepository.findBycorreoElectronico();
        if (jugador == null) {
            throw new UsernameNotFoundException("Usuario o password inválidos");
        }
        return new User(jugador.getCorreoElectronico(),jugador.getContrasena(),mapearAutoridadesRoles(jugador.getRole()));
    }

    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }



}
