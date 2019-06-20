package com.connectnow.service.impl;

import com.connectnow.converter.GenericConverter;
import com.connectnow.dao.*;
import com.connectnow.dto.ChatBoxDto;
import com.connectnow.dto.MessageDto;
import com.connectnow.entity.ChatBoxEntity;
import com.connectnow.entity.MemberEntity;
import com.connectnow.entity.MessageEntity;
import com.connectnow.entity.UserEntity;
import com.connectnow.paging.Pageable;
import com.connectnow.service.ChatBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatBoxServiceImpl extends AbstractServiceImpl<Long, ChatBoxDto, ChatBoxEntity> implements ChatBoxService {

    private final ChatBoxDao chatBoxDao;
    private final UserDao userDao;
    private final MessageDao messageDao;
    private final MemberDao memberDao;

    @Autowired
    public ChatBoxServiceImpl(@Qualifier("chatBoxDaoImpl") GenericDao genericDao,
                              @Qualifier("chatBoxConverter") GenericConverter genericConverter,
                              UserDao userDao,
                              MessageDao messageDao,
                              MemberDao memberDao) {
        super(genericDao, genericConverter);

        this.chatBoxDao = (ChatBoxDao) genericDao;
        this.userDao = userDao;
        this.messageDao = messageDao;
        this.memberDao = memberDao;
    }

    @Override
    public List<ChatBoxDto> finAllByUserId(Pageable pageable, Long userId) {
        List<ChatBoxEntity> chatBoxEntityList = chatBoxDao.findAllByUserId(pageable, userId);
        List<ChatBoxDto> chatBoxDtoList = new ArrayList<>();

        chatBoxEntityList.forEach(chatBoxEntity -> {
            ChatBoxDto chatBoxDto = this.fetchDataToChatBoxDto(chatBoxEntity, userId);
            chatBoxDtoList.add(chatBoxDto);
        });
        return chatBoxDtoList;
    }

    @Override
    public ChatBoxDto findOneByMemberId(Long memberId, Long userId) {
        ChatBoxEntity chatBoxEntity = this.chatBoxDao.findOneByMemberId(memberId);
        return this.fetchDataToChatBoxDto(chatBoxEntity, userId);
    }

    @Override
    public ChatBoxDto updateLastDataByMessage(MessageDto messageDto) throws Exception {
        ChatBoxEntity chatBoxEntity = chatBoxDao.findOneByMemberId(messageDto.getMemberId());
        chatBoxEntity.setLastMessageId(messageDto.getId());
        chatBoxEntity.setLastMessageDate(messageDto.getDate());

        chatBoxDao.update(chatBoxEntity);
        return this.converter.entityToDto(chatBoxEntity);
    }

    private ChatBoxDto fetchDataToChatBoxDto(ChatBoxEntity chatBoxEntity, Long userId) {
        ChatBoxDto chatBoxDto = this.converter.entityToDto(chatBoxEntity);

//            get and set chat box name and chat box image
        UserEntity partnerUser = userDao.findPartnerUserByChatBoxId(userId, chatBoxEntity.getId());
        chatBoxDto.setName(partnerUser.getName());
        chatBoxDto.setPhotoUrl(partnerUser.getPhotoUrl());
        chatBoxDto.setChatBoxParam(partnerUser.getProviderId());
        chatBoxDto.setPartnerUserId(partnerUser.getId());

//            get and set last message content and date
        MessageEntity lastMessage = messageDao.findOneById(chatBoxEntity.getLastMessageId());
        chatBoxDto.setLastMessageContent(lastMessage.getContent());
        chatBoxDto.setLastMessageDate(lastMessage.getDate());
        if (lastMessage.getMember().getUser().getId().equals(userId)) {
            chatBoxDto.setLastMessageContent("You: " + chatBoxDto.getLastMessageContent());
        }

//            get read status, member id
        MemberEntity memberEntity = memberDao.findOneByChatBoxIdAndUserId(chatBoxEntity.getId(), userId);
        chatBoxDto.setReadStatus(memberEntity.getReadStatus());
        chatBoxDto.setMemberId(memberEntity.getId());

        return chatBoxDto;
    }
}
