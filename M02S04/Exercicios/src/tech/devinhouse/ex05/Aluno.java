package tech.devinhouse.ex05;

public class Aluno extends Pessoa {

  private String matricula;

  public String registrar(){
    String nomeCompleto = obterNomeCompleto();
    return "Sou o "+ nomeCompleto +" e minha matricula é "+matricula;
  }

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }
}
