package com.connectnow.converter;

import com.connectnow.dto.UserDto;
import com.connectnow.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends AbstractConverter<UserDto, UserEntity> {
}
