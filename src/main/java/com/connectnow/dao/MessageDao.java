package com.connectnow.dao;

import com.connectnow.entity.MessageEntity;
import com.connectnow.paging.Pageable;

import java.math.BigInteger;
import java.util.List;

public interface MessageDao extends GenericDao<BigInteger, MessageEntity> {
    List<MessageEntity> findAllByChatBoxId(Pageable pageable, BigInteger chatBoxId);
}
