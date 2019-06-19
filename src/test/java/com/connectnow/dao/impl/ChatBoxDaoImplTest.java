package com.connectnow.dao.impl;

import com.connectnow.config.SpringWebConfig;
import com.connectnow.constant.SystemConstant;
import com.connectnow.dao.ChatBoxDao;
import com.connectnow.entity.ChatBoxEntity;
import com.connectnow.paging.PageRequest;
import com.connectnow.paging.Pageable;
import com.connectnow.paging.Sorter;
import org.hibernate.QueryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.math.BigInteger;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@WebAppConfiguration
@ContextConfiguration(classes = {SpringWebConfig.class})
public class ChatBoxDaoImplTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private ChatBoxDao chatBoxDao;

    @Test
    public void findAllByUserIdTest() {
        Sorter sorter = new Sorter("id", SystemConstant.SORT_DESC);
        Pageable pageable = new PageRequest(1, 2, sorter);

        List<ChatBoxEntity> chatBoxEntityList = chatBoxDao.findAllByUserId(pageable, BigInteger.valueOf(6));
        assertEquals(chatBoxEntityList.size(), 2);
    }

    @Test(expectedExceptions = QueryException.class)
    public void findAllByUserId_exceptionTest() {
        Sorter sorter = new Sorter("abcxyz", SystemConstant.SORT_DESC);
        Pageable pageable = new PageRequest(1, 2, sorter);

        chatBoxDao.findAllByUserId(pageable, BigInteger.valueOf(6));
    }

    @Test
    public void findOneByMemberIdTest() {
        ChatBoxEntity chatBoxEntity = chatBoxDao.findOneByMemberId(BigInteger.valueOf(5));
        assertNotNull(chatBoxEntity);
    }
}