const lista = document.getElementById('lista');
const form = document.getElementById('form');
const BASE_URL = ' http://localhost:3000';

function popularPostHtml(post){
    const item = document.createElement('li');
    const span = document.createElement('span');
    const button = document.createElement('button');
    
    lista.appendChild(item);
    button.innerText ='Excluir';
    button.addEventListener('click',()=> excluirPost(post.id));

    
    item.innerHTML = `${post.titulo} - ${post.descricao}`;
    item.appendChild(span);
    item.appendChild(button);
}

async function excluirPost(id){
    await fetch(`${BASE_URL}/posts/${id}`,{
    method: 'DELETE'
});

    const item = document.getElementById(`$post-${post.id}`);
    item.remove();
}

function popularPosts(posts){
    lista.innerHTML = '';

    posts.forEach(post => {
        popularPostHtml(post);
    });
}

async function buscarPosts(){
    const resultado = await fetch(`${BASE_URL}/posts`);
    const posts = await resultado.json();
    console.log(posts);
    popularPosts(posts);
}

async function submitForm(event){
    event.preventDefault();

    const post ={
        titulo: event.target.titulo.value,
        descricao: event.target.descricao.value
    };
    const postcriado = await criarPost(post);

}

async function criarPost(post){
    const resultado = await fetch(`${BASE_URL}/posts`,{
        method: 'POST',
        headers: new Headers({
            'Content-Type': 'application/json',
        }),
        body: JSON.stringify(post),
    });

    const postCriado = await resultado.json();
    popularPostHtml(postCriado);
    console.log(postCriado);
}

window.addEventListener('load',buscarPosts);
form.addEventListener('submit', submitForm);