package tech.devinhouse.quiz.repository.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "RESPOSTAS")
@Data
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDRESPOSTA", unique = true, nullable = false)
    private Long id;

    @Column(name = "TEXTO", nullable = false)
    private String texto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDPERGUNTA")
    private Pergunta pergunta;
}
