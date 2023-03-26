package com.br.devinhouse.contacorrente.mapper;

import com.br.devinhouse.contacorrente.model.entity.Cliente;
import com.br.devinhouse.contacorrente.model.request.ClienteRequest;
import com.br.devinhouse.contacorrente.model.response.ClienteResponse;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteMapper INSTANCE = Mappers.getMapper(ClienteMapper.class);
    ClienteRequest toClienteRequest(Cliente cliente);
    ClienteResponse toClienteResponse(Cliente cliente);
    List<ClienteResponse> toListClienteResponse(List<Cliente> cliente);
    @InheritInverseConfiguration
    Cliente fromClientRequest(ClienteRequest clienteRequest);

}
