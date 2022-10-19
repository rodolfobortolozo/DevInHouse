/*
[M1S02] Ex 7 - Verifique a estação do ano
Baseado na data atual, seu código deve verificar qual a estação atual do ano no hemisfério sul, exibindo através de um alert a estação atual.
Considere:
- 22/12 a 21/03 - Verão;
- 22/03 a 21/06 - Outono;
- 22/06 a 21/09 - Inverno;
- 22/09 a 21/12 - Primavera.
*/


//Data Atual
var dataAtual = new Date();
var ano = dataAtual.getFullYear();

//Verão
inicioVerao = new Date(ano,12,22);
fimVerao = new Date(ano,03,21);
//Outono
inicioOutono = new Date(ano,03,22);
fimOutono = new Date(ano,06,21);
//Inverno
inicioInverno = new Date(ano,06,22);
fimInverno = new Date(ano,09,21);
//Primavera
inicioInverno = new Date(ano,09,22);
fimInverno = new Date(ano,12,21);


if(dataAtual>=inicioVerao && dataAtual<=fimVerao){
    alert('Verão');
}else 
    if( dataAtual<=fimOutono){
        alert('Outono');
    }else 
        if(dataAtual>=inicioInverno && dataAtual<=fimInverno){
            alert('Inverno');
        }else{
            alert('Primavera')
}