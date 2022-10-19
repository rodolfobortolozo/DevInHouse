const valores = [1, 2, 3, 4];


function somaTudo(valores) {
  let soma = 0;

  valores.forEach(valor => soma += valor );

  return soma;
}


const resultado = somaTudo(valores);
console.log(resultado);
// resultado deve ser 10