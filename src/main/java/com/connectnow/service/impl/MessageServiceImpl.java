package com.connectnow.service.impl;

import com.connectnow.converter.GenericConverter;
import com.connectnow.dao.GenericDao;
import com.connectnow.dao.MessageDao;
import com.connectnow.dto.MessageDto;
import com.connectnow.entity.MessageEntity;
import com.connectnow.paging.Pageable;
import com.connectnow.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class MessageServiceImpl extends AbstractService<BigInteger, MessageDto, MessageEntity> implements MessageService {

    private MessageDao messageDao;

    @Autowired
    public MessageServiceImpl(@Qualifier("messageDaoImpl") GenericDao genericDao,
                              @Qualifier("messageConverter") GenericConverter genericConverter) {
        super(genericDao, genericConverter);

        this.messageDao = (MessageDao) genericDao;
    }

    @Override
    public List<MessageDto> findAllByChatBoxId(Pageable pageable, BigInteger chatBoxId) {
        List<MessageEntity> messageEntityList = messageDao.findAllByChatBoxId(pageable, chatBoxId);
        return converter.entityListToDtoList(messageEntityList);
    }
}
