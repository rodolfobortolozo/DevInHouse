package tech.devinhouse.personagens.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonagemResponse {

    private Long id;

    private Long cpf;

    private String nome;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy") // Converte a data neste formato
    private LocalDate dataNascimento;

    private String serie;

}
