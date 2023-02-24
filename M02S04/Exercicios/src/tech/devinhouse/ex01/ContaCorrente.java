package tech.devinhouse.ex01;

public class ContaCorrente extends Conta implements Operavel {
  @Override
  protected double obterSaldo() {
    return saldo;
  }

  @Override
  public void depositar(double valor) {
    saldo +=saldo;
  }

  @Override
  public void sacar(double valor) {
    saldo -=saldo;
  }
}
