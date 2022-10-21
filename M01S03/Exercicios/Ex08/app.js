/*

Em um arquivo app.js incluído em index.html escreva uma função arrow e armazene-a em uma variável de nome uneDobraRetorna, 
que aceita um array de números e qualquer outra quantidade de números como parâmetro. 
A função deve retornar um novo vetor que começa com o vetor
 inicial concatenado com os outros parâmetros extra dobrados de valor.

*/

const uneDobraRetorna = (vector, ...rest) => {

  newRest = rest.map(x => x * 2);

  return [...vector, ...newRest];


}

console.log(uneDobraRetorna([1,2,3],4,4));