package com.kalebzaki.syncspace.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AtualizarSalaDTO(
        @NotBlank(message = "O nome é obrigatório")
        String nome,

        @NotNull(message = "A capacidade é obrigatória")
        @Positive(message = "A capacidade deve ser maior que zero")
        Integer capacidade,

        @NotBlank(message = "A localidade é obrigatória")
        String localidade,

        @NotNull(message = "A versão é obrigatória")
        Long versao,

        @NotNull(message = "O ID é obrigatório")
        Long id
) {
}