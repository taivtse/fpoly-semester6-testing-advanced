package com.connectnow.service;

import com.connectnow.dto.MessageDto;
import com.connectnow.paging.Pageable;

import java.math.BigInteger;
import java.util.List;

public interface MessageService extends GenericService<Long, MessageDto> {
    List<MessageDto> findAllByChatBoxId(Pageable pageable, Long chatBoxId);
}
