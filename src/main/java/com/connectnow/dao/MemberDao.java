package com.connectnow.dao;

import com.connectnow.entity.MemberEntity;

import java.math.BigInteger;

public interface MemberDao extends GenericDao<Long, MemberEntity> {
    MemberEntity findOneByChatBoxIdAndUserId(Long chatBoxId, Long userId);
}
