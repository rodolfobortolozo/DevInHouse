package tech.devinhouse.locadora.model.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoriaRequest {

    private Long id;

    @NotBlank
    private String descricao;

}
