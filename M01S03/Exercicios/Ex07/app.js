/*Em um arquivo app.js incluído em index.html, crie um objeto com a seguinte estrutura:

const pessoa = {
  nome: 'Ada',
  idade: 36
  profissao: 'matemática'
};
Faça uma função que receba este objeto por parâmetro, desestruture-o no começo da função (utilizando destruct) criando três variáveis (nome, idade, profissao).

Faça ainda com que a função retorne uma string com a seguinte mensagem:

"Esta é Ada, tem 36 anos e é matemática."
Concatene as variáveis criadas com destruct para formar a mensagem.

Chame a função passando o objeto por parâmetro e exiba o retorno no console.

Extra: Faça o destruct acontecer diretamente na linha de declaração dos parâmetros da função. Por fim faça com uma arrow function.

*/

const pessoa = {
  nome: 'Ana',
  idade: 36,
  profissao: 'matemática'
};

const Frase = ({nome,idade, profissao}) => `"Esta é ${nome}, tem ${idade} anos e é ${profissao}."`;


console.log(Frase(pessoa))