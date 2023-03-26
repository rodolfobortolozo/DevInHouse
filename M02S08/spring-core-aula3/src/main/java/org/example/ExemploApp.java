package org.example;

import org.example.configuration.BeanConfig;
import org.example.model.Curso;
import org.example.repository.CursoRepository;
import org.example.service.CursoService;
import org.example.service.CursoService2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class ExemploApp
{
    public static void main( String[] args )
    {

        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(BeanConfig.class);

        //extraio o return new CursoService que está no BeanConfig
        //temos a ação do container de IoC - Inversion of Control
        //Injeção de dependencia
        CursoService cursoService = applicationContext
                .getBean("cursoService", CursoService.class);

        CursoService2 cursoService2 = applicationContext
                .getBean("cursoService2", CursoService2.class);

        cursoService.adicionarCurso(new Curso("nome1"));
        cursoService.adicionarCurso(new Curso("nome2"));

        cursoService2.adicionarCurso(new Curso("Mike"));
        cursoService2.adicionarCurso(new Curso("Mikeeee"));


        cursoService.printarCursos();

    }
}
