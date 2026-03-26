package com.kalebzaki.syncspace.services;

import com.kalebzaki.syncspace.dto.UsuarioAtualizacaoDTO;
import com.kalebzaki.syncspace.dto.AutenticacaoDTO;
import com.kalebzaki.syncspace.infra.exceptions.ResourceNotFoundException; // ⬅️ O Import corrigido aqui!
import com.kalebzaki.syncspace.models.Usuario;
import com.kalebzaki.syncspace.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public Usuario salvarUsuario(AutenticacaoDTO dados) {
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(dados.nome());
        novoUsuario.setEmail(dados.email());
        novoUsuario.setSenha(dados.senha());

        return usuarioRepository.save(novoUsuario);
    }

    @Transactional
    public void deleteUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ops! Não encontramos o usuário com o ID: " + id));

        usuarioRepository.delete(usuario);
    }

    @Transactional
    public void updateUsuario(Long id, @Valid UsuarioAtualizacaoDTO dadosUsuario) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ops! Não encontramos o usuário"));
        usuario.setNome(dadosUsuario.nome());
        usuario.setEmail(dadosUsuario.email());
        usuario.setSenha(dadosUsuario.senha());
        usuarioRepository.save(usuario);
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ops! Não encontramos o usuário com o ID: " + id));
    }
}