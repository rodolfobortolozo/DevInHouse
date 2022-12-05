const lista = document.getElementById('lista');
const form = document.getElementById('form');
const BASE_URL = 'http://localhost:3000';

function popularPostHtml(post) {
  const item = document.createElement('li');
  const span = document.createElement('span');
  const button = document.createElement('button');
  const buttonEditar = document.createElement('button');

  item.id = `post-${post.id}`;

  span.innerText = `${post.titulo} - ${post.descricao}`;

  button.innerText = 'Excluir';
  button.addEventListener('click', () => excluirPost(post.id));

  buttonEditar.innerText = 'Editar';
  buttonEditar.addEventListener('click', () => editarPostHtml(post.id));

  item.appendChild(span);
  item.appendChild(buttonEditar);
  item.appendChild(button);

  lista.appendChild(item);
}

function popularPostsHtml(posts) {
  lista.innerHTML = '';

  posts.forEach((post) => {
    popularPostHtml(post);
  });
}

async function buscarPosts() {
  const resultado = await fetch(`${BASE_URL}/posts`);
  const posts = await resultado.json();
  popularPostsHtml(posts);
}

async function criarPost(post) {
  const resultado = await fetch(`${BASE_URL}/posts`, {
    method: 'POST',
    headers: new Headers({
      'Content-Type': 'application/json',
    }),
    body: JSON.stringify(post),
  });

  const postCriado = await resultado.json();
  return postCriado;
}

async function excluirPost(id) {
  await fetch(`${BASE_URL}/posts/${id}`, {
    method: 'DELETE',
  });

  const item = document.getElementById(`post-${id}`);
  item.remove();
}

async function buscarPost(id) {
  const resultado = await fetch(`${BASE_URL}/posts/${id}`);
  const post = await resultado.json();
  return post;
}

async function atualizarPost(post) {
  const resultado = await fetch(`${BASE_URL}/posts/${post.id}`, {
    method: 'PUT',
    headers: new Headers({
      'Content-Type': 'application/json',
    }),
    body: JSON.stringify(post),
  });

  const postCriado = await resultado.json();
  return postCriado;
}

async function submitForm(event) {
  event.preventDefault();

  const titulo = event.target.titulo;
  const descricao = event.target.descricao;
  const codigo = event.target.codigo;

  const post = {
    titulo: titulo.value,
    descricao: descricao.value,
  };

  if (codigo.value) {
    const postAtualizado = await atualizarPost({ ...post, id: codigo.value });
    const item = document.getElementById(`post-${postAtualizado.id}`);
    item.children[0].innerText = `${postAtualizado.titulo} - ${postAtualizado.descricao}`;
  } else {
    const postCriado = await criarPost(post);
    popularPostHtml(postCriado);
  }

  form.reset();
  //   codigo.value = '';
  //   titulo.value = '';
  //   descricao.value = '';
}

async function editarPostHtml(id) {
  const post = await buscarPost(id);

  const codigo = document.getElementById('codigo');
  codigo.value = post.id;

  const titulo = document.getElementById('titulo');
  titulo.value = post.titulo;

  const descricao = document.getElementById('descricao');
  descricao.value = post.descricao;
}

window.addEventListener('load', buscarPosts);
form.addEventListener('submit', submitForm);
