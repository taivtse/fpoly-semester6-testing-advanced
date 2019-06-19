package com.connectnow.dao;

import com.connectnow.entity.ChatBoxEntity;
import com.connectnow.entity.MessageEntity;
import com.connectnow.paging.Pageable;

import java.math.BigInteger;
import java.util.List;

public interface ChatBoxDao extends GenericDao<Long, ChatBoxEntity> {
    List<ChatBoxEntity> findAllByUserId(Pageable pageable, Long userId);

    ChatBoxEntity findOneByMemberId(Long memberId);
}
