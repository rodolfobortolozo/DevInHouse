package org.example.configuration;


import org.example.repository.CursoRepository;
import org.example.service.CursoService;
import org.example.service.CursoService2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example")
public class BeanConfig {

//    //fabricar o cursoRepository para o projeto
//    @Bean("cursoRepository")
//    public CursoRepository getCursoRepository(){
//        return new CursoRepository();
//    }
//
//    //fabricar o cursoService para o projeto
//    @Bean("cursoService")
//    public CursoService getCursoService(){
//        return new CursoService(getCursoRepository());
//    }
//
//    //fabricar o cursoService2 para o projeto
//    @Bean("cursoService2")
//    public CursoService2 getCursoService2(){
//        return new CursoService2(getCursoRepository());
//    }

}
