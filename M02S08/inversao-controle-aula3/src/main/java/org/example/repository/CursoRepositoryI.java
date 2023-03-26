package org.example.repository;

import org.example.model.Curso;

import java.util.ArrayList;
import java.util.List;

public interface CursoRepositoryI {

    boolean adicionaCurso(Curso curso);
    List<Curso> retornaListaCursos();
}
