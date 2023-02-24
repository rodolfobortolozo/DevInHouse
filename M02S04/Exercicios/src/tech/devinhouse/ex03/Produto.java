package tech.devinhouse.ex03;

public class Produto implements Tributavel{

  Double valor;
  Double valorImposto;

  @Override
  public Double calcularValorComImposto() {
    return valor+valorImposto;
  }
}
