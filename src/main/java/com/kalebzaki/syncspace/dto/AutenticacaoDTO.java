package com.kalebzaki.syncspace.dto;

import jakarta.validation.constraints.NotBlank;

public record AutenticacaoDTO(
        @NotBlank
        String nome,
        @NotBlank
        String email,
        @NotBlank
        String senha) {
}
