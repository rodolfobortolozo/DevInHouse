package tech.devinhouse.quiz.repository.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class RespostaRequest {

    private String texto;
    private Long idPergunta;
}
