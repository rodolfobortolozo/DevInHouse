import java.util.Arrays;
import java.util.List;

/*
Dado a lista de nomes:

List<String> nomes = Arrays.asList("kirk", "spock", "scott", "mccoy", "sulu");

a) Percorra a lista usando o operador 'for' clássico, usando uma variável para iterar pelos índices, e imprima no console os valores de cada nome;
b) Percorra a lista usando o operador 'for-each' usando a forma simplificada, e imprima no console os valores de cada nome;
c) Percorra a lista usando o operador 'while', e imprima no console os valores de cada nome;
 */
public class Exercicio07 {
    public static void main(String[] args) {
        List<String> nomes = Arrays.asList("kirk", "spock", "scott", "mccoy", "sulu");
        int y = 0;
        
        //A
        for(int i=0; i<nomes.size(); i++){
            System.out.println(nomes.get(i));
        }
        
        //B
        nomes.forEach(nome -> System.out.println(nome));

        for (String nome : nomes){
            System.out.println(nome);
        }
        
        //C
        while(nomes.size()>y){
            System.out.println(nomes.get(y));
            y++;
        }
    }
}
