/*

Para treinar os conceitos de Rest.

Crie dois arquivos:
- index.html
- app.js

No arquivo apps.js, utilizando o operador Rest, crie uma função que receba como parâmetro uma quantidade indefinida de variáveis inteiras (números inteiros).

A função deve retornar a soma de todos os parâmetros (...).
Após executada a função, o resultado deve ser exibido no console.

*/


function somaTudo(...valores) {
  let soma = 0;

  valores.forEach(valor => soma += valor );

  return soma;
}


const resultado = somaTudo(1,2,3,4,5,6,7,8,9);
console.log(resultado);
// resultado deve ser 10