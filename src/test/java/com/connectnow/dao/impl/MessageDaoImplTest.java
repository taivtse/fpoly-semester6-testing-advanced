package com.connectnow.dao.impl;

import com.connectnow.config.SpringWebConfig;
import com.connectnow.constant.SystemConstant;
import com.connectnow.dao.MessageDao;
import com.connectnow.entity.MessageEntity;
import com.connectnow.paging.PageRequest;
import com.connectnow.paging.Pageable;
import com.connectnow.paging.Sorter;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import static org.testng.Assert.*;

@WebAppConfiguration
@ContextConfiguration(classes = {SpringWebConfig.class})
public class MessageDaoImplTest {
    @Autowired
    private MessageDao messageDao;

    @Test
    public void findAllByChatBoxIdTest() {
        Sorter sorter = new Sorter("id", SystemConstant.SORT_DESC);
        Pageable pageable = new PageRequest(1, 2, sorter);
        List<MessageEntity> messageEntityList = messageDao.findAllByChatBoxId(pageable, BigInteger.valueOf(1));

        assertEquals(messageEntityList.size(), 2);
        assertEquals(messageEntityList.get(0).getId(), BigInteger.valueOf(171));
    }
}