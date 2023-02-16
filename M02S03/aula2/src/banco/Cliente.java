package banco;

public class Cliente {
    private String nomeCliente;
    private String cpfCliente;
    private Integer idadeCliente;

    public Cliente() {
    }

    public Cliente(String nomeCliente, String cpfCliente, Integer idadeCliente) {
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
        this.idadeCliente = idadeCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public Integer getIdadeCliente() {
        return idadeCliente;
    }

    public void setIdadeCliente(Integer idadeCliente) {
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
