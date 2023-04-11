package tech.devinhouse.locadora.core.handler;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorObject {

  private final String field;
  private final String message;
  private final Object parameter;
}
