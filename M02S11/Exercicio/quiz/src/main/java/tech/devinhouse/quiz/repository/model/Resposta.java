package tech.devinhouse.quiz.repository.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "RESPOSTAS")
@Data
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDRESPOSTA", unique = true, nullable = false)
    private Long id;

    @Column(name = "TEXTO", nullable = false)
    private String texto;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "perguntas")
    private List<Pergunta> perguntas;
}
