package com.connectnow.controller;

import com.connectnow.converter.MessageConverter;
import com.connectnow.dto.MessageDto;
import com.connectnow.entity.MessageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestApi {
    @Autowired
    private MessageConverter messageConverter;

    @PostMapping("/test")
    @ResponseBody
    public void test(@RequestBody MessageDto messageDto){
        MessageEntity entity = messageConverter.dtoToEntity(messageDto);
        System.out.println(messageDto.getContent());
    }
}
