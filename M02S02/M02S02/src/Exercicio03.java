import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Scanner;

public class Exercicio03 {
  public static void main(String[] args) {
    double[] notas = new double[2];
    double soma =0;
    double media =0;

    Scanner scanner = new Scanner(System.in);

    for (int i=0; i<=1; i++){
      System.out.println("Informe uma nota");
      notas[i] = scanner.nextDouble();
      soma += notas[i];
    }

    media = soma / notas.length;

    if(media>=7){
      System.out.println("Aprovado");
    }else{
      System.out.println("Reprovado");
    }


    Scanner scannerCor = new Scanner(System.in);
    System.out.println("Digite uma Cor:");
    String cor = scannerCor.next();

    switch (cor){
      case "Vermelho":
        System.out.println("D5eve Parar o Carro");
        break;

      case "Amarelo":
        System.out.println("Deve Finalizar Travessia");
        break;

      case "Verde":
        System.out.println("Pode Passar");
        break;

      default:
        System.out.println("Digite uma Cor Valida");
    }

    float altura = 1.82f;
    float peso = 136f;
    float imc = peso / (altura * altura);

    if(imc < 18.5){
      System.out.println(imc+ "Magreza");
    }else if (imc <= 24.9){
      System.out.println(imc+ "Normal");
    } else if (imc < 29.9) {
      System.out.println(imc+ "Sobrepeso");
    } else if (imc <= 39.9) {
      System.out.println(imc+ "Obesidade");
    }else {
      System.out.println(imc+ "Obesidade Grave");
    }

  }
}
