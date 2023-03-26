package org.example;

import org.example.repository.CursoRepository;
import org.example.service.CursoService;
import org.example.service.CursoService2;

/**
 * Hello world!
 *
 */
public class ExemploApp
{
    public static void main( String[] args )
    {
        //Dependencia
        // a palavra new define o controle da dependencia
        CursoRepository cursoRepository = new CursoRepository();

        //Dependente do CursoRepository
        // injeção é colocar a dependencia no construtor do dependente
        CursoService cursoService = new CursoService(cursoRepository);
        CursoService2 cursoService2 = new CursoService2(cursoRepository);

        System.out.println( "Hello World!" );
    }
}
