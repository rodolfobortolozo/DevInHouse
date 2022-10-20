// proíbe o uso de variáveis não declaradas
"use strict";
// módulos já vem com "use strict" por padrão
// <script src="app.js" type="module"></script>

console.log('m1-s03-a3');


// VAR pode estar disponível nos escopos
// > Global, Função

// var numero = 6;

// if (1) {
//   var numero = 8;
// }
// numero = 100;

// function fscope() {
//   if (1) {
//     var numero = 10;
//   }
//   console.log('funcao', numero);
// }
// fscope();

// console.log('global', numero);

// CONST e LET pode estar disponível nos escopos
// > Global, Função, Bloco

// let numero = 6;
// if (1) {
//   let numero = 11;
//   const blah = 'bleh';
//   let acumulador = 0;
//   acumulador++;
//   console.log(acumulador)
// }
// numero = 33;

// function fscope() {
//   if (1) {
//     let numero = 888;
//     console.log('funcao', numero);
//   }
// }
// fscope();

// console.log('global', numero);

// CONST não pode ser reatribuido
// const nome = 'romeu';
// //nome = 'isaac'; // não é permitido
// console.log(nome);
// const carros = [];
// carros.push('opala')
// carros[0] = ['fusca'];
// // carros = ['fusca']; // não permite
// console.log(carros);

// HOISTING "içamento" de vars e functions
// icado = 3;
// console.log(icado, hoisted())
// var icado;
// function hoisted() {
//   return 777;
// }

// Exemplo de recursção
// const carros = ['fusca', 'opala', 'uno'];
// function imprimeVetor(vetor, i) {
//   if (i >= 0) {
//     console.log(vetor[i], i);
//     imprimeVetor(vetor, --i)
//   }
// }
// imprimeVetor(carros, 2)

//


/*
ATIVIDADE: Crie uma função que receba
como parâmetro um objeto contendo 2 atributos,
texto e termo, como o exemplo e teste se
o conteúdo de texto contém o conteúdo do termo.
*/

// procuraTermo({
//   texto: "O rato roeu a roupa do rei de Roma.",
//   termo: "rato"
// }); // true

// procuraTermo({
//   texto: "O rato roeu a roupa do rei de Roma.",
//   termo: "batata"
// }); // false


const obj = {
  texto: "O rato roeu a roupa do rei de Roma.",
  termo: "rato"
};
// console.log(obj);
// console.log(JSON.stringify(obj));

function testeTernario(param) {
  return param.texto.includes(param.termo);
}

console.log(testeTernario(obj));
