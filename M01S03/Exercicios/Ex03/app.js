/*

Para treinar os conceitos de Spread.

Crie dois arquivos:
- index.html
- app.js

Em app.js desenvolva uma função que receba dois arrays e realize a concatenação entre eles utilizando o operador Spread.
Apresente o resultado no console.log(novoArray).

*/

const arr1 = [1, 2, 3];
const arr2 = [4, 5, 6];

//Arrow Function 
const Concatena = (array1, array2) => {

        return [...array1,...array2]

};

console.log(Concatena(arr1,arr2));