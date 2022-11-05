
  // Vitória = 3 pontos
  // Derrota = 0 pontos
  // Empate  = 1 ponto


export default class Time {
  vitorias = 0
  derrotas = 0
  empates = 0
  golsMarcados = 0
  golsSofridos = 0

  constructor(nome, sigla) {
    this.nome = nome
    this.sigla = sigla
  }

  get numeroDeJogos() {
    return this.vitorias + this.derrotas + this.empates
  }

  get numeroDePontos() {
    return (this.vitorias * 3) + this.empates
  }

  computarPartida(partida) {
    let golsMarcados = 0
    let golsSofridos = 0

    if (partida.siglaTimeA === this.sigla) {
      golsMarcados = partida.golsTimeA
      golsSofridos = partida.golsTimeB
    } else if (partida.siglaTimeB === this.sigla) {
      golsMarcados = partida.golsTimeB
      golsSofridos = partida.golsTimeA
    } else {
      return // interrompe a execução
    }

    if (golsMarcados > golsSofridos) {
      this.vitorias++
    } else if (golsMarcados < golsSofridos) {
      this.derrotas++
    } else {
      this.empates++
    }

    this.golsMarcados += golsMarcados
    this.golsSofridos += golsSofridos
  }

  exibirSituacao() {
    console.log(`Time: ${this.nome} (${this.sigla})`)
    console.log(`Vitorias: ${this.vitorias}`)
    console.log(`Derrotas: ${this.derrotas}`)
    console.log(`Empates: ${this.empates}`)
    console.log(`Gols Marcados: ${this.golsMarcados}`)
    console.log(`Gols Sofridos: ${this.golsSofridos}`)
  }
}
