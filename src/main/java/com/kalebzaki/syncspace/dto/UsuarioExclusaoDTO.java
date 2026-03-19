package com.kalebzaki.syncspace.dto;

import jakarta.validation.constraints.NotBlank;

public record UsuarioExclusaoDTO(
        @NotBlank
        String email,
        @NotBlank
        String senha) {
}
