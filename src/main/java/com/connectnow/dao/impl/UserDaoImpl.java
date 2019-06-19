package com.connectnow.dao.impl;

import com.connectnow.dao.UserDao;
import com.connectnow.entity.UserEntity;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<Long, UserEntity> implements UserDao {

    @Override
    public UserEntity findPartnerUserByChatBoxId(Long userId, Long chatBoxId) {
        UserEntity entityList;

        Session session = this.getSession();
        try {
            Criteria criteria = session.createCriteria(this.getPersistenceClass(), "user");
            criteria.createAlias("user.memberList", "member");
            criteria.add(Restrictions.eq("member.chatBox.id", chatBoxId));
            criteria.add(Restrictions.ne("member.user.id", userId));
            entityList = (UserEntity) criteria.uniqueResult();
        } finally {
            session.close();
        }

        return entityList;
    }
}
