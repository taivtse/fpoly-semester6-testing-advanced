package com.connectnow.dao.impl;

import com.connectnow.config.SpringWebConfig;
import com.connectnow.constant.SystemConstant;
import com.connectnow.dao.MessageDao;
import com.connectnow.entity.MessageEntity;
import com.connectnow.paging.PageRequest;
import com.connectnow.paging.Pageable;
import com.connectnow.paging.Sorter;
import org.hibernate.QueryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

@WebAppConfiguration
@ContextConfiguration(classes = {SpringWebConfig.class})
public class MessageDaoImplTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private MessageDao messageDao;

    @Test
    public void findAllByChatBoxIdTest() {
        Sorter sorter = new Sorter("id", SystemConstant.SORT_ASC);
        Pageable pageable = new PageRequest(1, 2, sorter);
        List<MessageEntity> messageEntityList = messageDao.findAllByChatBoxId(pageable, 1L);

        assertEquals(messageEntityList.size(), 2);
        assertEquals(messageEntityList.get(0).getId(), Long.valueOf(1));
    }

    @Test(expectedExceptions = QueryException.class)
    public void findAllByChatBoxId_exceptionTest() {
        Sorter sorter = new Sorter("abcxyz", SystemConstant.SORT_DESC);
        Pageable pageable = new PageRequest(1, 2, sorter);
        messageDao.findAllByChatBoxId(pageable, 1L);
    }
}