package org.example.service;

import org.example.model.Curso;
import org.example.repository.CursoRepository;
import org.springframework.stereotype.Service;

@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository){
        this.cursoRepository = cursoRepository;
        System.out.println(this.cursoRepository);
    }


    public boolean adicionarCurso(Curso curso){
        curso.setNome(curso.getNome()+" nome ok");
        return cursoRepository.adicionaCurso(curso);
    }

    public void printarCursos(){
        for (Curso curso :
                cursoRepository.retornaListaCursos()) {
            System.out.println(curso);
        }
    }
}
