package com.connectnow.service;

import com.connectnow.paging.Pageable;
import org.hibernate.criterion.Criterion;

import java.io.Serializable;
import java.util.List;

public interface GenericService<ID extends Serializable, D> {
    List<D> findAll();

    List<D> findAllByProperties(Pageable pageable, List<Criterion> criterionList);

    D findOneById(ID id);

    D findOneByProperties(List<Criterion> criterionList);

    D save(D dto) throws Exception;

    D update(D dto) throws Exception;

    void delete(D dto) throws Exception;

    void deleteById(ID... ids) throws Exception;
}
