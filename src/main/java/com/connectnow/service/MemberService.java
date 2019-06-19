package com.connectnow.service;

import com.connectnow.dto.MemberDto;

import java.math.BigInteger;

public interface MemberService extends GenericService<Long, MemberDto> {
    MemberDto updateReadStatusByChatBoxIdAndUserId(Long chatBoxId, Long userId, boolean readStatus) throws Exception;

    MemberDto updateReadStatusByMemberId(Long memberId, boolean readStatus) throws Exception;
}
