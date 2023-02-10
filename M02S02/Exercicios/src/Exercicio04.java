/*
Mike tem um nro da sorte: 25.
Ele conseguiu uma listagem do histórico dos resultados da loteria conforme arrays abaixo.
Escreva um código para percorrer os elementos de nros sorteados e contabilizar quantas vezes o nro da sorte dele foi sorteado.

Dica: Usar um for dentro do outro para percorrer os arrays internos.
int sorteados[][] = {
    { 1, 44,  6,  2, 45, 60},
    {10, 21, 55, 25, 34, 44},
    { 8, 18, 28, 29, 55, 59},
    {60, 25, 11, 34,  6,  9},
    {55, 43, 25, 12,  7, 11}
};
 */

public class Exercicio04 {
  public static void main(String[] args) {

    int sorteados[][] = {
            { 1, 44,  6,  2, 45, 60},
            {10, 21, 55, 25, 34, 44},
            { 8, 18, 28, 29, 55, 59},
            {60, 25, 11, 34,  6,  9},
            {55, 43, 25, 12,  7, 11}
    };

  int tamanho = sorteados.length;
  int qtdNumero = 0;

  for(int i =0 ; i<=tamanho-1 ; i++){
    int qtd = sorteados[i].length;

    for(int y=0; y<=qtd-1; y++){
      if (sorteados[i][y] == 25){
        qtdNumero ++;
      }
    }
  }

    System.out.println(qtdNumero);

  }
}
