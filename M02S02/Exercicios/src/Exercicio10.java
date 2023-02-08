/*
Um palíndrome (ou palíndromo), segundo o dicionário Houaiss,
"diz-se de frase ou palavra que se pode ler, indiferentemente, da esquerda para direita ou vice-versa", 
como por exemplo: osso, ana, radar.
Ou seja, é uma palavra que quando lida de trás pra frente tem o mesmo significado.

Implemente um código com o que aprendemos até agora que retorne se determinada palavra é um palíndromo.
 */
public class Exercicio10 {
    public static void main(String[] args) {
        String palavra = "ana";
        String inverso = "";

        inverso = new StringBuilder(palavra).reverse().toString().toUpperCase();

        if(palavra.toUpperCase().equals(inverso)){
            System.out.println("Palíndromo");
        }

    }
}
