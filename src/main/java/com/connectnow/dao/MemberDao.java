package com.connectnow.dao;

import com.connectnow.entity.MemberEntity;

import java.math.BigInteger;

public interface MemberDao extends GenericDao<BigInteger, MemberEntity> {
    MemberEntity findOneByChatBoxIdAndUserId(BigInteger chatBoxId, BigInteger userId);
}
