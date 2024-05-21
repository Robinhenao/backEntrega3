package com.aplicacion.apuesta.controller;
import com.aplicacion.apuesta.entity.Arbitro;
import com.aplicacion.apuesta.security.SecurityFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

/*@RestController
@RequestMapping("/api/api/auth")
@CrossOrigin("*")*/
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private SecurityFilter securityFilter;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody Arbitro request) {
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(request.getCorreoElectronico(),
                request.getContrasena());
        System.out.println(login.isAuthenticated());
        Authentication authentication = this.authenticationManager.authenticate(login);
        return ResponseEntity.ok("Hola mundo");

    }


}
