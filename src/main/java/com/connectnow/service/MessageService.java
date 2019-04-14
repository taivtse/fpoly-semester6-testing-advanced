package com.connectnow.service;

import com.connectnow.dto.MessageDto;
import com.connectnow.paging.Pageable;

import java.math.BigInteger;
import java.util.List;

public interface MessageService extends GenericService<BigInteger, MessageDto> {
    List<MessageDto> findAllByChatBoxId(Pageable pageable, BigInteger chatBoxId);
}
