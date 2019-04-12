package com.connectnow.dao;

import com.connectnow.entity.ChatBoxEntity;
import com.connectnow.paging.Pageable;

import java.math.BigInteger;
import java.util.List;

public interface ChatBoxDao extends GenericDao<BigInteger, ChatBoxEntity> {
    List<ChatBoxEntity> findAllByUserId(Pageable pageable, BigInteger userId);
}
