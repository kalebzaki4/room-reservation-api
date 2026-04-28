package com.syncspace.api.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionGlobalHandler {
    // erro 404
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorMessage error = new ErrorMessage(LocalDateTime.now(), 404, ex.getMessage());
        return ResponseEntity.status(404).body(error);
    }

    // erros 400
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleBadRequest(MethodArgumentNotValidException ex) {
        ErrorMessage error = new ErrorMessage(LocalDateTime.now(), 400, "Dados da requisição inválidos.");
        return ResponseEntity.status(400).body(error);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorMessage> handleMalformedJSON(HttpMessageNotReadableException ex) {
        ErrorMessage error = new ErrorMessage(LocalDateTime.now(), 400, "JSON malformado ou erro de leitura.");
        return ResponseEntity.status(400).body(error);
    }


}
