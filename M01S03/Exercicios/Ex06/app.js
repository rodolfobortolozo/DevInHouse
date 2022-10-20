const teste = "Ana";
const teste2 = "Julia";


const verificaPalindromo = (text) =>{

  let retorno="";

  for(let i= text.length - 1; i >= 0; i--){

    retorno += text[i];

  }

  if( retorno.toUpperCase() === retorno.toUpperCase() ){
  
    return true;
  
  }

  return false;

}

console.log(verificaPalindromo(teste));