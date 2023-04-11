package tech.devinhouse.locadora.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import tech.devinhouse.locadora.model.Categoria;

import java.util.List;

@Data
public class FilmeRequest {

  private Long idFilme;
  @NotBlank
  private String titulo;
  @NotNull
  private Double classificacao;
  private Long idTabpreco;

  private List<Categoria> categorias;
}
