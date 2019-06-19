package com.connectnow.dao;

import com.connectnow.entity.MessageEntity;
import com.connectnow.paging.Pageable;

import java.math.BigInteger;
import java.util.List;

public interface MessageDao extends GenericDao<Long, MessageEntity> {
    List<MessageEntity> findAllByChatBoxId(Pageable pageable, Long chatBoxId);
}
