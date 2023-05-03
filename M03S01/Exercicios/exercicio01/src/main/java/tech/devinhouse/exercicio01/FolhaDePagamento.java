package tech.devinhouse.exercicio01;
import java.util.List;

public class FolhaDePagamento {

    public Double calcularSalarioBruto(Double salarioBase, Double gratificacao, String funcao) {
        Double salario = salarioBase;
        if (gratificacao != null) {
            salario += gratificacao;
        }
        if (funcao.equals("gerente")) {
            salario *= 1.30;
        }
        return salario;
    }

    public Double calcularSalarioLiquido(Double salario, List<Double> descontos) {
        if (descontos == null || descontos.isEmpty()) {
            return salario;
        }
        for(Double desconto : descontos) {
            salario -= desconto;
        }
        if (salario < 0) {
            throw new IllegalStateException();
        }
        return salario;
    }
}