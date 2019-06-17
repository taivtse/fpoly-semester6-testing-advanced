package com.connectnow.controller;

import com.connectnow.dto.MessageDto;
import com.connectnow.dto.MessageSocketDto;
import com.connectnow.service.ChatBoxService;
import com.connectnow.service.MemberService;
import com.connectnow.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class ChatController {

    private final Logger logger = LoggerFactory.getLogger(ChatController.class);
    private final SimpMessageSendingOperations messagingTemplate;
    private final MessageService messageService;
    private final ChatBoxService chatBoxService;

    @Autowired
    public ChatController(SimpMessageSendingOperations messagingTemplate, MessageService messageService, ChatBoxService chatBoxService) {
        this.messagingTemplate = messagingTemplate;
        this.messageService = messageService;
        this.chatBoxService = chatBoxService;
    }

    @MessageMapping("/chat/send/{receivedUserProviderId}")
    public void sendMessage(@DestinationVariable String receivedUserProviderId,
                            @Payload MessageSocketDto messageSocketDto) {
        MessageDto messageDto = new MessageDto();
        messageDto.setContent(messageSocketDto.getContent());
        messageDto.setDate(new Date());
        messageDto.setType(messageSocketDto.getType());
        messageDto.setMemberId(messageSocketDto.getSentMemberId());

        try {
            messageDto = messageService.save(messageDto);
            chatBoxService.updateLastDataByMessage(messageDto);
            messagingTemplate.convertAndSend(String.format("/channel/%s", receivedUserProviderId), messageSocketDto);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
