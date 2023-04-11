package tech.devinhouse.locadora.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tech.devinhouse.locadora.model.TabelaPreco;
import tech.devinhouse.locadora.model.request.TabelaPrecoRequest;

@Mapper(componentModel = "spring")
public interface  TabelaPrecoMapper {

  TabelaPrecoMapper INSTANCE = Mappers.getMapper(TabelaPrecoMapper.class);

  TabelaPreco reqToTabPreco(TabelaPrecoRequest tabelaPrecoRequest);


}
