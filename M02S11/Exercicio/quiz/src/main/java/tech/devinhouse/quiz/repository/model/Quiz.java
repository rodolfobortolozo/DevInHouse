package tech.devinhouse.quiz.repository.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "QUIZ")
@Data
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDQUIZ",unique = true,nullable = false)
    private Long id;

    @Column(name = "NOME",nullable = false)
    private String nome;

    @Column(name = "DESCRICAO")
    private String descricao;
}

