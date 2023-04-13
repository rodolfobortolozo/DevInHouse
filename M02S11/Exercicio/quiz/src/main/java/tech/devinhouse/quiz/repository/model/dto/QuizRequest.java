package tech.devinhouse.quiz.repository.model.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class QuizRequest {

    @NotEmpty
    private String nome;
    @NotEmpty
    private String descricao;

}
