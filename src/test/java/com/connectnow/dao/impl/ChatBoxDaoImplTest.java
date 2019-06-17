package com.connectnow.dao.impl;

import com.connectnow.config.SpringWebConfig;
import com.connectnow.dao.ChatBoxDao;
import com.connectnow.dao.GenericDaoTest;
import com.connectnow.entity.ChatBoxEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigInteger;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SpringWebConfig.class})
@WebAppConfiguration
public class ChatBoxDaoImplTest implements GenericDaoTest {
    @Autowired
    private ChatBoxDao chatBoxDao;

    private int totalSize = 0;
    private int originSize = 3;

    @Test
    @Override
    public void findAllTest() {
        List<ChatBoxEntity> departEntityList = chatBoxDao.findAll(null);
        totalSize = departEntityList.size();

        assertEquals(originSize, totalSize);
        System.out.println("findAllTest");
    }

    @Test
    @Override
    public void findOneByIdTest() {
        ChatBoxEntity chatBoxEntity = chatBoxDao.findOneById(BigInteger.valueOf(2));
        BigInteger lastMessageDateExpected = BigInteger.valueOf(6);
        BigInteger lastMessageDateActual = chatBoxEntity.getLastMessageId();

        assertEquals(lastMessageDateExpected, lastMessageDateActual);
        System.out.println("findOneByIdTest");
    }

    @Test
    @Override
    public void findAllByPropertiesTest() {
        System.out.println("findAllByPropertiesTest");
    }

    @Test
    @Override
    public void countByPropertiesTest() {
        System.out.println("countByPropertiesTest");
    }

    @Test
    @Override
    public void findOneByPropertiesTest() {
        System.out.println("findOneByPropertiesTest");
    }

    @Test
    @Override
    public void saveTest() {

    }

    @Test
    @Override
    public void updateTest() {

    }

    @Test
    @Override
    public void deleteTest() {

    }

    @Test
    @Override
    public void deleteByIdTest() {

    }
}