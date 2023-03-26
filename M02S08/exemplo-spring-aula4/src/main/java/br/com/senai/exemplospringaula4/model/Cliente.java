package br.com.senai.exemplospringaula4.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @CPF
    private String cpf;
    @NotBlank
    private String nome;
    private Integer idade;
}
