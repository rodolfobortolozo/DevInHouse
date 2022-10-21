/*

Um palindrome (palíndromo), segundo o dicionário Houaiss,
"diz-se de frase ou palavra que se pode ler, indiferentemente, da esquerda para direita ou vice-versa", como por exemplo: osso, Ana, radar.

Ou seja, é uma palavra que quando lida de trás pra frente tem o mesmo significado.

Implemente uma função em JavaScript que receba uma string como parâmetro e retorne se determinada palavra é um palindromo ou não.

*/


const teste = "Ana";
const teste2 = "Julia";


const verificaPalindromo = (...text) =>{

  let contrario="";

  contrario = text.reverse(); 

  if( contrario === text ){
  
    return true;
  
  }

  return false;

}

console.log(verificaPalindromo(teste));