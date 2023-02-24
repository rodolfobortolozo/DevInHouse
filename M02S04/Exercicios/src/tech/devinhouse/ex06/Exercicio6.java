package tech.devinhouse.ex06;

import tech.devinhouse.ex04.Exercicio04;

public class Exercicio6 {

  public void validar(String valorCampo, Integer valorMaxCampo) throws TamanhoInvalidoException {

    if(valorCampo == null || valorMaxCampo == null || valorMaxCampo<0){
      throw  new IllegalArgumentException();
    }

    if(valorCampo.length() > valorMaxCampo){
      throw new TamanhoInvalidoException();
    }

  }

  public static void main(String[] args) {
    Exercicio6 exercicio06 = new Exercicio6();

    try {
      exercicio06.validar("Rodolfo", 7);
    } catch (TamanhoInvalidoException | IllegalArgumentException e) {
      System.out.println("Deu ruim");;
    }
    System.out.println("Deu certo");
  }
}
