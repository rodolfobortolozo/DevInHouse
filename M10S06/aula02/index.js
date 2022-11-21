const p1 = new Promise((resolve, reject) =>
  setTimeout(() => {
    resolve({ name: 'Promise 1' });
  }, 600)
);

const p2 = new Promise((resolve, reject) =>
  setTimeout(() => {
    resolve({ nome: 'Promise 2' });
  }, 200)
);

// const p3 = new Promise((resolve, reject) =>
//   setTimeout(() => {
//     reject('Promise 3');
//   }, 500)
// );

// function imprimeLog(msg) {
//   console.log(msg);
// }

// Promise.all([p1, p2, p3])
//   .then(imprimeLog)
//   .catch(function (err) {
//     imprimeLog(`Erro: ${err}`);
//   })
//   .finally(() => {
//     imprimeLog('Finally');
//   });

// Promise.race([p1, p2, p3])
//   .then(imprimeLog)
//   .catch(function (err) {
//     imprimeLog(`Erro: ${err}`);
//   })
//   .finally(() => {
//     imprimeLog('Finally');
//   });

// Promise.allSettled([p1, p2, p3])
//   .then(function (result) {
//     console.log(
//       result.map(function (f) {
//         return f.status;
//       })
//     );
//     imprimeLog(result);
//   })
//   .catch(function (err) {
//     imprimeLog(`Erro: ${err}`);
//   })
//   .finally(() => {
//     imprimeLog('Finally');
//   });

const duplicar = async (num) => {
  return num * 2;
};

const promiseRejeitada = async () => {
  return new Promise((res, rej) => res('falha'));
};

(async function somar() {
  try {
    const resultado = await p1;
    console.log(resultado);

    const resultado2 = await promiseRejeitada();
    console.log(resultado2);
  } catch (error) {
    console.log('Erro:', error);
  } finally {
    console.log('Finally');
  }

  //   let duplicado = await duplicar(2);
  //   console.log(duplicado);
  //   duplicado = await duplicar(duplicado);
  //   console.log(duplicado);
})();

// somar();

async function teste() {
  p1.then((resultado) => {
    console.log(resultado);
    return promiseRejeitada();
  })
    .then((res) => console.log(res))
    .catch((e) => console.log('err', e))
    .finally(() => console.log('Finally'));
}

teste();
