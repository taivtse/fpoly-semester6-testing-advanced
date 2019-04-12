package com.connectnow.service.impl;

import com.connectnow.converter.GenericConverter;
import com.connectnow.dao.ChatBoxDao;
import com.connectnow.dao.GenericDao;
import com.connectnow.dao.MessageDao;
import com.connectnow.dao.UserDao;
import com.connectnow.dto.ChatBoxDto;
import com.connectnow.entity.ChatBoxEntity;
import com.connectnow.entity.MessageEntity;
import com.connectnow.entity.UserEntity;
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

    private final ChatBoxDao chatBoxDao;
    private final UserDao userDao;
    private final MessageDao messageDao;

    @Autowired
    public ChatBoxServiceImpl(@Qualifier("chatBoxDaoImpl") GenericDao genericDao,
                              @Qualifier("chatBoxConverter") GenericConverter genericConverter,
                              UserDao userDao,
                              MessageDao messageDao) {
        super(genericDao, genericConverter);

        this.chatBoxDao = (ChatBoxDao) genericDao;
        this.userDao = userDao;
        this.messageDao = messageDao;
    }

    @Override
    public List<ChatBoxDto> finAllByUserId(Pageable pageable, BigInteger userId) {
        List<ChatBoxEntity> chatBoxEntityList = chatBoxDao.findAllByUserId(pageable, userId);
        List<ChatBoxDto> chatBoxDtoList = new ArrayList<>();

        chatBoxEntityList.forEach(chatBoxEntity -> {
            ChatBoxDto chatBoxDto = this.converter.entityToDto(chatBoxEntity);

//            get and set chat box name and chat box image
            UserEntity partnerUser = userDao.findPartnerUserByChatBoxId(userId, chatBoxEntity.getId());
            chatBoxDto.setName(partnerUser.getName());
            chatBoxDto.setPhotoUrl(partnerUser.getPhotoUrl());
            chatBoxDto.setChatBoxParam(partnerUser.getProviderId());

//            get and set last message content and date
            MessageEntity lastMessage = messageDao.findOneById(chatBoxEntity.getLastMessageId());
            chatBoxDto.setLastMessageContent(lastMessage.getContent());
            chatBoxDto.setLastMessageDate(lastMessage.getDate());

            chatBoxDtoList.add(chatBoxDto);
        });
        return chatBoxDtoList;
    }
}
