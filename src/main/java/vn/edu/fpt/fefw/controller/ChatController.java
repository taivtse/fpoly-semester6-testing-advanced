package vn.edu.fpt.fefw.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;
import vn.edu.fpt.fefw.dto.Greeting;
import vn.edu.fpt.fefw.dto.HelloMessage;

@Controller
public class ChatController {

    @RequestMapping(value = "/")
    public String home() {
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
