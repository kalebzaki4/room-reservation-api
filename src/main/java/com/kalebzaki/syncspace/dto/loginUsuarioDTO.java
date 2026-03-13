package com.kalebzaki.syncspace.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record loginUsuarioDTO(
        @NotBlank
        String nome,
        @NotBlank @Email String email,
        @NotBlank
        String senha) {
}
