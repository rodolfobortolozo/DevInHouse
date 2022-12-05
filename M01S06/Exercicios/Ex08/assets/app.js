const criaElementoTexto = (tipo, texto) => {
    const elemento = document.createElement(tipo);
    elemento.innerText = texto;
    return elemento;
  };
  
  async function buscaUsuarios() {
    try {
      const resultado = await fetch(`https://randomuser.me/api/?results=10`);
      const { results } = await resultado.json();
  
      const lista = document.getElementById('lista');
      lista.innerHTML = '';
  
      results.forEach((user) => {
        const li = document.createElement('li');
        const container = document.createElement('div');
        const info = document.createElement('div');
  
        container.classList.add('container');
        info.classList.add('info');
  
        const nome = criaElementoTexto(
          'p',
          `${user.name.title} ${user.name.first} ${user.name.last}`
        );
  
        const email = criaElementoTexto('p', user.email);
  
        const endereco = criaElementoTexto(
          'p',
          `${user.location.street.name} - ${user.location.street.number} - ${user.location.city} - ${user.location.state} - ${user.location.country}`
        );
  
        const foto = document.createElement('img');
        foto.src = user.picture.large;
  
        container.appendChild(foto);
        info.appendChild(nome);
        info.appendChild(email);
        info.appendChild(endereco);
        container.appendChild(info);
        li.appendChild(container);
        lista.appendChild(li);
      });
    } catch (error) {
      console.error(error);
    }
  }
  buscaUsuarios();
