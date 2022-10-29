// Início variáveis "globais"
const STORAGE_KEY = 'DEVINDICAS';
let dicas = [];
const categorias = [
  {
    id: 1,
    nome: 'SoftSkills',
  },
  {
    id: 2,
    nome: 'FrontEnd',
  },
  {
    id: 3,
    nome: 'BackEnd',
  },
  {
    id: 4,
    nome: 'FullStack',
  },
];
// Fim variáveis "globais"

// Início funções de renderização dos elementos
function renderizaCategorias() {
  const select = document.getElementById('category');

  categorias.forEach(function (categoria) {
    const opcao = document.createElement('option');
    opcao.innerText = categoria.nome;
    opcao.value = categoria.id;
    select.appendChild(opcao);
  });
}

function renderizaDicas(arrayDicas = dicas) {
  const lista = document.getElementById('list');
  lista.innerHTML = '';

  arrayDicas.forEach((dica) => {
    // Cria LI
    const li = document.createElement('li');
    // Adiciona classe
    li.classList.add('list-item', 'list-item-tips');

    // Cria elemento para o título da dica
    const titulo = document.createElement('h2');
    // Adiciona o texto com o nome da dica
    titulo.innerText = dica.nome;
    // Adiciona as classes css com os estilos
    titulo.classList.add('subtitle', 'text-center');
    // Adiciona o titulo criado como filho da li
    li.appendChild(titulo);

    // Cria elemento para a categoria da dica
    const subtitulo = document.createElement('p');
    // Adiciona o texto com o nome da categoria da dica
    subtitulo.innerText = obterNomeCategoria(dica.categoria);
    // Adiciona as classes css com os estilos
    subtitulo.classList.add('text-center', 'tip-category');
    // Adiciona a categoria criada como filho da li
    li.appendChild(subtitulo);

    // Cria elemento para a descrição da dica
    const descricao = document.createElement('p');
    // Adiciona o texto com a descrição da categoria da dica
    descricao.innerText = dica.descricao;
    // Adiciona as classes css com os estilos
    descricao.classList.add('tip-description');
    // Adiciona a descrição criada como filho da li
    li.appendChild(descricao);

    // Cria elemento para a imagem do ícone
    const image = document.createElement('img');
    // Adiciona id na imagem
    image.id = `img-${dica.id}`;
    // Adiciona os atributos src e alt da imagem de acordo com o status curtido da dica
    image.src = obterImagemCurtido(dica.curtido);
    image.alt = `Botão para ${dica.curtido ? 'deixar de curtir' : 'curtir'} a dica`;
    // Cria o elemento botão para ser possível clicar no ícone(imagem)
    const botaoIcone = document.createElement('button');
    // Adiciona as classes css com os estilos
    botaoIcone.classList.add('icon-button');
    // Adiciona evento de clique ao botão
    botaoIcone.addEventListener('click', () => curtirDica(dica.id));
    // Adiciona a imagem como filha do botão
    botaoIcone.appendChild(image);
    // Cria uma div para poder alinhar o botão à direita
    const divIcone = document.createElement('div');
    // Adiciona as classes css com os estilos
    divIcone.classList.add('tip-like');
    // Adiciona o botão criado como filho da div
    divIcone.appendChild(botaoIcone);
    // Adiciona a div criada como filho do li
    li.appendChild(divIcone);

    // Adiciona o li criado como filho do ul
    lista.appendChild(li);
  });
}

function renderizaTotais() {
  const lista = document.getElementById('total');
  lista.innerHTML = '';

  categorias.forEach((categoria) => {
    const totalCategoria = obterTotal(categoria.id);
    const li = document.createElement('li');
    li.classList.add('list-item', 'list-item-total');

    li.addEventListener('click', () => renderizaDicasFiltradasPorCategoria(categoria.id));

    const titulo = document.createElement('h2');
    titulo.innerText = categoria.nome;
    titulo.classList.add('total-title');
    li.appendChild(titulo);

    const total = document.createElement('p');
    total.innerText = totalCategoria;
    total.classList.add('subtitle');
    li.appendChild(total);

    lista.appendChild(li);
  });
}
// Fim funções de renderização dos elementos

// Início funções vinculadas à eventos
function carregarDadosIniciais() {
  dicas = obterDicasLocalStorage();
  renderizaCategorias();
  renderizaTotais();
  renderizaDicas();
}

function addDica(evento) {
  evento.preventDefault();

  const dica = {
    id: new Date().getTime(),
    nome: evento.target.name.value,
    categoria: parseInt(evento.target.category.value),
    descricao: evento.target.description.value,
    curtido: false,
  };

  dicas.push(dica);
  salvarDicasLocalStorage(dicas);
  renderizaDicas();
  renderizaTotais();

  evento.target.reset();
}

function filtrarPorCategoria(id) {
  const listaFiltrada = filtrarDicas(id);
  renderizaDicas(listaFiltrada);
}

function curtirDica(id) {
  // Cria variavel para armazenar se a dica é curtida ou não
  let curtido;

  // Percorre todas as dicas
  const dicasAtualizadas = dicas.map((dica) => {
    // Verifica se a dica da iteracão atual é igual a dica recebida por parametro
    if (dica.id === id) {
      // Seta o valor da variável curtodo para o status contrário ao anterior
      curtido = !dica.curtido;
      // Modifica o objeto alterando apenas a propriedade curtida para o novo e retorna o novo objeto
      return { ...dica, curtido };
    }
    // Caso a dica da iteracão atual for diferente da dica recebida por parametro apenas retorna o objeto sem modificar
    return dica;
  });

  // Atualiza a variável de controle global das dicas já com o item atualizado
  dicas = dicasAtualizadas;
  // Salva as dias atualizadas no local storage para quando atualizar a página os valores estarem corretos
  salvarDicasLocalStorage(dicasAtualizadas);

  // Obtem a imagem e troca o src de acordo com o status
  // Uma opção para não fazer esse passo seria renderizar novamente todas as dicas renderizaDicas()
  const imagem = document.getElementById(`img-${id}`);
  imagem.src = obterImagemCurtido(curtido);
}

const filtrarDicasPorNome = () => {
  // Obtem o texto digitado no input
  const nomeBusca = document.getElementById('input-search').value;

  // Filtra as dicas pelo nome, convertendo o texto para minúsculo
  const dicasFiltradas = dicas.filter((dica) =>
    dica.nome.toLowerCase().includes(nomeBusca.toLowerCase())
  );

  // Chama a função para renderizar as dicas filtradas
  renderizaDicas(dicasFiltradas);
};
// Fim funções vinculadas à eventos

// Início funções de apoio
function obterNomeCategoria(id) {
  const categoria = categorias.find((categoria) => categoria.id === id);
  return categoria.nome;
}

const filtrarDicas = (id) => {
  const dicasFiltradas = dicas.filter((dica) => dica.categoria === id);
  return dicasFiltradas;
};

function obterTotal(id) {
  const dicasFiltradas = filtrarDicas(id);
  return dicasFiltradas.length;
}

function obterImagemCurtido(curtido) {
  return curtido ? './assets/liked.png' : './assets/like.png';
}
// Fim funções de apoio

// Início funções manipulação Local Storage
const salvarDicasLocalStorage = (arrayDicas) => {
  // Salva no local storage a lista de dicas
  // é necessário transformar o array em string pois local storage só trabalha com tipo string
  localStorage.setItem(STORAGE_KEY, JSON.stringify(arrayDicas));
};

const obterDicasLocalStorage = () => {
  // Recupera a lista de dicas do local storage
  const dicasLS = localStorage.getItem(STORAGE_KEY);

  // Valida se tem algo no local storage
  // Se tiver realiza o parse, ou seja, converte novamente para um array
  // Se não tiver retorna um array vazio
  return dicasLS ? JSON.parse(dicasLS) : [];
};
// Fim funções manipulação Local Storage

// Início adição de eventos aos elementos
// Carrega as opções do select, os totais e renderiza os elementos do local storage
window.addEventListener('load', carregarDadosIniciais);

// Adiciona o evento de submit do form para cadastrar dicas
const formulario = document.getElementById('form-cadastro');
formulario.addEventListener('submit', addDica);

// Adiciona o evento de click ao botão para pesquisar as dicas por nome
const buttonSearch = document.getElementById('button-search');
buttonSearch.addEventListener('click', filtrarDicasPorNome);
// Fim adição de eventos aos elementos
