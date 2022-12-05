// let teste = 'teste';

// console.log('1', teste);

// function alteraTeste() {
//   teste = 'Teste alterado';
//   console.log('4', teste);
// }

// console.log('2', teste);

// setTimeout(() => alteraTeste(), 3000);

// console.log('3', teste);

// setTimeout(() => alteraTeste(), 100);

function digaOlaPara(nome, sobrenome) {
  console.log(`Olá ${nome}${sobrenome ? ` ${sobrenome}` : ''}!`);
}

// digaOlaPara('Maria');
// const timeout = setTimeout(digaOlaPara, 1000, 'Ana', 'Santos');

// setTimeout(() => {
//   console.log('Limpou');
//   clearTimeout(timeout);
// }, 200);

// const interval = setInterval(digaOlaPara, 1000, 'Thais');

// setTimeout(() => clearInterval(interval), 10000);

// function funcao1() {
//   //   console.log('Função 1');
//   return setTimeout(funcao2, 300, 'Função 1');
// }

// function funcao2(param) {
//   //   console.log(param + ' - Função 2');
//   return setTimeout(funcao3, 200, param + ' - Função 2');
// }

// function funcao3(param) {
//   //   console.log(param + ' - Função 3');
//   return setTimeout(console.log, 100, param + ' - Função 3');
// }

// funcao1();

// const minhaPromise = new Promise((resolver, rejeitar) => {
//   setTimeout(() => rejeitar('Ok!'), 200);
// })
//   .then((resultado) => {
//     console.log(resultado);
//     return 'resultado';
//   })
//   .then((resultado) => {
//     console.log(resultado);
//   })
//   .catch((erro) => console.log(erro));

// const endereco = fetch('https://viacep.com.br/ws/01001000/json/')
//   .then((resultado) => {
//     console.log('1-', resultado);
//     return resultado.json();
//   })
//   .then((resultado) => console.log('2-', resultado))
//   .catch((erro) => console.log(erro));

const minhaFuncao = (erro) => {
  const minhaVariavelPromise = new Promise((resolve, reject) => {
    console.log('1');
    if (erro) {
      reject('Promise com erro (rejeitada)!');
    }
    resolve('Promise com sucesso (resolvida)!');
  });

  minhaVariavelPromise
    .then((resultado) => {
      console.log('2');
      console.log('Ok', resultado);
    })
    .catch((erro) => {
      console.log('3');
      console.log('Erro', erro);
    })
    .finally(() => {
      console.log('4');
      console.log('Final');
    });
};

// minhaFuncao(false);
// minhaFuncao(true);

const teste = () => {
  minhaFuncao(false);
};
const button = document.getElementById('button');
button.addEventListener('click', function () {
  minhaFuncao(false);
});
