package org.example.service;

import org.example.model.Curso;
import org.example.repository.CursoRepository;

//
public class CursoService2 {

    private final CursoRepository cursoRepository;

    public CursoService2(CursoRepository cursoRepository){
        this.cursoRepository = cursoRepository;
        System.out.println(this.cursoRepository);
    }

    public boolean adicionarCurso(Curso curso){
        if(!curso.getNome().equals("Mike")){
            return cursoRepository.adicionaCurso(curso);
        }
        return false;
    }

}
