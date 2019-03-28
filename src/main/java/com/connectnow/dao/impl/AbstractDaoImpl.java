package com.connectnow.dao.impl;

import com.connectnow.dao.GenericDao;
import com.connectnow.paging.Pageable;
import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class AbstractDaoImpl<ID extends Serializable, T> implements GenericDao<ID, T> {
    @Autowired
    private SessionFactory sessionFactory;
    private Class<T> persistenceClass;

    public AbstractDaoImpl() {
        // set persistenceClass = T
        Type type = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        persistenceClass = (Class<T>) parameterizedType.getActualTypeArguments()[1];
    }

    protected Session getSession() {
        return sessionFactory.openSession();
    }

    @Override
    final public List<T> findAll() {
        List<T> list;
        Session session = this.getSession();
        list = session.createCriteria(this.persistenceClass).list();
        return list;
    }

    @Override
    public T findOneById(ID id) {
        T result;
        Session session = this.getSession();
        result = (T) session.get(this.persistenceClass, id);
        return result;
    }

    @Override
    public List<T> findAllByProperties(Pageable pageable, List<Criterion> properties) {
        Session session = this.getSession();
        Criteria cr = session.createCriteria(this.persistenceClass);

        if (pageable != null) {
//            set start position offset
            if (pageable.getOffset() != null && pageable.getOffset() >= 0) {
                cr.setFirstResult(pageable.getOffset());
            }

//            set limit row
            if (pageable.getLimit() != null && pageable.getLimit() >= 0) {
                cr.setMaxResults(pageable.getLimit());
            }

//            set sorter
            if (pageable.getSorter() != null
                    && !pageable.getSorter().getPropertyName().isEmpty()
                    && !pageable.getSorter().getDirection().isEmpty()) {
                cr.addOrder(pageable.getSorter().getOrder());
            }
        }

//        set properties search
        if (properties != null) {
            properties.forEach(cr::add);
        }

        return cr.list();
    }

    @Override
    public Long countByProperties(List<Criterion> properties) {
        Session session = this.getSession();
        Criteria cr = session.createCriteria(this.persistenceClass);

//        set properties search
        if (properties != null) {
            properties.forEach(cr::add);
        }

        cr.setProjection(Projections.rowCount());
        return (Long) cr.uniqueResult();
    }

    @Override
    final public T findOneByProperties(List<Criterion> properties) {
        Session session = this.getSession();
        Criteria cr = session.createCriteria(this.persistenceClass);
        if (properties != null) {
            properties.forEach(cr::add);
        }
        return (T) cr.uniqueResult();
    }

    @Override
    final public void save(T entity) throws Exception {
        Session session = this.getSession();
        session.save(entity);
        session.flush();
        session.refresh(entity);
    }

    @Override
    final public void update(T entity) throws Exception {
        Session session = this.getSession();
        try {
            session.update(entity);
            session.flush();
            session.refresh(entity);
        } catch (Exception e) {
            if (e instanceof NonUniqueObjectException) {
                entity = (T) session.merge(entity);
                session.update(entity);
                return;
            }
            throw e;
        }
    }

    @Override
    final public void delete(T entity) throws Exception {
        Session session = this.getSession();
        try {
            session.delete(entity);
            session.flush();
        } catch (Exception e) {
            if (e instanceof NonUniqueObjectException) {
                entity = (T) session.merge(entity);
                session.delete(entity);
                return;
            }
            throw e;
        }
    }
}
