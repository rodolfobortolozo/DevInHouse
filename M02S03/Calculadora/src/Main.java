public class Main {
  public static void main(String[] args) {
      ContaBancaria contaBancaria = new ContaBancaria();

      contaBancaria.setDono("Rodolfo");
      contaBancaria.depositar(10d);
      contaBancaria.sacar(7d);

      Double saldoConta = contaBancaria.saldo();
      System.out.println("Saldo da sua conta é de: "+saldoConta);

    contaBancaria.calcularMdc(20,6);


    Pessoa pessoa = new Pessoa("Rodolfo",33,"Brasil");

    pessoa.printPessoa();
  }
}