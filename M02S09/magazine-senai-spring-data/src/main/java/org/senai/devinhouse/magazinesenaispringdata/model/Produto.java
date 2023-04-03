package org.senai.devinhouse.magazinesenaispringdata.model;


import jakarta.persistence.*;

@Entity(name = "PRODUTOS")
public class Produto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private String descricao;
  private Double preco;

  @Column(name = "QTDESTOQUE")
  private Double qtdEstoque;

  @ManyToOne
  @JoinColumn(name = "idcategoria")
  private Categoria categoria;


}
