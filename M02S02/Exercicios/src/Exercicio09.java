/*
Antigamente tinha um programa de televisão onde o apresentador chamava alguém da platéia e fazia o 
seguinte desafio valendo um prêmio: a pessoa tinha que contar até determinado número, 
por exemplo de 0 a 30, e a cada múltiplo de um número (por exemplo 3) deveria substituir pela palavra "PIN".
Apesar de parecer fácil, muita gente se enrolava e nao conseguia chegar no final do jogo.

Lembrando que para saber se é múltiplo de um número basta dividi-lo por este número e certificar que 
o resto da divisão é zero.
Exemplo: 16 é múltiplo de 4 porque 16 % 4 == 0;

Então, dada o array com a sequência abaixo (de 0 a 30), use a função 'for' para iterar 
sobre seus elementos e a cada múltiplo de 3 imprimir a palavra 'PIN', ou o próprio número caso contrário.

int[] sequencia = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,
21,22,23,24,25,26,27,28,29,30};
 */
public class Exercicio09 {
    public static void main(String[] args) {
        int[] sequencia = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};

        for (int i=0; i<sequencia.length; i++){

            if(sequencia[i] % 3 == 0){
                System.out.println("PIN");
            }else{
                System.out.println(sequencia[i]);
            }
        }
    }
}
