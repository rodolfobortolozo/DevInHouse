package org.example.repository;

import org.example.model.Curso;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CursoRepository {
    private static List<Curso> list = new ArrayList<Curso>();

    public boolean adicionaCurso(Curso curso){
            return list.add(curso);
        }
        public List<Curso> retornaListaCursos(){
            return list;
    }
}
