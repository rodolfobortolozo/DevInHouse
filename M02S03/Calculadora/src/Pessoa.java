public class Pessoa {
  String nome;
  Integer idade;
  String paisOrigem;

  Pessoa(String nome, Integer idade, String paisOrigem){
    this.nome = nome;
    this.idade = idade;
    this.paisOrigem = paisOrigem;
  }

  public void printPessoa(){
    System.out.println("Nome: " + this.nome + " Idade: " + this.idade + " País de origem: " + this.paisOrigem );

  }
}
