package tech.devinhouse.ex05;

public class Main {
  public static void main(String[] args) {
    Aluno aluno = new Aluno();

    aluno.setMatricula("123456");
    aluno.nome = "Rodolfo";
    aluno.sobrenome = "Bortolozo";

    String resultado = aluno.registrar();

    System.out.println(resultado);

  }
}
