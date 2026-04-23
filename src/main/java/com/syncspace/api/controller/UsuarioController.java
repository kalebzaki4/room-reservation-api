package com.syncspace.api.controller;

import com.syncspace.api.service.UsuarioService;
import com.syncspace.api.model.Usuario;
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

    // ver todos os ususarios
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioService.findAllUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    // Criar usuario
    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario createdUsuario = usuarioService.createUsuario(usuario);
        return ResponseEntity.status(201).body(createdUsuario);
    }

    // atualizar usuario
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario dadosUsuario) {
        dadosUsuario.setId(id);
        Usuario usuarioAtualizado = usuarioService.updateUsuario(dadosUsuario);
        return usuarioAtualizado != null ? ResponseEntity.ok(usuarioAtualizado) : ResponseEntity.notFound().build();

    }

    // deletar usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }
}

