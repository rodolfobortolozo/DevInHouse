package tech.devinhouse.locadora.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tech.devinhouse.locadora.model.Filme;
import tech.devinhouse.locadora.model.request.FilmeRequest;

@Mapper(componentModel = "spring")
public interface FilmeMapper {

  FilmeMapper INSTANCE = Mappers.getMapper(FilmeMapper.class);

  Filme reqToFilme(FilmeRequest filmeRequest);


}
