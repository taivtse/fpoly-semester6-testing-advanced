package com.connectnow.dao.impl;

import com.connectnow.dao.UserDao;
import com.connectnow.entity.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<BigInteger, UserEntity> implements UserDao {
    private Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public UserEntity findPartnerUserByChatBoxId(BigInteger userId, BigInteger chatBoxId) {
        UserEntity entityList;

        Session session = this.getSession();
        try {
            Criteria criteria = session.createCriteria(this.getPersistenceClass(), "user");
            criteria.createAlias("user.memberList", "member");
            criteria.add(Restrictions.eq("member.chatBox.id", chatBoxId));
            criteria.add(Restrictions.ne("member.user.id", userId));
            entityList = (UserEntity) criteria.uniqueResult();
        } catch (HibernateException e) {
            logger.error(e.getMessage(), e);
            throw e;
        } finally {
            session.close();
        }

        return entityList;
    }
}
