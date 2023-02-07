import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Listas {

  public static void main(String[] args) {

    List<String> nomes = new ArrayList<>();
    nomes.add("Alessandra");
    nomes.add("Rodolfo");
    nomes.set(1,"Amorinha"); //Altera o Elemento
    System.out.println(nomes);
    //Java 8
    List<String> nomes2 = Arrays.asList("Alessandra","Rodolfo");
    //Java 11
    List<String> nomes3 = List.of("Alessandra", "Rodolfo");

    String nomeEscolhido = nomes2.get(1);
    System.out.println(nomeEscolhido);
  }
}
