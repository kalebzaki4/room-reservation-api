package com.kalebzaki.syncspace.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public record ErroRespostaDTO(
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime timestamp,

        int status,
        String erro,
        String mensagem
) {
    public ErroRespostaDTO(int status, String erro, String mensagem) {
        this(LocalDateTime.now(), status, erro, mensagem);
    }
}