package com.br.devinhouse.contacorrente.mapper;

import com.br.devinhouse.contacorrente.model.entity.Cliente;
import com.br.devinhouse.contacorrente.model.entity.Conta;
import com.br.devinhouse.contacorrente.model.request.ContaRequest;
import com.br.devinhouse.contacorrente.model.response.ClienteResponse;
import com.br.devinhouse.contacorrente.model.response.ContaResponse;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContaMapper {
    ContaMapper INSTANCE = Mappers.getMapper(ContaMapper.class);

    ContaRequest doContaRequest(Conta conta);
    ContaResponse doContaResponse (Conta conta);
    List<ContaResponse> toListContaResponse(List<Conta> conta);
    Conta fromContaRequest(ContaRequest contaRequest);

}

