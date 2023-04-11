package tech.devinhouse.locadora.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Entity(name = "TABELAPRECO")
@Data
public class TabelaPreco {

  @Id
  @Column(name="IDTABELAPRECO", insertable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name="DESCRICAO")
  private String descricao;

  @Column(name = "VLRLOCACAO")
  private Double vlrLocacao;


}
