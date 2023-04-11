package tech.devinhouse.locadora.core.handler;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ErrorResponse {

  private final String message;
  private final int code;
  private final String status;
  private final String objectName;
  private final List<ErrorObject> errors;
}
