package com.kalebzaki.syncspace.dto;

import jakarta.validation.constraints.NotBlank;

public record UsuarioExclusaoDTO(
        @NotBlank(message = "O email é obrigatório")
        String email,
        @NotBlank(message = "O nome de usuário é obrigatório")
        String senha) {
}
