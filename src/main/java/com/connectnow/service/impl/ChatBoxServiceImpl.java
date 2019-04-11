package com.connectnow.service.impl;

import com.connectnow.converter.ChatBoxConverter;
import com.connectnow.converter.GenericConverter;
import com.connectnow.dao.ChatBoxDao;
import com.connectnow.dao.GenericDao;
import com.connectnow.dto.ChatBoxDto;
import com.connectnow.entity.ChatBoxEntity;
import com.connectnow.paging.Pageable;
import com.connectnow.service.ChatBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChatBoxServiceImpl extends AbstractService<BigInteger, ChatBoxDto, ChatBoxEntity> implements ChatBoxService {

    private ChatBoxDao chatBoxDao;

    @Autowired
    public ChatBoxServiceImpl(@Qualifier("chatBoxDaoImpl") GenericDao genericDao,
                              @Qualifier("chatBoxConverter") GenericConverter genericConverter) {
        super(genericDao, genericConverter);

        this.chatBoxDao = (ChatBoxDao) genericDao;
    }

    @Override
    public List<ChatBoxDto> finAllByUserId(Pageable pageable, BigInteger userId) {
        List<ChatBoxEntity> chatBoxEntityList = chatBoxDao.findAllByUserId(pageable, userId);
        List<ChatBoxDto> chatBoxDtoList = new ArrayList<>();

        chatBoxEntityList.forEach(chatBoxEntity -> {
            ChatBoxDto chatBoxDto = this.converter.entityToDto(chatBoxEntity);
            chatBoxDtoList.add(chatBoxDto);
        });
        return chatBoxDtoList;
    }
}
