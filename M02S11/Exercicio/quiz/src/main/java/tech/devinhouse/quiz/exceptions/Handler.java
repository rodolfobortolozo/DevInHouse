package tech.devinhouse.quiz.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class Handler {

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<?> notFound404(){
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<?> notFound400(){
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado");
  }
}
