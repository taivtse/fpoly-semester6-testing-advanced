package com.connectnow.service;

import com.connectnow.dto.ChatBoxDto;
import com.connectnow.paging.Pageable;

import java.math.BigInteger;
import java.util.List;

public interface ChatBoxService extends GenericService<BigInteger, ChatBoxDto> {
    List<ChatBoxDto> finAllByUserId(Pageable pageable, BigInteger userId);
}
