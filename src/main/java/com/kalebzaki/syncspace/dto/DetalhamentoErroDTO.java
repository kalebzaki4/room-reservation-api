package com.kalebzaki.syncspace.dto;

import java.time.LocalDateTime;

public record DetalhamentoErroDTO(
        LocalDateTime timestamp,
        int status,
        String erro,
        String mensagem
) {
}