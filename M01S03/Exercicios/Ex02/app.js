/*

Em um arquivo app.js (incluído em index.html) faça o seguinte:

No documento js faça uma arrow function para retornar uma mensagem (string) de "Olá, Mundo!".

Armazene esta arrow function em uma constante (const) de nome mensagemOla.

Chame a função mensagemOla e exiba o retorno desta função no console.

Ajuste a função mensagemOla para que receba um parâmetro nome e retorne a mensagem "Olá, [nome]!".

Extra: Caso queira, podes experimentar criar um campo de texto, um botão e um parágrafo em index.html e 
fazer com que a função de nome seja executada ao pressionarmos o botão, que o nome pode seja lido do campo de texto e a mensagem seja exibida no parágrafo.

*/
const botao = document.getElementById("botao");
const paragrafo = document.getElementById("paragrafo");

const  mensagemOla = (nome) => `Olá, ${nome}`;


botao.addEventListener("click",() =>{

        let nome = document.getElementById("nome").value;
        let retorno = mensagemOla(nome)

        return paragrafo.innerHTML = `<Strong>${retorno}</strong>`;

        }
    );





//console.log(mensagemOla('Rodolfo'));
