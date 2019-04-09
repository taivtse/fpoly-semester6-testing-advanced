package com.connectnow.service.impl;

import com.connectnow.converter.ChatBoxConverter;
import com.connectnow.converter.GenericConverter;
import com.connectnow.dao.ChatBoxDao;
import com.connectnow.dao.GenericDao;
import com.connectnow.dto.ChatBoxDto;
import com.connectnow.entity.ChatBoxEntity;
import com.connectnow.service.ChatBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class ChatBoxServiceImpl extends AbstractService<BigInteger, ChatBoxDto, ChatBoxEntity> implements ChatBoxService {

    private ChatBoxDao chatBoxDao;
    private ChatBoxConverter chatBoxConverter;

    @Autowired
    public ChatBoxServiceImpl(@Qualifier("chatBoxDaoImpl") GenericDao genericDao,
                              @Qualifier("chatBoxConverter") GenericConverter genericConverter) {
        super(genericDao, genericConverter);

        this.chatBoxDao = (ChatBoxDao) genericDao;
        this.chatBoxConverter = (ChatBoxConverter) genericConverter;
    }
}
