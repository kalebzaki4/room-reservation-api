package com.syncspace.api.service;

import com.syncspace.api.repository.UsuarioRepository;
import com.syncspace.api.model.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // ver todos os usuarios
    public List<Usuario> findAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // criar usuario
    @Transactional
    public Usuario createUsuario(Usuario usuario) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(usuario.getEmail());
        if (optionalUsuario.isPresent()) {
            throw new RuntimeException("Email já cadastrado");
        }
        String senha = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senha);
        return usuarioRepository.save(usuario);
    }

    // atualizar ususario
    @Transactional
    public Usuario updateUsuario(Usuario usuario) {
        Usuario usuarioAtualizado = usuarioRepository.findById(usuario.getId()).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuarioAtualizado.setEmail(usuario.getEmail());
        usuarioAtualizado.setNome(usuario.getNome());
        usuarioAtualizado.setSenha(usuario.getSenha());
        return usuarioRepository.save(usuarioAtualizado);

    }

    // deletar usuario
    public void deleteUsuario(Long usuario) {
        Usuario usuarioDeletado = usuarioRepository.findById(usuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuarioRepository.delete(usuarioDeletado);
    }
}
