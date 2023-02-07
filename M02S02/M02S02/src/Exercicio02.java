import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercicio02 {
  public static void main(String[] args) {
    int[] numeros = new int[5];
    numeros[0]=1;
    numeros[1]=2;
    numeros[2]=3;
    numeros[3]=4;
    numeros[4]=5;


    System.out.println(Arrays.toString(numeros));


    List<Integer> numeros2 = new ArrayList<>();

    numeros2.add(5);
    numeros2.add(6);
    numeros2.add(7);
    numeros2.add(8);
    numeros2.add(9);
    numeros2.add(10);

    System.out.println(numeros2);

  }
}
