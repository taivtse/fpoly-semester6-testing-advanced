package com.connectnow.service.impl;

import com.connectnow.constant.SystemConstant;
import com.connectnow.converter.GenericConverter;
import com.connectnow.converter.SearchUserConverter;
import com.connectnow.converter.UserConverter;
import com.connectnow.dao.GenericDao;
import com.connectnow.dao.UserDao;
import com.connectnow.dto.SearchUserDto;
import com.connectnow.dto.UserDto;
import com.connectnow.entity.UserEntity;
import com.connectnow.paging.PageRequest;
import com.connectnow.paging.Pageable;
import com.connectnow.service.UserService;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl extends AbstractService<BigInteger, UserDto, UserEntity> implements UserService {

    private final UserDao userDao;
    private final SearchUserConverter searchUserConverter;

    @Autowired
    public UserServiceImpl(@Qualifier("userDaoImpl") GenericDao genericDao,
                           @Qualifier("userConverter") GenericConverter genericConverter, SearchUserConverter searchUserConverter) {
        super(genericDao, genericConverter);

        this.userDao = (UserDao) genericDao;
        this.searchUserConverter = searchUserConverter;
    }

    @Override
    public UserDto findOneByProviderAndProviderId(String provider, String providerId) {
        List<Criterion> criterionList = new ArrayList<>();
        criterionList.add(Restrictions.eq("provider", provider));
        criterionList.add(Restrictions.eq("providerId", providerId));
        return this.findOneByProperties(criterionList);
    }

    @Override
    public List<SearchUserDto> findSearchUserByName(String name) {
        Criterion criterion = Restrictions.like("name", name, MatchMode.ANYWHERE);
        Pageable pageable = new PageRequest(1, SystemConstant.MAX_SERCHUSER_PER_PAGE, null);
        List<UserEntity> userEntityList = this.userDao.findAllByProperties(pageable, Collections.singletonList(criterion));
        return this.searchUserConverter.entityListToDtoList(userEntityList);
    }
}
