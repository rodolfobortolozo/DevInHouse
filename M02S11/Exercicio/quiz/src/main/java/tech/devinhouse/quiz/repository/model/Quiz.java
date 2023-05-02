package tech.devinhouse.quiz.repository.model;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.OverridesAttribute.List;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Entity
@Table(name = "QUIZ")
@Data
public class Quiz  extends RepresentationModel<Quiz> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDQUIZ", unique = true, nullable = false)
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "DESCRICAO")
    private String descricao;

    @OneToMany(mappedBy = "quiz", fetch = FetchType.EAGER)
    private Collection<Pergunta> perguntas;
}
