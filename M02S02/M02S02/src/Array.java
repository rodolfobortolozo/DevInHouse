public class Array {
  public static void main(String[] args) {

    int[] notas = {10, 9, 8};

    String[] nomes = {"Rodolfo", "Alessandra"};

    System.out.println(nomes.length);

    String[][] turmas = {
            {"james", "scott", "spock"},
            {"luke", "", ""},
            {"Rodolfo", "Alessandra", "Lorena"}
    };

    System.out.println(turmas[2][1]);


  }
}