package com.kalebzaki.syncspace.controllers;

import com.kalebzaki.syncspace.models.Usuario;
import com.kalebzaki.syncspace.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity findAll() {
        List<Usuario> usuarios = usuarioService.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping
    public ResponseEntity salvarUsuario(@RequestBody Usuario usuario) {
        Usuario savedUsuario = usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok(savedUsuario);
    }
}

