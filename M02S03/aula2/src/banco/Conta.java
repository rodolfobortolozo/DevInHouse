package banco;

public class Conta {
    String nomeConta;
    Double saldoConta;
    Integer numeroConta;
    Cliente cliente;

    public Conta(String nomeConta, Double saldoConta, Integer numeroConta, Cliente cliente, Agencia agencia) {
        this.nomeConta = nomeConta;
        this.saldoConta = saldoConta;
        this.numeroConta = numeroConta;
        this.cliente = cliente;

        agencia.contas.add(this);

    }

    @Override
    public String toString() {
        return "Conta{" +
                "nomeConta='" + nomeConta + '\'' +
                ", saldoConta=" + saldoConta +
                ", numeroConta=" + numeroConta +
                ", cliente=" + cliente +
                '}';
    }
}
