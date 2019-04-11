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
    final public List<T> findAll(Pageable pageable) {
        List<T> entityList;

        Session session = this.getSession();
        try {
            Criteria criteria = session.createCriteria(this.persistenceClass);
            this.setPageable(pageable, criteria);
            entityList = criteria.list();
        } finally {
            session.close();
        }

        return entityList;
    }

    @Override
    public T findOneById(ID id) {
        T entity;

        Session session = this.getSession();
        try {
            entity = (T) session.get(this.persistenceClass, id);
        } finally {
            session.close();
        }

        return entity;
    }

    @Override
    public List<T> findAllByProperties(Pageable pageable, List<Criterion> properties) {
        List<T> entityList;
        Session session = this.getSession();

        try {
            Criteria criteria = session.createCriteria(this.persistenceClass);

            this.setPageable(pageable, criteria);

//        set properties search
            if (properties != null) {
                properties.forEach(criteria::add);
            }

            entityList = criteria.list();
        } finally {
            session.close();
        }

        return entityList;
    }

    @Override
    public Long countByProperties(List<Criterion> properties) {
        Long count;
        Session session = this.getSession();

        try {
            Criteria criteria = session.createCriteria(this.persistenceClass);

//        set properties search
            if (properties != null) {
                properties.forEach(criteria::add);
            }

            criteria.setProjection(Projections.rowCount());

            count = (Long) criteria.uniqueResult();
        } finally {
            session.close();
        }

        return count;
    }

    @Override
    final public T findOneByProperties(List<Criterion> properties) {
        T entity;
        Session session = this.getSession();

        try {
            Criteria criteria = session.createCriteria(this.persistenceClass);
            if (properties != null) {
                properties.forEach(criteria::add);
            }

            entity = (T) criteria.uniqueResult();
        } finally {
            session.close();
        }

        return entity;
    }

    @Override
    final public void save(T entity) throws Exception {
        Session session = this.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(entity);
            session.flush();
            session.refresh(entity);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    final public void update(T entity) throws Exception {
        Session session = this.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(entity);
            session.flush();
            session.refresh(entity);
            transaction.commit();
        } catch (HibernateException e) {
            if (e instanceof NonUniqueObjectException) {
                entity = (T) session.merge(entity);
                session.update(entity);

                transaction.commit();
                return;
            }

            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    final public void delete(T entity) throws Exception {
        Session session = this.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(entity);
            session.flush();
            transaction.commit();
        } catch (HibernateException e) {
            if (e instanceof NonUniqueObjectException) {
                entity = (T) session.merge(entity);
                session.delete(entity);

                transaction.commit();
                return;
            }

            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteById(ID id) throws Exception {
        T entity = this.findOneById(id);
        this.delete(entity);
    }

    protected void setPageable(Pageable pageable, Criteria criteria) {
        if (pageable != null) {
//            set start position offset
            if (pageable.getOffset() != null && pageable.getOffset() >= 0) {
                criteria.setFirstResult(pageable.getOffset());
            }

//            set limit row
            if (pageable.getLimit() != null && pageable.getLimit() >= 0) {
                criteria.setMaxResults(pageable.getLimit());
            }

//            set sorter
            if (pageable.getSorter() != null
                    && !pageable.getSorter().getPropertyName().isEmpty()
                    && !pageable.getSorter().getDirection().isEmpty()) {
                criteria.addOrder(pageable.getSorter().getOrder());
            }
        }
    }
}
