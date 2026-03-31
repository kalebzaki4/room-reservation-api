package com.kalebzaki.syncspace.services;

import com.kalebzaki.syncspace.dto.UsuarioAtualizacaoDTO;
import com.kalebzaki.syncspace.dto.AutenticacaoDTO;
import com.kalebzaki.syncspace.infra.exception.ResourceNotFoundException;
import com.kalebzaki.syncspace.models.Usuario;
import com.kalebzaki.syncspace.repositories.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder; // Adicionado
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails usuario = usuarioRepository.findByEmail(username);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return usuario;
    }

    @Transactional
    public Usuario salvarUsuario(AutenticacaoDTO dados) {
        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(dados.nome());
        novoUsuario.setEmail(dados.email());

        String senhaCriptografada = passwordEncoder.encode(dados.senha());
        novoUsuario.setSenha(senhaCriptografada);

        return usuarioRepository.save(novoUsuario);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Transactional
    public void deleteUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ops! Não encontramos o usuário com o ID: " + id));
        usuarioRepository.delete(usuario);
    }

    @Transactional
    public void updateUsuario(Long id, @Valid UsuarioAtualizacaoDTO dadosUsuario) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ops! Não encontramos o usuário"));

        usuario.setNome(dadosUsuario.nome());
        usuario.setEmail(dadosUsuario.email());

        usuario.setSenha(passwordEncoder.encode(dadosUsuario.senha()));

        usuarioRepository.save(usuario);
    }

    public Usuario findById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ops! Não encontramos o usuário com o ID: " + id));
    }
}