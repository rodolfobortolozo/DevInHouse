package org.example.repository;

import org.example.model.Curso;

import java.util.ArrayList;
import java.util.List;

public class CursoRepository {
    private static List<Curso> list = new ArrayList<Curso>();

    public boolean adicionaCurso(Curso curso){
            return list.add(curso);
        }
        public List<Curso> retornaListaCursos(){
            return list;
    }
}
