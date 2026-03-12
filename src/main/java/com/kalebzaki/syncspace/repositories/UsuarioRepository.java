package com.kalebzaki.syncspace.repositories;

import com.kalebzaki.syncspace.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}