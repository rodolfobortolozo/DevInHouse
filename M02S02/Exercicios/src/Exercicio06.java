import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Dado a lista de números:
List<Integer> lista = Arrays.asList(1,2,3,4);
Percorra a lista e gere uma nova com o triplo do valor de cada elemento:
*/
public class Exercicio06 {

    public static void main(String[] args) {

        List<Integer> lista = Arrays.asList(1,2,3,4);
        List<Integer> novaLista = new ArrayList<>();
        List<Integer> novaLista2 = new ArrayList<>();

        //Opção 01
        lista.forEach(itens -> novaLista.add(itens*3));
        
        System.out.println("Opção 1");
        System.out.println(novaLista);

        //Opção 02
        for(int i=0; i<lista.size() ; i++){
            novaLista2.add(lista.get(i)*3);
        }
        System.out.println("Opção 2");
        System.out.println(novaLista2);
    }
    
}
