package com.aplicacion.apuesta.service;


import com.aplicacion.apuesta.dto.LoginData;
import com.aplicacion.apuesta.dto.TokenData;
import com.aplicacion.apuesta.repository.JugadorRepository;
import com.aplicacion.apuesta.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class LoginServices   {

    private final JugadorRepository jugadorRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public TokenData login(LoginData request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username(), request.password()));
        UserDetails user=jugadorRepository.findByCorreoElectronico(request.username());
        String token=jwtService.getToken(user);
        return new  TokenData(token);
    }


}
