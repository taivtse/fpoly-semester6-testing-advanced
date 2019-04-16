package com.connectnow.controller;

import com.connectnow.dto.MessageSocketDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

    private final SimpMessageSendingOperations messagingTemplate;

    @Autowired
    public ChatController(SimpMessageSendingOperations messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/chat/send/{receivedUserProviderId}")
    public void sendMessage(@DestinationVariable String receivedUserProviderId,
                            @Payload MessageSocketDto messageSocketDto,
                            SimpMessageHeaderAccessor headerAccessor) {
        messagingTemplate.convertAndSend(String.format("/channel/%s", receivedUserProviderId), messageSocketDto);
    }
}
