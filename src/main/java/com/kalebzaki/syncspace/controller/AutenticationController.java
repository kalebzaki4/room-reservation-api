package com.kalebzaki.syncspace.controller;

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
@RequestMapping("/auth")
public class AutenticationController {

    private final AuthenticationManager authenticationManager;

    @Autowired
    public AutenticationController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping
    public ResponseEntity<String> Autentication(@Valid @RequestBody AutenticacaoDTO dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.email(), dados.password());
        var authentication = authenticationManager.authenticate(token);

        return ResponseEntity.ok().build();
    }
}
