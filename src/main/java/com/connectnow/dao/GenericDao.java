package com.connectnow.dao;

import com.connectnow.paging.Pageable;
import org.hibernate.criterion.Criterion;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<ID extends Serializable, T> {
    List<T> findAll(Pageable pageable);

    T findOneById(ID id);

    List<T> findAllByProperties(Pageable pageable, List<Criterion> properties);

    T findOneByProperties(List<Criterion> properties);

    void save(T entity) throws Exception;

    void update(T entity) throws Exception;

    void delete(T entity) throws Exception;
}