package com.br.devinhouse.contacorrente.model.response;

import com.br.devinhouse.contacorrente.model.entity.Cliente;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@ToString
@EqualsAndHashCode
public class ContaResponse implements Serializable {

    private Long id;
    private String nroConta;
    private Date dtaCreated;
    private Date dtaUpdate;
    private ClienteResponse cliente;
}
