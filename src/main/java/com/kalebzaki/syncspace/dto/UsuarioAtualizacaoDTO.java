package com.kalebzaki.syncspace.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioAtualizacaoDTO(
        @NotBlank(message = "O nome é obrigatório")
        String nome,
        @NotBlank(message = "O email é obrigatório")
        @Email
        String email,
        @NotBlank(message = "O nome de usuário é obrigatório")
        String senha,
        @NotNull(message = "O ID do usuário é obrigatório")
        Long id) {
}
