package com.connectnow.service;

import com.connectnow.dto.UserDto;

import java.math.BigInteger;

public interface UserService extends GenericService<BigInteger, UserDto>{
    UserDto findOneByProviderAndProviderId(String provider, String providerId);
}
