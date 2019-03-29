package com.connectnow.dao.impl;

import com.connectnow.dao.ChatBoxDao;
import com.connectnow.entity.ChatBoxEntity;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public class ChatBoxDaoImpl extends AbstractDaoImpl<BigInteger, ChatBoxEntity> implements ChatBoxDao {
}
