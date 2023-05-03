package tech.devinhouse.exercicio01;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculo - Folha de Pagamento")
public class FolhaDePagamentoTest {

    FolhaDePagamento folhaDePagamento;

    @BeforeEach
    public void setup(){
        folhaDePagamento = new FolhaDePagamento();
    }

    @Nested
    @DisplayName("Teste de Calculo Salário Bruto")
    class CalculoSalarioBruto{
        @DisplayName("Quando informado a funcao gerente e gratificacao calcula o calcula salario bruto")
        @Test
        @Order(2)
        void calcula_salario_gerente_gratificacao(){
            //given
            Double salarioBase = 2000.0;
            Double gratificacao = 1000.0;
            String funcao = "gerente";
            Double vlrEsperado = 3900.0;

            //when
            Double resultado = folhaDePagamento.calcularSalarioBruto(salarioBase,gratificacao, funcao);

            //then
            assertNotNull(resultado);
            assertEquals(vlrEsperado, resultado);


        }

        @DisplayName("Quando não informado a funcao e gratificacao calcula o calcula salario bruto")
        @Test
        @Order(1)
        void calcula_salario_semfuncao(){
            //given
            Double salarioBase = 2000.0;
            Double gratificacao = null;
            String funcao = null;
            Double vlrEsperado = 2000.0;

            //when
            Double resultado = folhaDePagamento.calcularSalarioBruto(salarioBase,gratificacao, funcao);

            //then
            assertNotNull(resultado);
            assertEquals(vlrEsperado, resultado);


        }

        @Order(3)
        @DisplayName("Quando informado qualquer funcao e gratificacao calcula o calcula salario bruto")
        @Test
        void calcula_salario_qualquerfuncao_gratificacao(){
            //given
            Double salarioBase = 2000.0;
            Double gratificacao = 1000.0;
            String funcao = "vendedor";
            Double vlrEsperado = 3000.0;

            //when
            Double resultado = folhaDePagamento.calcularSalarioBruto(salarioBase,gratificacao, funcao);

            //then
            assertNotNull(resultado);
            assertEquals(vlrEsperado, resultado);


        }
        @Order(5)
        @DisplayName("Quando informado qualquer funcao e gratificacao nulla calcula o calcula salario bruto")
        @Test
        void calcula_salario_qualquerfuncao_semgratificacao(){
            //given
            Double salarioBase = 2000.0;
            Double gratificacao = null;
            String funcao = "vendedor";
            Double vlrEsperado = 2000.0;

            //when
            Double resultado = folhaDePagamento.calcularSalarioBruto(salarioBase,gratificacao, funcao);

            //then
            assertNotNull(resultado);
            assertEquals(vlrEsperado, resultado);


        }

        @DisplayName("Quando informado qualquer funcao e gratificacao zerada calcula o calcula salario bruto")
        @Test
        @Order(4)
        void calcula_salario_qualquerfuncao_gratificacaozerada(){
            //given
            Double salarioBase = 2000.0;
            Double gratificacao = 0.0;
            String funcao = "vendedor";
            Double vlrEsperado = 2000.0;

            //when
            Double resultado = folhaDePagamento.calcularSalarioBruto(salarioBase,gratificacao, funcao);

            //then
            assertNotNull(resultado);
            assertEquals(vlrEsperado, resultado);


        }

    }

    @Nested
    @DisplayName("Teste de Calculo Salário Liquido")
    class CalculoSalariLiquido{

        @DisplayName("Quando informado a funcao gerente e gratificacao calcula o calcula salario liquido")
        @Test
        void calcula_salario_liquido_gerente(){
            //given
            Double salarioBase = 2000.0;
            Double gratificacao = 1000.0;
            String funcao = "gerente";
            List<Double> descontos = List.of(300.0,200.0);

            Double vlrEsperado = descontos.stream().reduce(Double::sum).get();

            //when
            Double salarioBruto = folhaDePagamento.calcularSalarioBruto(salarioBase,gratificacao, funcao);

            Double resultado = folhaDePagamento.calcularSalarioLiquido(salarioBruto, descontos);

            //then
            assertNotNull(resultado);
            assertEquals(vlrEsperado, resultado);


        }

        @DisplayName("Quando informado outra funcao e gratificacao calcula o calcula salario liquido")
        @Test
        void calcula_salario_liquido_qualquerfuncao(){
            //given
            Double salarioBase = 2000.0;
            Double gratificacao = 1000.0;
            String funcao = "vendedor";
            List<Double> descontos = List.of(300.0, 500.0);
            Double vlrEsperado = descontos.stream().reduce(Double::sum).get();

            //when
            Double salarioBruto = folhaDePagamento.calcularSalarioBruto(salarioBase,gratificacao, funcao);

            Double resultado = folhaDePagamento.calcularSalarioLiquido(salarioBruto, descontos);

            //then
            assertNotNull(resultado);
            assertEquals(vlrEsperado, resultado);


        }

        @DisplayName("Quando informado outra funcao e gratificacao calcula o calcula salario liquido sem Desconto")
        @Test
        void calcula_salario_liquido_semdesconto(){
            //given
            Double salarioBase = 2000.0;
            Double gratificacao = 1000.0;
            String funcao = "vendedor";
            Double vlrEsperado = 3000.0;

            //when
            Double salarioBruto = folhaDePagamento.calcularSalarioBruto(salarioBase,gratificacao, funcao);

            Double resultado = folhaDePagamento.calcularSalarioLiquido(salarioBruto, null);

            //then
            assertNotNull(resultado);
            assertEquals(vlrEsperado, resultado);



        }

        @DisplayName("Quando informado desconto maior que salario Liquido cai na Exception IllegalStateException")
        @Test
        void calcula_salario_liquido_desconto_maior_salario(){
            //given
            Double salarioBase = 2000.0;
            Double gratificacao = 1000.0;
            String funcao = "vendedor";
            List<Double> descontos = List.of(2000.0, 1000.1);
            Double vlrEsperado = descontos.stream().reduce(Double::sum).get();

            //when
            Double salarioBruto = folhaDePagamento.calcularSalarioBruto(salarioBase,gratificacao, funcao);

            //then
            assertThrows(IllegalStateException.class,()->
                    folhaDePagamento.calcularSalarioLiquido(salarioBruto, descontos));




        }
    }

    @Nested
    @DisplayName("Teste Usando anotação de Parametros")
    class CalculoSalarioParam{

        @ParameterizedTest(name = "Função {2} salario {0} gratificacao {1} salario Esperado {3}")
        //@ValueSource(strings = {"gerente", "vendedor"})
        @CsvSource({
                "2000.00, 1000.00, gerente, 3900.00",
                "2500.00, 100.00, vendedor, 2600.00",
                "1000.00, 0, vendedor Junior, 1000.00",
                "1000.00, , vendedor, 1000.00",
                "1000.00, 100 , , 1000.00",
        })
        @DisplayName("Teste Salario Bruto utilizando @ParameterizedTest")
        void calcula_salario(Double salarioBase,  Double gratificacao, String funcao, Double vlrEsperado ){
            //given

            //when
            Double resultado = folhaDePagamento.calcularSalarioBruto(salarioBase,gratificacao, funcao);

            //then
            assertNotNull(resultado);
            assertEquals(vlrEsperado, resultado);


        }

    }
}
