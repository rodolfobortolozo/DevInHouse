package tech.devinhouse.quiz.repository.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity(name = "PERGUNTAS")
@Data
public class Pergunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDPERGUNTA", unique = true, nullable = false)
    private Long id;

    @Column(name = "TITULO", nullable = false)
    private String titulo;

    @Column(name = "TEXTO")
    private String texto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IDQUIZ")
    private Quiz quiz;

    @JsonIgnore
    @ManyToAny(fetch = FetchType.EAGER)
    @JoinTable(name = "PERGUNTA_RESPOSTAS", joinColumns = @JoinColumn(name = "IDPERGUNTA"), inverseJoinColumns = @JoinColumn(name = "IDRESPOTA"))
    private List<Resposta> perguntas;

}
