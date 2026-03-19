package com.kalebzaki.syncspace.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioAtualizacaoDTO(
        @NotBlank
        String nome,
        @NotBlank @Email String email,
        @NotBlank
        String senha,
        @NotNull
        Long id) {
}
