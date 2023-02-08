/*
Implemente uma função 'calcular' que receba como parâmetro um array (numérico) e identifique o maior e menor valor do mesmo.
Imprima no console estes valores ou "Não é possível calcular" qdo não for possível.

Teste a função com as seguintes entradas:

{56, 65, 64, -3, 23, 42, -15, 65, 14, 32, 78, 70, 47}
{1}
{1, -1}
null
{-2,-2,-2,-2}
{20,10, 30}
 */
public class Exercicio05 {
  public static void main(String[] args) {

  int[] numero = {56, 65, 64, -3, 23, 42, -15, 65, 14, 32, 78, 70, 47};

  calcular(numero);

  }
  private static void calcular(int[] numerico){
  int menor = Integer.MIN_VALUE;
  int maior = Integer.MAX_VALUE;

    if(numerico==null || numerico.length == 1 ){
      System.out.println("Não é possivel Comparar");
      return;
    }

    for (int i =0; i<numerico.length; i++){

      if(menor < numerico[i]){
        menor = numerico[i];
      }

      if(maior>numerico[i]){
        maior = numerico[i];
      }
    }
    System.out.println(menor);
    System.out.println(maior);
  }
}
