package com.connectnow.service;

import com.connectnow.dto.ChatBoxDto;
import com.connectnow.dto.MessageDto;
import com.connectnow.paging.Pageable;

import java.math.BigInteger;
import java.util.List;

public interface ChatBoxService extends GenericService<BigInteger, ChatBoxDto> {
    List<ChatBoxDto> finAllByUserId(Pageable pageable, BigInteger userId);

    ChatBoxDto findOneByMemberId(BigInteger memberId, BigInteger userId);

    ChatBoxDto updateLastDataByMessage(MessageDto messageDto) throws Exception;
}
