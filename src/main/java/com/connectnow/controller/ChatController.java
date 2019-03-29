package com.connectnow.controller;

import com.connectnow.dao.ChatBoxDao;
import com.connectnow.dao.MemberDao;
import com.connectnow.dao.MessageDao;
import com.connectnow.dao.UserDao;
import com.connectnow.dto.Greeting;
import com.connectnow.dto.HelloMessage;
import com.connectnow.entity.ChatBoxEntity;
import com.connectnow.entity.MemberEntity;
import com.connectnow.entity.MessageEntity;
import com.connectnow.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Controller
@Transactional
public class ChatController {

    private final ChatBoxDao chatBoxDao;
    private final MemberDao memberDao;
    private final MessageDao messageDao;
    private final UserDao userDao;

    @Autowired
    public ChatController(ChatBoxDao chatBoxDao, MemberDao memberDao, MessageDao messageDao, UserDao userDao) {
        this.chatBoxDao = chatBoxDao;
        this.memberDao = memberDao;
        this.messageDao = messageDao;
        this.userDao = userDao;
    }

    @RequestMapping(value = "/")
    public String home() {
//        ChatBoxEntity chatBoxEntity = new ChatBoxEntity();
//        chatBoxEntity.setName("name");
//        chatBoxEntity.setLastMessageId(BigInteger.valueOf(1));
//        chatBoxEntity.setLastMessageDate(new Date());
        List<UserEntity> userEntityList = userDao.findAll();
        List<ChatBoxEntity> chatBoxEntityList = chatBoxDao.findAll();
        List<MemberEntity> memberEntityList = memberDao.findAll();
        List<MessageEntity> messageEntityList = messageDao.findAll();
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
