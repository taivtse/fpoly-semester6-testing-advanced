package com.connectnow.dao.impl;

import com.connectnow.dao.MessageDao;
import com.connectnow.entity.MessageEntity;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public class MessageDaoImpl extends AbstractDaoImpl<BigInteger, MessageEntity> implements MessageDao {
}
