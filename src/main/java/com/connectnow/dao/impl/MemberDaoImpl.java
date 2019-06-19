package com.connectnow.dao.impl;

import com.connectnow.dao.MemberDao;
import com.connectnow.entity.MemberEntity;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public class MemberDaoImpl extends AbstractDaoImpl<Long, MemberEntity> implements MemberDao {
    @Override
    public MemberEntity findOneByChatBoxIdAndUserId(Long chatBoxId, Long userId) {
        Criterion criterion1 = Restrictions.eq("chatBox.id", chatBoxId);
        Criterion criterion2 = Restrictions.eq("user.id", userId);
        return this.findOneByProperties(Arrays.asList(criterion1, criterion2));
    }
}
