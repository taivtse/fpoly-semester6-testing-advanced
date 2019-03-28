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
    private SessionFactory sessionFactory;
    private Class<T> entityClass;

    @Autowired
    public AbstractDaoImpl(SessionFactory sessionFactory) {
        // set persistenceClass = T
        Type type = getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        entityClass = (Class<T>) parameterizedType.getActualTypeArguments()[1];

        this.sessionFactory = sessionFactory;
    }

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<T> findAll() {
        List<T> entityList = new ArrayList<>();
        Session session = this.getSession();

        try {
            entityList = session.createCriteria(this.entityClass).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return entityList;
    }

    @Override
    public List<T> findAllByProperties(Pageable pageable, List<Criterion> criterionList) {
        List<T> entityList = new ArrayList<>();
        Session session = this.getSession();
        Criteria criteria = session.createCriteria(this.entityClass);

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

        try {
//        set properties search
            if (criterionList != null) {
                criterionList.forEach(criteria::add);
            }
            entityList = criteria.list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return entityList;
    }

    @Override
    public Long countByProperties(List<Criterion> criterionList) {
        Session session = this.getSession();
        Criteria cr = session.createCriteria(this.entityClass);
        Long rowCount = 0L;

        try {
//        set properties search
            if (criterionList != null) {
                criterionList.forEach(cr::add);
            }

            cr.setProjection(Projections.rowCount());
            rowCount = (Long) cr.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return rowCount;
    }

    @Override
    public T findOneById(ID id) {
        Session session = this.getSession();
        T entity = null;

        try {
            entity = (T) session.get(this.entityClass, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return entity;
    }

    @Override
    public T findOneByProperties(List<Criterion> criterionList) {
        T entity = null;
        Session session = this.getSession();
        Criteria cr = session.createCriteria(this.entityClass);

        try {
            if (criterionList != null) {
                criterionList.forEach(criterion -> cr.add(criterion));
            }
            entity = (T) cr.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return entity;
    }

    @Override
    public void save(T entity) {
        Session session = this.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(entity);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public void update(T entity) {
        Session session = this.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.update(entity);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(T entity) {
        Session session = this.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.delete(entity);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            throw e;
        } finally {
            session.close();
        }
    }
}
