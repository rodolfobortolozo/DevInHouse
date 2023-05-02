package tech.devinhouse.veiculos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Veiculos {

  @Id()
  private String placa;

  private String tipo;

  private String cor;

  private Integer anoDeFabricacao;

  private Integer qtdMultas;
}
