package com.br.devinhouse.contacorrente.model.response;

import com.br.devinhouse.contacorrente.model.entity.Conta;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ToString
@EqualsAndHashCode
public class ClienteResponse implements Serializable {

    private Long id;
    private String nome;
    private Long cpf;
    private String logradouro;
    private String nroLogradouro;
    private String bairro;
    private String complemento;
    private String cidade;
    private String uf;
    private Integer ativo;
    private Date dtaCreated;
    private Date dtaUpdate;
}
