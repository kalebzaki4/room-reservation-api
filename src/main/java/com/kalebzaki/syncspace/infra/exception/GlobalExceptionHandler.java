package com.kalebzaki.syncspace.infra.exception;

import com.kalebzaki.syncspace.dto.ErroRespostaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErroRespostaDTO> handleResourceNotFoundException(ResourceNotFoundException ex) {
        var erro = new ErroRespostaDTO(LocalDateTime.now(), 404, "Not Found", ex.getMessage());
        return ResponseEntity.status(404).body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroRespostaDTO> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        var erros = ex.getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        var erro = new ErroRespostaDTO(LocalDateTime.now(), 400, "Requisição Inválida", erros);
        return ResponseEntity.badRequest().body(erro);
    }
}