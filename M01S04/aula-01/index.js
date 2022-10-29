// const a = [10, 20, 30, 40];
// let b = [...a];

// const [p1, p2, ...rest] = a;
// console.log(p1, p2, rest);

// const pessoa = { nome: 'teste', idade: 20, sexo: 'F', peso: 20 };
// const { nome, sexo, ...params } = pessoa;

// console.log(nome, sexo, params);

// const alunos = ['aluno 1', 'aluno 2', 'aluno 3'];
// console.log(alunos[0]);
// console.log(alunos[1]);
// console.log(alunos[2]);

// console.log(alunos.length);

// for (let index = 0; index < alunos.length; index++) {
//   const element = alunos[index];
//   console.log(element);
// }

// const result = alunos.push('aluno 3');
// console.log(result, alunos);

// const pop = alunos.pop();
// console.log(pop, alunos);

// const shift = alunos.shift();
// console.log(shift, alunos);

// const unshift = alunos.unshift('aluno 0');
// console.log(unshift, alunos);

// const alunosSlice = alunos.slice(0, 1);
// alunosSlice.push('aluno 4');

// alunos.push('aluno 5');
// console.log(alunosSlice);
// console.log(alunos);

// const alunos = ['aluno 1', 'aluno 2', 'aluno 3'];
// const alunosSplice = alunos.splice(0, 1);
// alunos.splice(1, 0, 'aluno novo');
// console.log(alunos);
// console.log(alunosSplice);

// const alunos = ['aluno 1', 'aluno 2', 'aluno 3'];
// const join = alunos.join(' , ');
// console.log(join);
// const split = join.split(' , ');
// console.log(split);

// const alunos = [
//   { nome: 'aluno 1', nota: 10 },
//   { nome: 'aluno 2', nota: 7 },
//   { nome: 'aluno 3', nota: 5 },
// ];

// let soma = 0;
// alunos.forEach((aluno) => {
//   soma += aluno.nota;
// });
// console.log(soma / alunos.length);

// const numeros = [1, 2, 3];

// const dobro = numeros.map((numero) => numero * 2);
// const triplo = numeros.map(function (numero) {
//   return numero * 3;
// });
// console.log(numeros);
// console.log(dobro);
// console.log(triplo);
const search = 'João';
let pessoas = [{ nome: 'Maria' }, { nome: 'João da silva' }, { nome: 'joão antunes' }];
// const find = pessoas.find((pessoa) => pessoa.nome.toLowerCase().includes(search.toLowerCase()));
// console.log(find);

// const filter = pessoas.filter((pessoa) => pessoa.nome.toLowerCase().includes(search.toLowerCase()));
// console.log(filter);

// const some = pessoas.some((pessoa) => pessoa.nome.toLowerCase().includes(search.toLowerCase()));
// console.log(some);

// const every = pessoas.every((pessoa) => pessoa.nome.toLowerCase().includes(search.toLowerCase()));
// console.log(every);

// const findIndex = pessoas.findIndex((pessoa) =>
//   pessoa.nome.toLowerCase().includes(search.toLowerCase())
// );
// console.log(findIndex);

const notas = [
  { nome: 'ALuno 1', nota: 10 },
  { nome: 'ALuno 2', nota: 8 },
  { nome: 'ALuno 2', nota: 2 },
];
const soma = notas.reduce((acc, aluno, index) => {
  console.log(acc, aluno, index);
  return (acc += aluno.nota);
}, 0);
console.log(soma);
