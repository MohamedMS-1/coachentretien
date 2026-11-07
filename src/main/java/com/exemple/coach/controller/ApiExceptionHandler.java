package com.exemple.coach.controller;
import com.exemple.coach.exception.AucunDocumentException;
import com.exemple.coach.exception.ReponseModeleInvalideException;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class ApiExceptionHandler {
    private ResponseEntity<Map<String, String>> erreur(HttpStatus statut, String message) {
        return ResponseEntity.status(statut).body(Map.of("erreur", String.valueOf(message)));
    }
    @ExceptionHandler(IllegalArgumentException.class)
    ResponseEntity<Map<String, String>> requeteInvalide(IllegalArgumentException e) {
        return erreur(HttpStatus.BAD_REQUEST, e.getMessage());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<Map<String, String>> validation(MethodArgumentNotValidException e) {
        String detail = e.getBindingResult().getFieldErrors().stream()
                .map(f -> f.getField() + " : " + f.getDefaultMessage())
                .collect(Collectors.joining(" ; "));
        return erreur(HttpStatus.BAD_REQUEST, detail);
    }
    @ExceptionHandler(AucunDocumentException.class)
    ResponseEntity<Map<String, String>> aucunDocument(AucunDocumentException e) {
        return erreur(HttpStatus.NOT_FOUND, e.getMessage());
    }
    @ExceptionHandler(ReponseModeleInvalideException.class)
    ResponseEntity<Map<String, String>> modeleInvalide(ReponseModeleInvalideException e) {
        return erreur(HttpStatus.BAD_GATEWAY, e.getMessage());
    }
}