package com.kalebzaki.syncspace.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CriacaoSalaDTO(
        @NotBlank (message = "O nome é obrigatório")
        String nome,
        @NotNull ( message = "A capacidade é obrigatória")
        @Positive (message = "A capacidade deve ser maior que zero")
        Integer capacidade,
        @NotBlank (message = "O local é obrigatório")
        String localidade
) {
}
