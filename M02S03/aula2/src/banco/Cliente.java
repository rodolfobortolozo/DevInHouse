package banco;

public class Cliente {
    String nomeCliente;
    String cpfCliente;
    Integer idadeCliente;

    public Cliente(String nomeCliente, String cpfCliente, Integer idadeCliente) {
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.idadeCliente = idadeCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nomeCliente='" + nomeCliente + '\'' +
                ", cpfCliente='" + cpfCliente + '\'' +
                ", idadeCliente=" + idadeCliente +
                '}';
    }
}
