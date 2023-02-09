import java.util.ArrayList;
import java.util.List;

public class Java03 {

  public static void main(String[] args) {

    String[] cores = {"Rodolfo", "Alessandra"};
    List<Integer> numeros3 = List.of(1,2,3,4,5);

    numeros3.forEach(elemento -> System.out.println(elemento));

    int[] numeros = {5,7,-7, -4,3,-9,0,12,-34,0,3,6,9};
    int positivo =0;
    int negativo =0;
    int zeros =0;

    for (int nro : numeros){
        if(nro>0){
          positivo++;
        }else if(nro<0){
          negativo++;
        }else{
          zeros ++;
        }
    }
    System.out.println("Positivos: "+ positivo);
    System.out.println("Negativos: "+ negativo);
    System.out.println("Zeros: "+ zeros);



    double valorInicial = 1200.0;
    double valorFinal = 0.0;
    int anos =0;

    while(valorInicial<5000){
      valorInicial *= 1.10;
      anos++;
    }

    System.out.println(anos);



    int[] numeros2 = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33};

    for(int num : numeros2){

      if(num%3 == 0 && num%5 == 0){
        System.out.println("FizzBuzz");
      }else if(num%3 == 0){
        System.out.println("Fizz");
      }else if(num%5 == 0){
        System.out.println("Buzz");
      }else{
        System.out.println(num);
      }
    }


    int[] arr = {3, 5, 1, 4, 7, 6, 5, 2, 3, 4, 2, 3, 1, 0, 6};
    List<Integer> numerosUnicos = new ArrayList<>();


    for(int i=0 ;i<arr.length ;i++){
      boolean repetido = false;
      int nro = arr[i];
      for(int j=0; j<arr.length ;j++){

        if(j==i){
          continue;
        }
        if(nro==arr[j]){
          repetido = true;
          break;
        }
      }

      if(!repetido){
        numerosUnicos.add(nro);
      }
    }

    System.out.println(numerosUnicos);
  }
}
