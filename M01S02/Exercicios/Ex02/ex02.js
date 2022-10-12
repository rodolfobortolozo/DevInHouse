var idade = parseInt(prompt("Informe a idade"));
var classificacao;

if (idade <= 15) 
    classificacao ='Jovens';
else if (idade <= 64) 
    classificacao ='Adultos';
else 
    classificacao ='Idosos';

var paragrafo = document.getElementById('paragrafo')
paragrafo.innerText=classificacao;