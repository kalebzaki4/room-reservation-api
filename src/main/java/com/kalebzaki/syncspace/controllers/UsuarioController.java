package com.kalebzaki.syncspace.controllers;

import com.kalebzaki.syncspace.dto.UsuarioRequestDTO;
import com.kalebzaki.syncspace.models.Usuario;
import com.kalebzaki.syncspace.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<Usuario> usuarios = usuarioService.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping
    public ResponseEntity salvarUsuario(@RequestBody @Valid UsuarioRequestDTO dadosUsuario) {
        this.usuarioService.salvarUsuario(dadosUsuario);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUsuario(@PathVariable Long id) {
        this.usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity updateUsuario(@RequestBody @Valid UsuarioRequestDTO dadosUsuario) {
        this.usuarioService.updateUsuario(dadosUsuario);
        return ResponseEntity.ok().build();
    }
}

