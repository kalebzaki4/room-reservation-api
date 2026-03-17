package com.kalebzaki.syncspace.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioRequestDTO(
        @NotBlank
        String nome,
        @NotBlank @Email String email,
        @NotBlank
        String senha,
        @NotNull
        Long id) {

}