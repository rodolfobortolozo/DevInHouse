import Time from './Time.js'
import Partida from './Partida.js'

console.log('m1-s05-e7')
// Vitória = 3 pontos
// Derrota = 0 pontos
// Empate  = 1 ponto

const times = [
  new Time("Grêmio", "GRE"),
  new Time("Internacional", "INT"),
  new Time("Santos", "SAN"),
  new Time("São Paulo", "SAO")
]

const partidas = [
  new Partida("GRE", 2, "INT", 3),
  new Partida("SAN", 1, "SAO", 1),
  new Partida("INT", 1, "SAO", 2),
  new Partida("SAN", 0, "GRE", 1)
]

partidas.forEach(partida => {
  times.forEach(time => {
    time.computarPartida(partida)
  })
})

times.forEach(time => {
  time.exibirSituacao()
})
