package tech.devinhouse.ex05;

public class Pessoa {

  protected String nome;
  protected String sobrenome;

  protected String obterNomeCompleto(){
    return nome + " " + sobrenome;
  }
}
