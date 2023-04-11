package com.example.thymelead.controller.dto;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PessoaAtualizarDto {

    private Long id;
    private String nome;
    private Integer idade;



}
