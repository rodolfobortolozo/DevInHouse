package tech.devinhouse;

public class Calculadora {

    public Double calcular(Double valor1, Double valor2, Operacao operacao) {
        Double resultado;
        switch (operacao) {
            case ADICAO:
                resultado = valor1 + valor2;
                break;
            case SUBTRACAO:
                resultado = valor1 - valor2;
                break;
            case DIVISAO:
                resultado = valor1 / valor2;
                break;
            case MULTIPLICACAO:
                resultado = valor1 * valor2;
                break;
            default:
                throw new IllegalArgumentException("Operacao nao informada!");
        }
        return resultado;
    }

}
