function digaOlaPara(nome, sobrenome) {
    console.log(`Olá ${nome} ${sobrenome ? ` ${sobrenome}` :''}!` );
   }
   
   digaOlaPara('Maria');
   setTimeout(digaOlaPara, 2000, 'Ana', 'Santos');
   digaOlaPara('Pedro');
   setTimeout(digaOlaPara, 1000, 'João');
   setTimeout(()=>console.log('Rodolfo'),1000);;


////

const interval = setInterval( digaOlaPara,1000,'Alessandra','Bortolozo');;
setTimeout(()=>clearInterval(interval),10000);

////

const minhaPromisse = new Promise((resolver, reject)=>{
    resolver('Ok');

    reject('Erro');
})

console.log(minhaPromisse);

const endereco = fetch('https://viacep.com.br/ws/15600076/json/')
                .then((resultado)=>{
                    return resultado.json();
                })
                .then((resultado)=>console.log(resultado))