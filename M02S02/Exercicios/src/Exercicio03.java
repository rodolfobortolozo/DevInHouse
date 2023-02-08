/*
Percorra array com estrutura de repetição e faça operações com condicionais:

O array abaixo representa lançamentos na conta bancária do Luke.
Os valores negativos são débitos e os valores positivos são créditos.

Implemente um código copiando o array abaixo, e depois imprima no console o que se pede:

int[] extrato = { 100, -35, -15, -5, 55, -20 };

a) Percorra o array (operador 'for') e imprima cada elemento do array na ordem;
b) Percorra o array (operador 'for') e imprima os elementos de trás pra frente (do último para o primeiro);
c) Percorra o array (operador 'for') e calcule o saldo final da conta (valor inicial era zero),
imprima o resultado no console. (Dica: crie uma variável saldo inicializada com zero e vá atualizando seu valor);
d) Imprima no console a mensagem 'saldo positivo' ou 'saldo negativo', dependendo do resultado do saldo final calculado.
 */
public class Exercicio03 {
  public static void main(String[] args) {
    int[] extrato = { 100, -35, -15, -5, 55, -20 };
    int tamanhoArr = extrato.length;

    //a) Percorra o array (operador 'for') e imprima cada elemento do array na ordem;
    for(int i=0; i<tamanhoArr;i++){
      System.out.print(extrato[i]+", ");
    }
    System.out.println();

    //b) Percorra o array (operador 'for') e imprima os elementos de trás pra frente (do último para o primeiro);
    for(int x = tamanhoArr - 1; x >= 0 ; x--){
      System.out.print(extrato[x]+", ");
    }
    System.out.println();

    //c) Percorra o array (operador 'for') e calcule o saldo final da conta (valor inicial era zero)
    int saldo = 0;
    for(int i=0; i<tamanhoArr;i++){
      saldo += extrato[i];
    }
    //d) Imprima no console a mensagem 'saldo positivo' ou 'saldo negativo', dependendo do resultado do saldo final calculado.
    if(saldo>=0){
      System.out.println("Saldo Positivo");
    }else{
      System.out.println("Saldo Negativo");
    }

  }
}
