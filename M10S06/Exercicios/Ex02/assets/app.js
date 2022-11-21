const horaAtual = ()=>{
    let dataAtual = new Date();
    let horas = ("00"+ dataAtual.getHours()).slice(-2);
    let minutos = ("00"+ dataAtual.getMinutes()).slice(-2);
    let segundos = ("00"+ dataAtual.getSeconds()).slice(-2);
  
    const hora = document.getElementById('hora');
    hora.innerHTML = `${horas}:${minutos}:${segundos}`;
  }
  
  setInterval(horaAtual, 2000);