package com.aplicacion.apuesta.service;

import com.aplicacion.apuesta.entity.Arbitro;
import com.aplicacion.apuesta.repository.ArbitroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class LoginServices  implements UserDetailsService {

    @Autowired
    private ArbitroRepository arbitroRepository;
    @Override
    public UserDetails loadUserByUsername(String usersName) throws UsernameNotFoundException {

        Arbitro user = arbitroRepository.findByCorreoElectronico(usersName);

        if (user == null) {
            System.out.println("entro al if de user");
            throw new UsernameNotFoundException("User not found");
        }

        return new org.springframework.security.core.userdetails.User(user.getCorreoElectronico(), user.getContrasena(), Collections.emptyList());

    }
}
