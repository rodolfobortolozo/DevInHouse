package tech.devinhouse.quiz.repository.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RespostaRequest {

    @NotEmpty
    private String texto;
    @NotNull
    private Long idPergunta;
}
