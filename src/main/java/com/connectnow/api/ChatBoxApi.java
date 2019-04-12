package com.connectnow.api;

import com.connectnow.constant.ApiConstant;
import com.connectnow.constant.SystemConstant;
import com.connectnow.dao.ChatBoxDao;
import com.connectnow.dto.ChatBoxDto;
import com.connectnow.paging.PageRequest;
import com.connectnow.paging.Pageable;
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
    public List<ChatBoxDto> getList(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                    @RequestParam(name = "userId") BigInteger userId) {
        Pageable pageable = new PageRequest(page, SystemConstant.MAX_CHATBOX_PER_PAGE, null);
        return chatBoxService.finAllByUserId(pageable, userId);
    }
}
