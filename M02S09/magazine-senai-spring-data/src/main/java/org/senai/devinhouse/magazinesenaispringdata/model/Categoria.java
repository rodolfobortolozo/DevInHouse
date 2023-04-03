package org.senai.devinhouse.magazinesenaispringdata.model;


import jakarta.persistence.*;

@Entity(name = "CATEGORIAS")
public class Categoria {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String categoria;

}
