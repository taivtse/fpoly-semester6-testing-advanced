package com.connectnow.dao.impl;

import com.connectnow.dao.UserDao;
import com.connectnow.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<BigInteger, UserEntity> implements UserDao {
}
