package tech.devinhouse.aula01;

import tech.devinhouse.aula01.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
  static Double num1 = 0d;
  static Double num2 = 0d;
  public static void main(String[] args) {

    calcular();

  }

  public static void calcular(){
    Scanner scanner = new Scanner(System.in);
    Operacao operacao = null;
    Integer opcao = null;


    System.out.println("Selecione uma operação");
    System.out.println("1-Multiplicação");
    System.out.println("2-Divisão");
    System.out.println("3-Subtração");
    System.out.println("4-Adição");
    System.out.print("Opção:");

    try {
      opcao = scanner.nextInt();


    }catch (InputMismatchException e){
      System.out.println("Você Digitou uma operação Inválida");
      calcular();
      return;
      }

    switch (opcao) {
      case 1:
        operacao = new Multiplicacao();
        valores();
        break;
      case 2:
        operacao = new Divisao();
        valores();
        break;
      case 3:
        operacao = new Subtracao();
        valores();
        break;
      case 4:
        operacao = new Adicao();
        valores();
        break;
      default:
        System.out.println("Opção não disponivel");
        break;
    }
    try{
      System.out.println( operacao.getDescricao() );
      System.out.println( operacao.calcular(num1,num2) );
    }catch (NullPointerException ignored){

    }

  }

  public static void valores(){
    try {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Digite o número 1");
      num1 = scanner.nextDouble();
      System.out.println("Digite o número 2");
      num2 = scanner.nextDouble();
    }catch (InputMismatchException e){
      System.out.println("Valor Inválido");
      valores();
      return;
    }

  }
}