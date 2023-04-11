package tech.devinhouse.quiz.repository.model.dto;

import lombok.Data;

@Data
public class PerguntaRequest {

    private String titulo;
    private String texto;
    private Long quiz;
}
