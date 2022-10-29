const turma = {
  nome: 'DevInPhilips',
  dataInicio: new Date(),
};

const aluno = {
  turma,
  nome: 'Thais',
  notas: [
    {
      projeto: 1,
      nota: 8,
    },
    {
      projeto: 2,
      nota: 10,
    },
  ],
  retornaTurma: function () {
    return this.turma?.nome;
  },
  retornaParam: (param) => {
    return param;
  },
  calculaMedia: function () {
    return this.notas.reduce((acc, projeto) => (acc += projeto.nota), 0) / this.notas.length;
  },
};

// aluno.celular = '46 99999';
// console.log(aluno);
// delete aluno.celular;

// console.log(aluno);
// console.log(aluno['nome']);

// console.log(aluno.retornaParam('teste'));
// console.log(aluno.calculaMedia());
// console.log(aluno.retornaTurma());

// const chaves = Object.keys(turma);
// console.log('chaves', chaves);
// console.log(chaves[1]);
// chaves.forEach((chave) => console.log(`${chave}: ${turma[chave]}`));

const entries = Object.entries(turma);
console.log(entries);
