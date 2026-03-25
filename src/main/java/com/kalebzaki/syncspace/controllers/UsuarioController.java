package com.kalebzaki.syncspace.controllers;

import com.kalebzaki.syncspace.dto.UsuarioAtualizacaoDTO;
import com.kalebzaki.syncspace.dto.AutenticacaoDTO;
import com.kalebzaki.syncspace.models.Usuario;
import com.kalebzaki.syncspace.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        return ResponseEntity.ok(usuario);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<Usuario> usuarios = usuarioService.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @PostMapping
    public ResponseEntity salvarUsuario(@RequestBody @Valid AutenticacaoDTO dadosUsuario, UriComponentsBuilder uriBuilder) {
        Usuario usuarioSalvo = usuarioService.salvarUsuario(dadosUsuario);
        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuarioSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(usuarioSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUsuario(@PathVariable Long id) {
        this.usuarioService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUsuario(@PathVariable Long id, @RequestBody @Valid UsuarioAtualizacaoDTO dadosUsuario) {
        this.usuarioService.updateUsuario(id, dadosUsuario);
        return ResponseEntity.ok().build();
    }
}

