console.log('Olá! m1-s03-a1')

// nome comum de variável
var nomeComumDeVariavel = 'yey'

// nome de entidade classe/componente
var EntidadeEmVariavel = {}

// nome de dado constante predefinido
var TAMANHO_DO_ARRAY = 3

// console.log(typeof 'romeu') // string
// console.log(typeof 334.4) // number
// console.log(typeof true) // boolean
// console.log(typeof undefined) // undefined
// console.log(typeof null) // object
// console.log(typeof []) // object
// console.log(typeof {}) // object
// console.log(typeof NaN) // number
// console.log(typeof function () {}) // function

// valores equivalentes a falso
// console.log(!!false)
// console.log(!!0)
// console.log(!!'')
// console.log(!!null)
// console.log(!!undefined)
// console.log(!!NaN)

// valores equivalentes a true
// console.log(!!true)
// console.log(!!3232)
// console.log(!!'asdfasd')
// console.log(!![])
// console.log(!!{})
// console.log(!!function () {})

// inicializa array
var vetor = ['3', 'str', '#', 'true']

// console.log(vetor)
// console.log(vetor[1])
// // atributo importante length
// console.log(vetor.length)

// vetor.push(999)
// vetor.push(111)
vetor.push(555, 444, 333)

// como testar se é um array
// if (Array.isArray(vetor)) {
//   for (var i = 0; i < vetor.length; i++) {
//     console.log(vetor[i])
//   }
// } else {
//   console.log(vetor)
// }

//console.log(vetor.join(' '))

const pessoas = [
  {
    nome: {
      primeiro: 'romeu',
      ultimo: 'casarotto',
    },
    idade: 30,
    ocupacoes: ['programador'],
  },
  {
    nome: 'isaac',
    idade: 30,
    ocupacoes: ['professor'],
  },
]

console.log(pessoas[0].nome.primeiro)

function multiplica(x, y) {
  let acumulador = 0
  for (let i = 0; i < y; i++) {
    acumulador += x
  }
  return acumulador
}

console.log(multiplica(3, 8))