package com.connectnow.service.impl;

import com.connectnow.converter.GenericConverter;
import com.connectnow.converter.UserConverter;
import com.connectnow.dao.GenericDao;
import com.connectnow.dao.UserDao;
import com.connectnow.dto.UserDto;
import com.connectnow.entity.UserEntity;
import com.connectnow.service.UserService;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl extends AbstractService<BigInteger, UserDto, UserEntity> implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(@Qualifier("userDaoImpl") GenericDao genericDao,
                           @Qualifier("userConverter") GenericConverter genericConverter) {
        super(genericDao, genericConverter);

        this.userDao = (UserDao) genericDao;
    }

    @Override
    public UserDto findOneByProviderAndProviderId(String provider, String providerId) {
        List<Criterion> criterionList = new ArrayList<>();
        criterionList.add(Restrictions.eq("provider", provider));
        criterionList.add(Restrictions.eq("providerId", providerId));
        return this.findOneByProperties(criterionList);
    }
}
