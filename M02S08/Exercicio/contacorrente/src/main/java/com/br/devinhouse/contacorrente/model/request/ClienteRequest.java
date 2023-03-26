package com.br.devinhouse.contacorrente.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;


@Data
@ToString
@EqualsAndHashCode
public class ClienteRequest implements Serializable  {

    private Long id;
    @NotBlank(message = "{name.not.blank}")
    private String nome;
    private Long cpf;
    private String logradouro;
    private String nroLogradouro;
    private String bairro;
    private String complemento;
    private String cidade;
    private String uf;
    private Integer ativo;

}
