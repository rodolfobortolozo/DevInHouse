const teste = {
  nome: 'Thais',
  idade: 20,
  ativo: true,
  endereco: {
    rua: 'teste',
    numero: 123,
  },
  telefone: [
    {
      tipo: 'Celular',
      numero: 12121212,
    },
    {
      tipo: 'residencial',
      numero: 133121212,
    },
  ],
};

// const testString = JSON.stringify(teste);

// console.log(testString);

// const testParse = JSON.parse(testString);

// console.log(testParse);

// localStorage.clear();
// localStorage.setItem('teste', 'teste');
// localStorage.setItem('objeto', JSON.stringify(teste));
// localStorage.setItem('numero', 123);
// localStorage.setItem('arrayString', ['123', '122']);
// localStorage.setItem('array', JSON.stringify(['123', '122']));
// localStorage.setItem('boolean', false);

// const stringTeste = localStorage.getItem('teste');
// const objeto = localStorage.getItem('objeto');
// const numero = localStorage.getItem('numero');
// const arrayString = localStorage.getItem('arrayString');
// const array = localStorage.getItem('array');
// const boolean = localStorage.getItem('boolean');
// console.log(stringTeste, typeof stringTeste);
// console.log(objeto, typeof objeto, JSON.parse(objeto));
// console.log(numero, typeof numero, parseInt(numero));
// console.log(arrayString, typeof arrayString);
// console.log(array, typeof array, JSON.parse(array));
// console.log(boolean, typeof boolean, boolean === 'true');

// localStorage.removeItem('arrayString', );

function buscarDadosPromise() {
  fetch('http://swapi.dev/api/people/1')
    .then(function (response) {
      return response.json();
    })
    .then((data) => console.log(data))
    .catch((error) => console.error('Erro:', error));
}

async function buscarDadosAsync() {
  try {
    const response = await fetch('http://swapi.dev/api/people/1', {
      method: 'GET',
    });
    console.log(response);

    const data = await response.json();
    console.log(data);
  } catch (error) {
    console.error('Erro:', error);
  }
}

// buscarDadosPromise();
// buscarDadosAsync();

async function cadastrarPost() {
  try {
    const resultado = await fetch('https://jsonplaceholder.typicode.com/posts', {
      method: 'POST',
      body: JSON.stringify({ title: 'teste', body: 'bar', userId: 1 }),
      headers: { 'Content-type': 'application/json; charset=UTF-8' },
    });

    const data = await resultado.json();
    console.log(data);
  } catch (error) {
    console.error(error);
  }
}

async function atualizarPost() {
  try {
    const resultado = await fetch('https://jsonplaceholder.typicode.com/posts/1', {
      method: 'PUT',
      body: JSON.stringify({ title: 'teste', body: 'bar', userId: 1 }),
      headers: { 'Content-type': 'application/json; charset=UTF-8' },
    });

    const data = await resultado.json();
    console.log(data);
  } catch (error) {
    console.error(error);
  }
}

async function deletarPost() {
  try {
    const resultado = await fetch('https://jsonplaceholder.typicode.com/posts/1', {
      method: 'DELETE',
      headers: { 'Content-type': 'application/json; charset=UTF-8' },
    });

    const data = await resultado.json();
    console.log(data);
  } catch (error) {
    console.error(error);
  }
}

async function obterPost() {
  try {
    const resultado = await fetch('https://jsonplaceholder.typicode.com/posts');

    const data = await resultado.json();
    console.log(data);

    const ul = document.createElement('ul');
    data.forEach((element) => {
      const li = document.createElement('li');
      li.innerText = element.title;
      ul.appendChild(li);
    });
    document.body.appendChild(ul);
  } catch (error) {
    console.error(error);
  }
}

// cadastrarPost();

// atualizarPost();

// deletarPost();

// obterPost();

async function obterJsonLocal() {
  try {
    const resultado = await fetch('./index.json');

    const data = await resultado.json();
    console.log(data);
  } catch (error) {
    console.error(error);
  }
}

obterJsonLocal();
