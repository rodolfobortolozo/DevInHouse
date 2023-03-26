package com.br.devinhouse.contacorrente.model.request;

import com.br.devinhouse.contacorrente.model.entity.Cliente;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
@EqualsAndHashCode
public class ContaRequest implements Serializable {
    private Long id;
    private String nroConta;

}
