package com.connectnow.service.impl;

import com.connectnow.converter.ChatBoxConverter;
import com.connectnow.converter.GenericConverter;
import com.connectnow.converter.MessageConverter;
import com.connectnow.dao.ChatBoxDao;
import com.connectnow.dao.GenericDao;
import com.connectnow.dao.MessageDao;
import com.connectnow.dto.MessageDto;
import com.connectnow.entity.MessageEntity;
import com.connectnow.service.MessageBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class MessageServiceImpl extends AbstractService<BigInteger, MessageDto, MessageEntity> implements MessageBoxService {

    private MessageDao messageDao;
    private MessageConverter messageConverter;

    @Autowired
    public MessageServiceImpl(@Qualifier("messageDaoImpl") GenericDao genericDao,
                              @Qualifier("messageConverter") GenericConverter genericConverter) {
        super(genericDao, genericConverter);

        this.messageDao = (MessageDao) genericDao;
        this.messageConverter = (MessageConverter) genericConverter;
    }
}
