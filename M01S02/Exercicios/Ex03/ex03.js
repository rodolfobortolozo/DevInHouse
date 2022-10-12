var numero = parseInt(prompt("Informe o número para calcular a Taboada"));
var resultado;
var taboada;
var paragrafo = document.getElementById('paragrafo')

//Laço de REpetição para Calculo
for(var i=0; i<=10; i++){
    resultado = numero * i;
    //Insiro no HTML
    paragrafo.innerHTML += `<p>${numero} x ${i} = ${resultado}</p> `;
}


