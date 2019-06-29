package com.connectnow.controller.api;

import com.connectnow.constant.ApiConstant;
import com.connectnow.dto.ChatBoxDto;
import com.connectnow.service.ChatBoxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = ApiConstant.API_CHATBOX_URL)
public class ChatBoxApi {

    private final Logger logger = LoggerFactory.getLogger(ChatBoxApi.class);
    private final ChatBoxService chatBoxService;

    @Autowired
    public ChatBoxApi(ChatBoxService chatBoxService) {
        this.chatBoxService = chatBoxService;
    }

    @GetMapping
    @ResponseBody
    public List<ChatBoxDto> getList(@RequestParam(name = "userId") Long userId) {
        return chatBoxService.findAllByUserId(null, userId);
    }

    @GetMapping("find-by/member")
    @ResponseBody
    public ChatBoxDto getByMemberId(@RequestParam(name = "memberId") Long memberId,
                                    @RequestParam(name = "userId") Long userId) {
        return chatBoxService.findOneByMemberId(memberId, userId);
    }

    @PostMapping
    @ResponseBody
    public ChatBoxDto create(@RequestBody ChatBoxDto chatBoxDto) throws Exception {
        return chatBoxService.save(chatBoxDto);
    }
}
