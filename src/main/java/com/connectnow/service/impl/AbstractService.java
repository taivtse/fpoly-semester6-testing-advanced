package com.connectnow.service.impl;

import com.connectnow.converter.GenericConverter;
import com.connectnow.dao.GenericDao;
import com.connectnow.paging.Pageable;
import com.connectnow.service.GenericService;
import org.hibernate.criterion.Criterion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AbstractService<ID extends Serializable, D, E> implements GenericService<ID, D> {
    protected GenericConverter<D, E> converter;
    protected GenericDao<ID, E> genericDao;

    AbstractService(GenericDao genericDao, GenericConverter genericConverter) {
        this.genericDao = genericDao;
        this.converter = genericConverter;
    }

    @Override
    public List<D> findAll() {
        List<E> entityList = genericDao.findAll();
        List<D> dtoList = new ArrayList<>();

//        convert entity to dto and add it to dto list
        for (E entity : entityList) {
            dtoList.add(converter.entityToDto(entity));
        }

        return dtoList;
    }

    @Override
    public List<D> findAllByProperties(Pageable pageable, List<Criterion> criterionList) {
        List<E> entityList = genericDao.findAllByProperties(pageable, criterionList);
        List<D> dtoList = new ArrayList<>();

//        convert entity to dto and add it to dto list
        for (E entity : entityList) {
            dtoList.add(converter.entityToDto(entity));
        }

        return dtoList;
    }

    @Override
    public D findOneById(ID id) {
        E entity = genericDao.findOneById(id);
        return converter.entityToDto(entity);
    }

    @Override
    public D findOneByProperties(List<Criterion> criterionList) {
        E entity = genericDao.findOneByProperties(criterionList);
        return converter.entityToDto(entity);
    }

    @Override
    public D save(D dto) throws Exception {
        E entity = converter.dtoToEntity(dto);
        genericDao.save(entity);
        return converter.entityToDto(entity);
    }

    @Override
    public D update(D dto) throws Exception {
        E entity = converter.dtoToEntity(dto);
        genericDao.update(entity);
        return converter.entityToDto(entity);
    }

    @Override
    public void delete(D dto) throws Exception {
        E entity = converter.dtoToEntity(dto);
        genericDao.delete(entity);
    }

    @SafeVarargs
    @Override
    public final void deleteById(ID... ids) throws Exception {
        for (ID id : ids) {
            genericDao.deleteById(id);
        }
    }
}
