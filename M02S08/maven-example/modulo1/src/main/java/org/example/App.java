package org.example;

import org.mapstruct.factory.Mappers;

/**
 * Hello world!
 *
 */
public class App 
{


    public static void main( String[] args )
    {
        Loja loja = new Loja("nome","Geraldino de Souza Machado");

        Loja2 loja2 = LojaMapper.INSTANCE.toLoja2(loja);

        System.out.println( loja2);
    }
}
