/*
[M1S02] Ex 8 - Número primo
Percorra os números de o a 1000 e exiba no console os números primos e ao final a quantidade de números primos que existem nesse intervalo.

*/

//var paragrafo = document.getElementById('paragrafo')

const qtdPercorrer = 1000;
var ePrimo = 0;
var nPrimo = 0;

function NumeroPrimo(num) {
  for (var x = 2; x < num; x++)
    if (num % x == 0){
        return false;
    }
  return true;
}

for (var i = 2; i < qtdPercorrer; i++) {
    
    if (NumeroPrimo(i)){
        ePrimo++;
    } 
    nPrimo++;
}

alert(`Quantidade de números Primos ${ePrimo}, e não Primos ${nPrimo}`);