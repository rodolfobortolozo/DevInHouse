var valorInicial = 0;
var valorRaiz = 0;
var lista = [];

valorInicial = parseInt(prompt("Informe o valor Inicial"));
valorRaiz = parseInt(prompt("Informe o valor Inicial"));

var ProgAritmetica  = valorInicial;

for(var i=0;i<10;i++){

    console.log(ProgAritmetica);
    lista.push(ProgAritmetica);
    ProgAritmetica += valorRaiz

}

alert(`Os 10 primeiros elementos da PA são: ${lista}`); 