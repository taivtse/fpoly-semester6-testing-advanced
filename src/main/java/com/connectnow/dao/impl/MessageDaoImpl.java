package com.connectnow.dao.impl;

import com.connectnow.dao.MessageDao;
import com.connectnow.entity.MessageEntity;
import com.connectnow.paging.Pageable;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MessageDaoImpl extends AbstractDaoImpl<Long, MessageEntity> implements MessageDao {
    private Logger logger = LoggerFactory.getLogger(MessageDaoImpl.class);

    @Override
    public List<MessageEntity> findAllByChatBoxId(Pageable pageable, Long chatBoxId) {
        List<MessageEntity> entityList;

        Session session = this.getSession();
        try {
            Criteria criteria = session.createCriteria(this.getPersistenceClass(), "message");
            this.setPageable(pageable, criteria);
            criteria.createAlias("message.member", "member");
            criteria.createAlias("member.chatBox", "chatBox");
            criteria.add(Restrictions.eq("chatBox.id", chatBoxId));
            criteria.addOrder(Order.asc("date"));

            entityList = criteria.list();
        } finally {
            session.close();
        }

        return entityList;
    }
}
