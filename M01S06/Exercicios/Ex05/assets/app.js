function obterClienteNoBancoDeDados(idCliente) {
  return new Promise((resolve) => {
    const cliente = { nome: 'bruce wayne', id: idCliente };

    setTimeout(() => resolve(cliente), 1000);
  });
}

async function processar() {
  const cliente = await obterClienteNoBancoDeDados(7);
  console.log(cliente);
}
processar();