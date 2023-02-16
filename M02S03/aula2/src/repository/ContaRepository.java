package repository;

import banco.Conta;

import java.util.ArrayList;
import java.util.List;

public class ContaRepository {

  List<Conta> arrConta = new ArrayList<>();

  public void addConta(Conta conta){
    conta.setId(arrConta.size() + 1);
    arrConta.add(conta);

  }

  public void retornoConta(){
    arrConta.forEach(elment -> System.out.println(elment.toString()));
  }

}
