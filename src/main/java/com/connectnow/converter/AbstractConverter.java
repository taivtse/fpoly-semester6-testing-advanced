package com.connectnow.converter;

import org.modelmapper.ModelMapper;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AbstractConverter<D, E> implements GenericConverter<D, E> {
    private Class<D> dtoClass;
    private Class<E> entityClass;
    private ModelMapper modelMapper = new ModelMapper();

    public AbstractConverter() {
        // set persistenceClass = T
        Type type = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        dtoClass = (Class) parameterizedType.getActualTypeArguments()[0];
        entityClass = (Class) parameterizedType.getActualTypeArguments()[1];
    }

    @Override
    public D entityToDto(E entity) {
        if (entity == null) {
            return null;
        }
        return modelMapper.map(entity, dtoClass);
    }

    @Override
    public E dtoToEntity(D dto) {
        if (dto == null) {
            return null;
        }
        return modelMapper.map(dto, entityClass);
    }

    @Override
    public List<D> entityListToDtoList(List<E> entityList) {
        List<D> dtoList = new ArrayList<>();
        entityList.forEach(entity -> dtoList.add(this.entityToDto(entity)));
        return dtoList;
    }

    @Override
    public List<E> dtoListToEntityList(List<D> dtoList) {
        List<E> entityList = new ArrayList<>();
        dtoList.forEach(dto -> entityList.add(this.dtoToEntity(dto)));
        return entityList;
    }
}
