package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Pessoa pessoa = Pessoa.builder()
                .id(1L)
                .nome("Nome")
                .build();


        System.out.println(pessoa.getId());
        System.out.println(pessoa.getNome());

        System.out.println( pessoa );
    }
}
