import java.util.Arrays;
import java.util.List;

/*
Localize na lista abaixo e imprima no console a primeira ocorrência de número maior que 50.

List<Integer> numeros = Arrays.asList(0,2,88,56,33,42,67,3,9,0,2);
 */

public class Exercicio08 {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(0,2,88,56,33,42,67,3,9,0,2);

        //numeros.forEach(numero -> { if(numero>50) System.out.println(numero);});

        for(int i=0; i<numeros.size();i++){
            if(numeros.get(i)>50){
                System.out.println(numeros.get(i));
                return;
            }
        }

    }
}
