package com.kalebzaki.syncspace.dto;

import jakarta.validation.constraints.NotBlank;

public record AutenticacaoDTO(
        @NotBlank(message = "Nome é obrigatório")
        String nome,
        @NotBlank (message = "Email é obrigatório")
        String email,
        @NotBlank (message = "Senha é obrigatória")
        String senha) {
}
