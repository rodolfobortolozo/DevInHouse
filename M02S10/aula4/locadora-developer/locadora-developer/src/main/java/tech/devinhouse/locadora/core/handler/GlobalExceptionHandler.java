package tech.devinhouse.locadora.core.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

//@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  //@ExceptionHandler(IllegalArgumentException.class) -- Posso definir meus erros especificos.
  public ResponseEntity handleException(Exception ex){

    HttpStatus codigo = HttpStatus.BAD_REQUEST;
    String mensagem = "Erro ao processar sua mensagem";
    ErrorResponse error = new ErrorResponse(mensagem,400,codigo.toString(),null, null);
    return new ResponseEntity(error, codigo);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,  HttpStatusCode status, WebRequest request) {
    List<ErrorObject> errors = getErrors(ex);
    ErrorResponse errorResponse = getErrorResponse(ex, status, errors);
    return new ResponseEntity<>(errorResponse, status);
  }

  private ErrorResponse getErrorResponse(MethodArgumentNotValidException ex, HttpStatusCode status, List<ErrorObject> errors) {
    return new ErrorResponse("Requisição possui campos inválidos", status.value(),
            status.toString(), ex.getBindingResult().getObjectName(), errors);
  }

  private List<ErrorObject> getErrors(MethodArgumentNotValidException ex) {
    return ex.getBindingResult().getFieldErrors().stream()
            .map(error -> new ErrorObject(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))
            .collect(Collectors.toList());
  }

}
