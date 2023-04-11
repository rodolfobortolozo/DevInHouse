package tech.devinhouse.locadora.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TabelaPrecoRequest {
  private Long id;
  @NotBlank(message = "{msg.not.blank}")
  private String descricao;
  @NotNull(message = "{vlr.not.null}")
  private Double vlrLocacao;
}
