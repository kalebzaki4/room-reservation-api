package com.kalebzaki.syncspace.exceptions;

import com.kalebzaki.syncspace.dto.ErroRespostaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 404
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErroRespostaDTO> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErroRespostaDTO erro = new ErroRespostaDTO(
                LocalDateTime.now(),
                404,
                "Not Found",
                ex.getMessage()
        );
        return ResponseEntity.status(404).body(erro);
    }

    // 400
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroRespostaDTO> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        String mensagem = ex.getFieldErrors().stream()
                .map(erro -> erro.getField() + ": " + erro.getDefaultMessage())
                .collect(Collectors.joining(", "));

        ErroRespostaDTO erro = new ErroRespostaDTO(
                LocalDateTime.now(),
                400,
                "Requisição Inválida",
                mensagem
        );

        return ResponseEntity.badRequest().body(erro);
    }
}
