package banco.repository;

import java.util.ArrayList;
import java.util.List;

public class Agencia {
    private String nomeAgencia;
    List<Conta> contas = new ArrayList<>();

    public Agencia(String nomeAgencia){
        this.nomeAgencia = nomeAgencia;
    }

    public Agencia(){

    }

    public String getNomeAgencia() {
        return nomeAgencia;
    }

    public void setNomeAgencia(String nomeAgencia) {
        this.nomeAgencia = nomeAgencia;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    @Override
    public String toString() {
        return "Agencia{" +
                "nomeAgencia='" + nomeAgencia + '\'' +
                ", contas=" + contas +
                '}';
    }
}
