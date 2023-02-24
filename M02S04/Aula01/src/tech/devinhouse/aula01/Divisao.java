package tech.devinhouse.aula01;

public class Divisao implements Operacao{
  @Override
  public Double calcular(Double num1, Double num2) {
    return num1/num2;
  }

  @Override
  public String getDescricao() {
    return "Divisão";
  }
}
