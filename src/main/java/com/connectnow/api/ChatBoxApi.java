package com.connectnow.api;

import com.connectnow.constant.ApiConstant;
import com.connectnow.dto.ChatBoxDto;
import com.connectnow.service.ChatBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping(ApiConstant.API_CHATBOX_URL)
public class ChatBoxApi {

    private final ChatBoxService chatBoxService;

    @Autowired
    public ChatBoxApi(ChatBoxService chatBoxService) {
        this.chatBoxService = chatBoxService;
    }

    @GetMapping
    @ResponseBody
    public List<ChatBoxDto> getList(@RequestParam(name = "userId") BigInteger userId) {
        return chatBoxService.finAllByUserId(null, userId);
    }

//    @GetMapping("user/:userId/page/:page")
//    @ResponseBody
//    public List<ChatBoxDto> getPagingList(@PathVariable(name = "page") Integer page,
//                                          @PathVariable(name = "userId") BigInteger userId) {
//        Pageable pageable = new PageRequest(page, SystemConstant.MAX_CHATBOX_PER_PAGE, null);
//        return chatBoxService.finAllByUserId(pageable, userId);
//    }
}
