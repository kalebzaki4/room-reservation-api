package com.syncspace.api.exception;

public class HttpMessageNotReadableException extends RuntimeException {
    public HttpMessageNotReadableException(String message) {
        super(message);
    }
}
