package com.kalebzaki.syncspace.dto;

public record StandardError(
        Long timestamp,
        Integer status,
        String error,
        String message,
        String path
) {}
