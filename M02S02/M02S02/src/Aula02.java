import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aula02 {

  public static void main(String[] args) {

    //List<Integer> codigoOpcoes = List.of(1,2,3,4);
    List<Integer> codigoOpcoes = new ArrayList<>();

    codigoOpcoes.add(1);
    codigoOpcoes.add(2);
    codigoOpcoes.add(3);
    codigoOpcoes.add(4);

    System.out.println("*** Menu ***");
    System.out.println("1- Primeira Opção");
    System.out.println("2- Primeira Opção");
    System.out.println("3- Primeira Opção");
    System.out.println("4- Primeira Opção");

    System.out.println();
    System.out.println("Digite a opção desejada:");

    Scanner scanner = new Scanner(System.in);
    int opcao = scanner.nextInt();

    boolean contains = codigoOpcoes.contains(opcao);

    System.out.println("A opção é válida = "+ contains);


  }
}
