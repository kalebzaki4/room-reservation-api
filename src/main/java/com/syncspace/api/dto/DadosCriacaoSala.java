package com.syncspace.api.dto;

public record DadosCriacaoSala(
        String nome,
        String descricao,
        Integer quantidade,
        Integer tempoExpiracao) {
}
