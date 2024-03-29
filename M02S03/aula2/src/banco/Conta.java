package banco;

import java.util.ArrayList;
import java.util.List;

public class Conta {

    private Integer id;
    private String nomeConta;
    private  Double saldoConta;
    private  Integer numeroConta;
    private Cliente cliente;

    List<Conta> arrConta = new ArrayList<>();

    public Conta(String nomeConta, Double saldoConta, Integer numeroConta, Cliente cliente, Agencia agencia) {
        this.nomeConta = nomeConta;
        this.saldoConta = saldoConta;
        this.numeroConta = numeroConta;
        this.cliente = cliente;

    }

    public Conta() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeConta() {
        return nomeConta;
    }

    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }

    public Double getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(Double saldoConta) {
        this.saldoConta = saldoConta;
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Conta {" +
                "id='" + id + '\'' +
                "nomeConta='" + nomeConta + '\'' +
                ", saldoConta=" + saldoConta +
                ", numeroConta=" + numeroConta +
                ", cliente=" + cliente +
                '}';
    }

}
