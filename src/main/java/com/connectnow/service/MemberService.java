package com.connectnow.service;

import com.connectnow.dto.MemberDto;

import java.math.BigInteger;

public interface MemberService extends GenericService<BigInteger, MemberDto> {
    MemberDto updateReadStatusByChatBoxIdAndUserId(BigInteger chatBoxId, BigInteger userId, boolean readStatus) throws Exception;

    MemberDto updateReadStatusByMemberId(BigInteger memberId, boolean readStatus) throws Exception;
}
