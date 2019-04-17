package com.connectnow.controller.api;

import com.connectnow.constant.ApiConstant;
import com.connectnow.dto.UserDto;
import com.connectnow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiConstant.API_LOGIN_URL)
public class LoginApi {

    private final UserService userService;

    @Autowired
    public LoginApi(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @PostMapping
    public UserDto login(@RequestBody UserDto userDto) throws Exception {
        UserDto savedUserDto = userService.findOneByProviderAndProviderId(userDto.getProvider(), userDto.getProviderId());

        if (savedUserDto == null) {
            userDto = userService.save(userDto);
        } else {
            userDto.setId(savedUserDto.getId());
            userDto = userService.update(userDto);
        }
        return userDto;
    }

    @ResponseBody
    @PostMapping("/auth")
    public Boolean auth(@RequestBody UserDto userDto) {
        if (userDto.getId() != null && userDto.getToken() != null
                && userDto.getProvider() != null && userDto.getProviderId() != null) {
            UserDto savedUserDto = userService.findOneById(userDto.getId());

            return savedUserDto.getId().equals(userDto.getId())
                    && savedUserDto.getToken().equals(userDto.getToken())
                    && savedUserDto.getProvider().equals(userDto.getProvider())
                    && savedUserDto.getProviderId().equals(userDto.getProviderId());
        }

        return false;
    }
}
