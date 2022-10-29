// const titulo = document.getElementById('titulo');
// console.log(titulo);
// const tag = document.getElementsByTagName('h1');
// console.log(tag);
// const nome = document.getElementsByName('titulo');
// console.log(nome);
// const classe = document.getElementsByClassName('titulo');
// console.log(classe);
// const querySelector = document.querySelector('h1#titulo2');
// console.log(querySelector);
// const querySelectorAll = document.querySelectorAll('h1.titulo');
// console.log(querySelectorAll);

// const button = document.createElement('button');
// button.innerText = 'Enviar';
// button.classList.add('button');
// button.onclick = function () {
//   console.log('aaa');
// };
// button.onclick = () => console.log('aaa');

// const main = document.getElementById('main');

// document.body.appendChild(button);
// main.appendChild(button);

// document.body.insertBefore(button, main);
// main.insertBefore(button, document.getElementById('paragrafo'));

// const paragrafo = document.getElementById('paragrafo');
// paragrafo.parentNode.removeChild(paragrafo);

// const testeFn = () => {
//   alert('teste');
// };

// const button = document.getElementById('button');
// button.onclick = testeFn;

// const input = document.getElementById('input');

// input.onblur = (event) => console.log(event.target.value);

// input.onkeyup = function (params) {
//   console.log(params);
// };

function submit(event) {
  event.preventDefault();

  console.log(event.target);
}

const form = document.getElementById('form');
// form.onsubmit = submit;

form.addEventListener('submit', submit);
form.removeEventListener('submit', submit);

let contas = [{ id: 1 }];

localStorage.setItem('chave', JSON.stringify(contas));
console.log(JSON.parse(localStorage.getItem('chave')));
