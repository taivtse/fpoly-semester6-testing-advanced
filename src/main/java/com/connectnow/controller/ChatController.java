package com.connectnow.controller;

import com.connectnow.dao.UserDao;
import com.connectnow.dto.Greeting;
import com.connectnow.dto.HelloMessage;
import com.connectnow.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@Controller
@Transactional
public class ChatController {

    private final UserDao userDao;

    @Autowired
    public ChatController(UserDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping(value = "/")
    public String home() {
        List<UserEntity> a = userDao.findAll();
        return "home";
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) {
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    @MessageMapping("/xinchao")
    @SendTo("/topic/chatchit")
    public Greeting chatchit(HelloMessage message) {
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
}
