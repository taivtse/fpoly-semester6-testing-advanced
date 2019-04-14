package com.connectnow.converter;

import com.connectnow.dto.SearchUserDto;
import com.connectnow.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class SearchUserConverter extends AbstractConverter<SearchUserDto, UserEntity> {
}
