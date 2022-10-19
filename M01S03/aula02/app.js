const carros = ['Fusca', 'Uno', 'Escort']
const motos = ['Cg', 'Twister', 'Biz']


function percorreVetor(vetor = []){
  for(let i=0; i <vetor.length; i++){
    console.log(vetor[i])
  }
}

percorreVetor(carros)

percorreVetor()


const numeros = [3, 6, 8]

function calcula(vetor, multiplicador){

  if(!Array.isArray(vetor)){
    console.log('Nenhum Vetor Informado!')
    //Return interrompe a continuação da execução função
    return
  }
  
  const novoVetor = []
  
  for(let i=0; i <vetor.length; i++){
    novoVetor.push(vetor[i]*multiplicador);
  }

  return novoVetor

}

const retorno = calcula(numeros,3);

console.log(calcula(numeros,2));

console.log(retorno);

//Função Nomeada

const funcaoNomeada = function(){
  return "Rodolfo"
}

console.log(funcaoNomeada());


//Function Normal
function dobraComun(numero){
  return numero ** 2;
}


//Function Arrow
const dobraArrow1 = (numero) => {
  return numero ** 2
}

//Function Arrow, quando tem um parmetro e uma unica função
// Posso ocultar os Parenteses e colchetes
const dobraArrow2 = numero => numero ** 2

console.log(dobraComun(3))
console.log(dobraArrow1(7))
console.log(dobraArrow2(5))


//for each com uma arrow function
// primeiro item do array, indice do array e array completo
// Cochetes no console log transforma em um objeto o retorno

carros.forEach( (item, indice, referencia) => {
  console.log({ item,indice, referencia })
})

