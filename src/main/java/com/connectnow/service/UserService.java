package com.connectnow.service;

import com.connectnow.dto.SearchUserDto;
import com.connectnow.dto.UserDto;

import java.math.BigInteger;
import java.util.List;

public interface UserService extends GenericService<BigInteger, UserDto> {
    UserDto findOneByProviderAndProviderId(String provider, String providerId);

    List<SearchUserDto> findSearchUserByName(String name, BigInteger userId);
}
