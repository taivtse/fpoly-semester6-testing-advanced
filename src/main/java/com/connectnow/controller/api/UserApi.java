package com.connectnow.controller.api;

import com.connectnow.constant.ApiConstant;
import com.connectnow.dto.SearchUserDto;
import com.connectnow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping(ApiConstant.API_USER_URL)
public class UserApi {
    private final UserService userService;

    @Autowired
    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("search")
    @ResponseBody
    public List<SearchUserDto> searchOtherUser(@RequestParam(name = "name") String name,
                                               @RequestParam(name = "userId") Long userId) {
        return this.userService.findSearchUserByName(name, userId);
    }
}
