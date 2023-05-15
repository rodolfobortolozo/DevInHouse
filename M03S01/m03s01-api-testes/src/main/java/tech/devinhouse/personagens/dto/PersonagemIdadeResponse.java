package tech.devinhouse.personagens.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonagemIdadeResponse {

    private String nome;

    private Integer idade;

}
