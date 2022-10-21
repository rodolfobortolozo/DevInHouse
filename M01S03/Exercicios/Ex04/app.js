/*

Para exercitarmos spread com objetos:
Em um arquivo app.js incluído em index.html escreva uma função de nome mesclaObjetos, 
que aceita dois objetos como parâmetro e retorna um novo objeto que contem todos os pares chave-valor do primeiro e do segundo objetos.

*/

const objUm = { a: 1, b: 2 };
const objDois = { c: 3, d: 4 };


//Spread
const mesclaObjetos = (array1, array2) =>  { 
        
    return  {...array1, ...array2};

};

const novoObjeto = mesclaObjetos(objUm, objDois);

console.log(novoObjeto);
