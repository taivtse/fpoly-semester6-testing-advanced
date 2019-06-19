package com.connectnow.dao;

import com.connectnow.entity.UserEntity;

public interface UserDao extends GenericDao<Long, UserEntity> {
    UserEntity findPartnerUserByChatBoxId(Long userId, Long chatBoxId);
}
