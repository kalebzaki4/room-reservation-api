package com.kalebzaki.syncspace.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AtualizarSalaDTO(
        @NotBlank
        String nome,
        @NotBlank
        Integer cacapacidade,
        @NotBlank
        String localidade,
        @NotBlank
        Long versao,
        @NotNull
        Long id
) {
}
