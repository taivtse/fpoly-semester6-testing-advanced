package com.connectnow.service.impl;

import com.connectnow.converter.GenericConverter;
import com.connectnow.dao.GenericDao;
import com.connectnow.dao.MemberDao;
import com.connectnow.dao.MessageDao;
import com.connectnow.dto.MessageDto;
import com.connectnow.entity.MemberEntity;
import com.connectnow.entity.MessageEntity;
import com.connectnow.paging.Pageable;
import com.connectnow.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl extends AbstractServiceImpl<Long, MessageDto, MessageEntity> implements MessageService {

    private final MessageDao messageDao;
    private final MemberDao memberDao;

    @Autowired
    public MessageServiceImpl(@Qualifier("messageDaoImpl") GenericDao genericDao,
                              @Qualifier("messageConverter") GenericConverter genericConverter,
                              MemberDao memberDao) {
        super(genericDao, genericConverter);

        this.messageDao = (MessageDao) genericDao;
        this.memberDao = memberDao;
    }

    @Override
    public List<MessageDto> findAllByChatBoxId(Pageable pageable, Long chatBoxId) {
        List<MessageEntity> messageEntityList = messageDao.findAllByChatBoxId(pageable, chatBoxId);
        List<MessageDto> messageDtoList = new ArrayList<>();
        messageEntityList.forEach(messageEntity -> {
            MessageDto messageDto = converter.entityToDto(messageEntity);
            MemberEntity memberEntity = this.memberDao.findOneById(messageDto.getMemberId());
            messageDto.setUserId(memberEntity.getUser().getId());
            messageDtoList.add(messageDto);
        });
        return messageDtoList;
    }
}
