package com.connectnow.service;

import com.connectnow.dto.ChatBoxDto;
import com.connectnow.dto.MessageDto;
import com.connectnow.paging.Pageable;

import java.util.List;

public interface ChatBoxService extends GenericService<Long, ChatBoxDto> {
    List<ChatBoxDto> findAllByUserId(Pageable pageable, Long userId);

    ChatBoxDto findOneByMemberId(Long memberId, Long userId);

    ChatBoxDto updateLastDataByMessage(MessageDto messageDto) throws Exception;
}
