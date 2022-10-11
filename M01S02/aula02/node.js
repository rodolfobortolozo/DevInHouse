var convidado = 'Rodolfo';//prompt('Informe o nome do convidado')
var noivo1 = 'João';
var noivo2 = 'Maria';
var data = '11/10/2022';
var hora = '22:00';

var texto = `Caro ${convidado}

Você está convidado para o casamento de ${noivo1} e ${noivo2} a ser realizado no dia ${data}, às ${hora} horas.

Contamos com a sua presença!

Atensiosamente
os noivo(a)s`;

var paragrafo = document.getElementById('paragrafo')
paragrafo.innerText=texto;