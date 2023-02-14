public class ContaBancaria {

  private Double saldo = 0d;
  private String dono;

  public void sacar(Double valor){
    if(valor>saldo){
      System.out.println("Sr(a). " + this.dono + " o Saldo é de Insuficiente, saldo atual: "+ saldo);
    }else {
      saldo -= valor;
      System.out.println("Sr(a). " + this.dono + " o Valor sacado é de "+ valor+ ", saldo atual: "+ saldo);
    }
  }

  public void depositar(Double valor){
    saldo += valor;
    System.out.println("Sr(a). " + this.dono + " o Valor depositado de "+ valor+ ", saldo atual: "+ saldo);
  }

  public Double saldo(){
    return saldo;
  }

  public void setDono(String dono){
    this.dono = dono;
  }


  public  int calcularMdc(int a, int b){
    System.out.println(a+"-"+b);
    if ( a == 0 )
      return b;

    return calcularMdc( b % a, a );
  }
}
