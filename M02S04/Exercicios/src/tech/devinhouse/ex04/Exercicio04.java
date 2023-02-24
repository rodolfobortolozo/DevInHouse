package tech.devinhouse.ex04;

import java.util.Scanner;

public class Exercicio04 {

  public static void main(String[] args) {
    Exercicio04 exercicio04  = new Exercicio04();

    try {
      Integer idade  = exercicio04.idade();
      System.out.println("Sua idade é:"+idade);
    } catch (IdadeInvalidaException e) {
      System.out.println("Sua idade é inválida");;
    }
  }

  private Integer idade() throws IdadeInvalidaException {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Qual sua idade");
    int idade = scanner.nextInt();
    if(idade<= 0 || idade>100){
      throw new IdadeInvalidaException();
    }
    return idade;
  }

}
