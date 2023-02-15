package banco;

import java.util.ArrayList;
import java.util.List;

public class Agencia {
    String nomeAgencia;
    List<Conta> contas = new ArrayList<>();

    Agencia(String nomeAgencia){
        this.nomeAgencia = nomeAgencia;
    }

    @Override
    public String toString() {
        return "Agencia{" +
                "nomeAgencia='" + nomeAgencia + '\'' +
                ", contas=" + contas +
                '}';
    }
}
