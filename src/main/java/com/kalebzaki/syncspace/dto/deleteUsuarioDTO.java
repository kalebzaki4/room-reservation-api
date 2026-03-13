package com.kalebzaki.syncspace.dto;

import jakarta.validation.constraints.NotBlank;

public record deleteUsuarioDTO(
        @NotBlank
        String email,
        @NotBlank
        String senha) {
}
