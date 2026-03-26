package com.kalebzaki.syncspace.controllers;

import com.kalebzaki.syncspace.dto.AutenticacaoDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/login")
public class AutenticationController {

    private final AuthenticationManager authenticationManager;

    @Autowired
    public AutenticationController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestBody @Valid AutenticacaoDTO dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.nome(), dados.senha());
        var authentication = authenticationManager.authenticate(token);

        return ResponseEntity.ok().build();
    }
}
