package tech.devinhouse;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Teste Calculadora")
class CalculadoraTest {

  Calculadora calculadora = new Calculadora();

  //pode ser qualquer nome
  @BeforeEach // metodo com codigo executado Antes de cada teste
  public void setup(){
    System.out.println("Executado antes de cada metodo de teste");
    Calculadora calculadora = new Calculadora();
  }

  @Test
  @DisplayName("Quando soma 2 numeros positivos, deve retornar um numero positivo")
  void calcular_adicao(){

    //given - pre condições
    //Calculadora calculadora = new Calculadora();
    Double valor1 = 5.0;
    Double valor2 = 3.0;
    //when - quando chama o metodo que quero testar;
    Double resultado = calculadora.calcular(valor1,valor2,Operacao.ADICAO);
    //then - então
    assertNotNull(resultado); // Conferindo se o resultado não é nullo
    assertEquals(8,resultado);
  }

  @Test
  @DisplayName("Quando soma 2 numeros positivos, deve retornar um numero negativo")
  void calcular_adicao_negativo(){

    //given - pre condições
    //Calculadora calculadora = new Calculadora();
    Double valor1 = -5.0;
    Double valor2 = 3.0;
    //when - quando chama o metodo que quero testar;
    Double resultado = calculadora.calcular(valor1,valor2,Operacao.ADICAO);
    //then - então
    assertNotNull(resultado); // Conferindo se o resultado não é nullo
    assertEquals(-2,resultado);
  }

  @Test
  @DisplayName("Quando subtração de 2 numeros positivos, deve retornar positivo")
  void calcular_subtracaopositiva(){
    Double valor1 = 5.6;
    Double valor2 = 3.3;
    Double resultado = calculadora.calcular(valor1, valor2, Operacao.SUBTRACAO);

    assertNotNull(resultado);
    assertTrue(resultado instanceof Double);
    assertEquals(resultado,2.3);

  }

  @Test
  @DisplayName("Quando informado operação Inexisteste")
  void calcular_operacaoInexistente(){
    Double valor1 = 5.6;
    Double valor2 = 3.3;

    assertThrows(IllegalArgumentException.class, ()->
            calculadora.calcular(valor1, valor2, Operacao.INEXISTENTE));

  }

  @Nested // POsso Criar classes para organizar os testes
  class calcularSUB{
    @Test
    @DisplayName("Quando informado operação Inexisteste")
    void calcular_operacaoInexistente(){
      Double valor1 = 5.6;
      Double valor2 = 3.3;

      assertThrows(IllegalArgumentException.class, ()->
              calculadora.calcular(valor1, valor2, Operacao.INEXISTENTE));

    }
  }

}