package com.connectnow.dao.impl;

import com.connectnow.dao.ChatBoxDao;
import com.connectnow.entity.ChatBoxEntity;
import com.connectnow.paging.Pageable;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public class ChatBoxDaoImpl extends AbstractDaoImpl<BigInteger, ChatBoxEntity> implements ChatBoxDao {
    private Logger logger = LoggerFactory.getLogger(ChatBoxDaoImpl.class);

    @Override
    public List<ChatBoxEntity> findAllByUserId(Pageable pageable, BigInteger userId) {
        List<ChatBoxEntity> entityList;

        Session session = this.getSession();
        try {
            Criteria criteria = session.createCriteria(this.getPersistenceClass(), "chatbox");
            this.setPageable(pageable, criteria);
            criteria.createAlias("chatbox.memberList", "member");
            criteria.add(Restrictions.eq("member.user.id", userId));
            criteria.addOrder(Order.desc("chatbox.lastMessageDate"));
            entityList = criteria.list();
        } catch (HibernateException e) {
            logger.error(e.getMessage(), e);
            throw e;
        } finally {
            session.close();
        }

        return entityList;
    }
}
