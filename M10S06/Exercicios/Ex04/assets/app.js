const retornoEmpresa1 = new Promise((resolve) => setTimeout(resolve, 5000, 'Empresa 1')); // 5 segundos
const retornoEmpresa2 = new Promise((resolve) => setTimeout(resolve, 3000, 'Empresa 2')); // 3 segundos

Promise.race([retornoEmpresa1, retornoEmpresa2]).then(function (resultado) {
  console.log(resultado);
});