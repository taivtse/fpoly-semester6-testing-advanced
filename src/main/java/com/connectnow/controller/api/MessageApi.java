package com.connectnow.controller.api;

import com.connectnow.constant.ApiConstant;
import com.connectnow.dto.MessageDto;
import com.connectnow.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping(ApiConstant.API_MESSAGE_URL)
public class MessageApi {

    private final MessageService messageService;

    @Autowired
    public MessageApi(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    @ResponseBody
    public List<MessageDto> getList(@RequestParam(name = "chatBoxId") Long chatBoxId) {
        return messageService.findAllByChatBoxId(null, chatBoxId);
    }
}
