package tech.devinhouse.locadora.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity(name="Filme")
@Data
public class Filme {
  @Id
  @Column(name = "IDFILME",  insertable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "TITULO")
  private String titulo;

  @Column(name = "CLASSIFICACAO")
  private Double classificacao;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "IDTABELAPRECO")
  //@JsonIgnore
  private TabelaPreco tabelaPreco;

  @ManyToMany(fetch = FetchType.EAGER
          //cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}
             )
  @JoinTable(
          name = "FILMECATEGORIA",
          joinColumns = @JoinColumn(name = "IDFILME"),
          inverseJoinColumns = @JoinColumn(name = "IDCATEGORIA")
  )
  private List<Categoria> categorias;

}
