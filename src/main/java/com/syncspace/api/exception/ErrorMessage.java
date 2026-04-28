package com.syncspace.api.exception;

import java.time.LocalDateTime;

public class ErrorMessage {
    private LocalDateTime timestamp;
    private int status;
    private String message;

    public ErrorMessage(LocalDateTime timestamp, int status, String message) {
        this.timestamp = timestamp;
        this.status = status;

        this.message = message;
    }
}