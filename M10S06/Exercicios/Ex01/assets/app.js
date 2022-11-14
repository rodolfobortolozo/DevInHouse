function sleep  (valor) {
    return new Promise((resolve) => {
      setTimeout(()=>{resolve(valor)}, 3000);
    })
  }

  sleep(3)
    .then((resultado)=>console.log(resultado));