package com.kalebzaki.syncspace.services;

import com.kalebzaki.syncspace.dto.UsuarioRequestDTO;
import com.kalebzaki.syncspace.exceptions.ResourceNotFoundException;
import com.kalebzaki.syncspace.models.Usuario;
import com.kalebzaki.syncspace.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Transactional
    public Usuario salvarUsuario(UsuarioRequestDTO dados) {
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(dados.nome());
        novoUsuario.setEmail(dados.email());
        novoUsuario.setSenha(dados.senha());

        return usuarioRepository.save(novoUsuario);
    }

    @Transactional
    public void deleteUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(STR."Ops! Não encontramos o usuário com o ID: " + id));

        usuarioRepository.delete(usuario);
    }

    @Transactional
    public void updateUsuario(@Valid UsuarioRequestDTO dadosUsuario) {
        Usuario usuario = usuarioRepository.findById(dadosUsuario.id()).orElseThrow(() -> new ResourceNotFoundException("Ops! Não encontramos o usuário"));
        usuario.setNome(dadosUsuario.nome());
        usuario.setEmail(dadosUsuario.email());
        usuario.setSenha(dadosUsuario.senha());
        usuarioRepository.save(usuario);
    }
}
