package com.connectnow.dao;

import com.connectnow.entity.UserEntity;

import java.math.BigInteger;

public interface UserDao extends GenericDao<BigInteger, UserEntity> {
    UserEntity findPartnerUserByChatBoxId(BigInteger userId, BigInteger chatBoxId);
}
