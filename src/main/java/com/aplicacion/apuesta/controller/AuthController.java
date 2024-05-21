package com.aplicacion.apuesta.controller;

import com.aplicacion.apuesta.dto.LoginData;
import com.aplicacion.apuesta.dto.TokenData;
import com.aplicacion.apuesta.service.LoginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private LoginServices loginServices;

    @PostMapping
    public ResponseEntity<TokenData> login(@RequestBody LoginData loginData) {
        TokenData token=loginServices.login(loginData);
        return ResponseEntity.ok(token);
    }




}
