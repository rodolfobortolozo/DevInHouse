package org.example;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface LojaMapper {
    LojaMapper INSTANCE = Mappers.getMapper(LojaMapper.class);

    Loja toLoja(Loja2 loja2);
    Loja2 toLoja2(Loja loja);
}
