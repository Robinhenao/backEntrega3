package com.aplicacion.apuesta.controller;
import com.aplicacion.apuesta.entity.Arbitro;
import com.aplicacion.apuesta.security.SecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired

    private final AuthenticationManager authenticationManager;

    private final SecurityFilter securityFilter;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, SecurityFilter securityFilter) {
        this.authenticationManager = authenticationManager;
        this.securityFilter = securityFilter;
    }

    @PostMapping("/Rpartido")
    public ResponseEntity<String> login(@RequestBody Arbitro request) {


        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(request.getCorreoElectronico(),
                request.getContrasena());
        System.out.println(login.isAuthenticated());
        Authentication authentication = this.authenticationManager.authenticate(login);

        System.out.println("Hola Mundos");
        return ResponseEntity.ok("Hola mundo");

    }


}
