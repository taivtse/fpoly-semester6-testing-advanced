package com.connectnow.converter;

import java.util.List;

public interface GenericConverter<D, E> {
    D entityToDto(E entity);

    E dtoToEntity(D dto);

    List<D> entityListToDtoList(List<E> entityList);

    List<E> dtoListToEntityList(List<D> dtoList);
}
