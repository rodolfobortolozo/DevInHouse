console.log('m1-s03-a2')

// como pegar um elemento do DOM
// const h1 = document.getElementById('titulo')
// console.log(h1)

// indices       0        1      2
const carros = ['fusca', 'uno', 'escort']
// carros[4] = 'sandero'
// carros.push('corolla')
// console.log(carros)
// console.log(carros.pop())

// definindo funções
// function logaVetor(vetor = []) {
//   console.log(vetor)
//   for (let i = 0; i < vetor.length; i++) {
//     console.log(vetor[i])
//   }
//   return ['olhaaaaa']
// }
// console.log(logaVetor())
// console.log(logaVetor(carros))

const numeros = [3, 6, 8]

// função atribuída a uma variável
// const calcula = function (vetor, multiplicador = 1) {
//   if (!Array.isArray(vetor)) {
//     // return interromope a execução da função
//     return []
//   }
//   const novoVetor = []
//   for (let i = 0; i < vetor.length; i++) {
//     novoVetor.push(vetor[i] * multiplicador)
//   }
//   return novoVetor
// }

// const retorno = calcula(numeros, 2)
// console.log(retorno)
// console.log(calcula(numeros, 3))
// console.log(calcula(numeros, 4))

// exemplo de função alternada com variável
// function mudaCaixa(texto, alta) {
//   let funcaoTransformadora
//   if (alta) {
//     funcaoTransformadora = function () {
//       return texto.toUpperCase()
//     }
//   } else {
//     funcaoTransformadora = function () {
//       return texto.toLowerCase()
//     }
//   }
//   console.log(funcaoTransformadora())
// }
// mudaCaixa('BLAHblah', true)

// function dobraComum(numero) {
//   return numero ** 2
// }
// console.log(dobraComum(16))
// const dobraArrowA = (numero) => {
//   return numero ** 2
// }
// const dobraArrow = numero => numero ** 2
// console.log(dobraArrow(16))

//const soma = (a, b) => a + b
//console.log(soma(3, 4))

// console.log(carros.length)
// carros.forEach((item, index, array) => {
//   console.log({ item, index, array })
// })


var nome = 'romeu-no-window';

const objeto = {
  nome: 'romeu-no-objeto',
  metodoC: function () {
    console.log(this.nome)
  },
  metodoA: () => {
    console.log(this.nome)
  }
}

objeto.metodoC()
objeto.metodoA()

