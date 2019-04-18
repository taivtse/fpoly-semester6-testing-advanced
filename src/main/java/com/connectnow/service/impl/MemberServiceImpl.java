package com.connectnow.service.impl;

import com.connectnow.converter.GenericConverter;
import com.connectnow.converter.MemberConverter;
import com.connectnow.dao.GenericDao;
import com.connectnow.dao.MemberDao;
import com.connectnow.dto.MemberDto;
import com.connectnow.entity.MemberEntity;
import com.connectnow.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class MemberServiceImpl extends AbstractService<BigInteger, MemberDto, MemberEntity> implements MemberService {

    private final MemberDao memberDao;

    @Autowired
    public MemberServiceImpl(@Qualifier("memberDaoImpl") GenericDao genericDao,
                             @Qualifier("memberConverter") GenericConverter genericConverter) {
        super(genericDao, genericConverter);

        this.memberDao = (MemberDao) genericDao;
    }

    @Override
    public MemberDto updateReadStatusByChatBoxIdAndUserId(BigInteger chatBoxId, BigInteger userId, boolean readStatus) throws Exception {
        MemberEntity memberEntity = memberDao.findOneByChatBoxIdAndUserId(chatBoxId, userId);
        if (memberEntity.getReadStatus() != readStatus) {
            memberEntity.setReadStatus(readStatus);
            memberDao.update(memberEntity);
        }
        return this.converter.entityToDto(memberEntity);
    }

    @Override
    public MemberDto updateReadStatusByMemberId(BigInteger memberId, boolean readStatus) throws Exception {
        MemberEntity memberEntity = memberDao.findOneById(memberId);
        if (memberEntity.getReadStatus() != readStatus) {
            memberEntity.setReadStatus(readStatus);
            memberDao.update(memberEntity);
        }
        return this.converter.entityToDto(memberEntity);
    }
}
