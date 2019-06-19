package com.connectnow.dao.impl;

import com.connectnow.config.SpringWebConfig;
import com.connectnow.constant.SystemConstant;
import com.connectnow.dao.ChatBoxDao;
import com.connectnow.entity.ChatBoxEntity;
import com.connectnow.paging.PageRequest;
import com.connectnow.paging.Pageable;
import com.connectnow.paging.Sorter;
import org.hibernate.QueryException;
import org.hibernate.StaleStateException;
import org.hibernate.TransientObjectException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@WebAppConfiguration
@ContextConfiguration(classes = {SpringWebConfig.class})
public class AbstractDaoImplTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private ChatBoxDao chatBoxDao;
    private Long lastSaveId;

    @Test(priority = 0)
    public void findAllTest() {
        List<ChatBoxEntity> chatBoxEntityList = chatBoxDao.findAll(null);
        int actualSize = chatBoxEntityList.size();
        int expectedSize = 3;

        assertEquals(actualSize, expectedSize);
    }

    @Test(priority = 1)
    public void findAll_pageableTest() {
        Sorter sorter = new Sorter("id", SystemConstant.SORT_DESC);
        Pageable pageable = new PageRequest(1, 2, sorter);
        List<ChatBoxEntity> chatBoxEntityList = chatBoxDao.findAll(pageable);

        int actualSize = chatBoxEntityList.size();
        int expectedSize = 2;
        assertEquals(actualSize, expectedSize);
        assertEquals(chatBoxEntityList.get(0).getId(), Long.valueOf(4));
    }

    @Test(priority = 2)
    public void findOneByIdTest() {
        ChatBoxEntity chatBoxEntity = chatBoxDao.findOneById(2L);

        assertNotNull(chatBoxEntity);
        assertEquals(chatBoxEntity.getId(), Long.valueOf(2));
        assertEquals(chatBoxEntity.getLastMessageId(), Long.valueOf(6));
    }

    @Test(priority = 3)
    public void findAllByPropertiesTest() {
        List<Criterion> criterionList = new ArrayList<>();
        criterionList.add(Restrictions.gt("lastMessageId", 10L));
        List<ChatBoxEntity> chatBoxEntityList = chatBoxDao.findAllByProperties(null, criterionList);

        int actualSize = chatBoxEntityList.size();
        int expectedSize = 1;
        assertEquals(actualSize, expectedSize);
    }

    @Test(priority = 4, expectedExceptions = QueryException.class)
    public void findAllByProperties_exceptionTest() {
        List<Criterion> criterionList = new ArrayList<>();
        criterionList.add(Restrictions.gt("abcxyz", 10L));
        chatBoxDao.findAllByProperties(null, criterionList);
    }

    @Test(priority = 5)
    public void findOneByPropertiesTest() {
        List<Criterion> criterionList = new ArrayList<>();
        criterionList.add(Restrictions.eq("lastMessageId", 171L));
        ChatBoxEntity chatBoxEntity = chatBoxDao.findOneByProperties(criterionList);

        assertNotNull(chatBoxEntity);
        assertEquals(chatBoxEntity.getLastMessageId(), Long.valueOf(171));
    }

    @Test(priority = 6, expectedExceptions = QueryException.class)
    public void findOneByProperties_exceptionTest() {
        List<Criterion> criterionList = new ArrayList<>();
        criterionList.add(Restrictions.eq("abcxyz", 171L));
        chatBoxDao.findOneByProperties(criterionList);
    }

    @Test(priority = 7)
    public void saveTest() throws Exception {
        ChatBoxEntity chatBoxEntity = new ChatBoxEntity();
        chatBoxEntity.setLastMessageId(101L);

        chatBoxDao.save(chatBoxEntity);

        lastSaveId = chatBoxEntity.getId();
        assertNotNull(lastSaveId);
        assertEquals(chatBoxEntity.getLastMessageId(), Long.valueOf(101));
    }

    @Test(priority = 8, expectedExceptions = IllegalArgumentException.class)
    public void save_exceptionTest() throws Exception {
        chatBoxDao.save(null);
    }

    @Test(priority = 9)
    public void updateTest() throws Exception {
        ChatBoxEntity chatBoxEntity = chatBoxDao.findOneById(lastSaveId);
        chatBoxEntity.setLastMessageId(103L);

        chatBoxDao.update(chatBoxEntity);
        assertEquals(chatBoxEntity.getLastMessageId(), Long.valueOf(103));
    }

    @Test(priority = 10, expectedExceptions = IllegalArgumentException.class)
    public void update_exceptionTest() throws Exception {
        chatBoxDao.update(null);
    }

    @Test(priority = 11, expectedExceptions = TransientObjectException.class)
    public void update_exception1Test() throws Exception {
        ChatBoxEntity chatBoxEntity = new ChatBoxEntity();
        chatBoxDao.update(chatBoxEntity);
    }

    @Test(priority = 12)
    public void deleteTest() throws Exception {
        ChatBoxEntity chatBoxEntity = chatBoxDao.findOneById(lastSaveId);
        chatBoxDao.delete(chatBoxEntity);
    }

    @Test(priority = 13, expectedExceptions = IllegalArgumentException.class)
    public void delete_exceptionTest() throws Exception {
        chatBoxDao.delete(null);
    }

    @Test(priority = 14, expectedExceptions = StaleStateException.class)
    public void delete_exception1Test() throws Exception {
        ChatBoxEntity chatBoxEntity = new ChatBoxEntity();
        chatBoxEntity.setId(100L);
        chatBoxDao.delete(chatBoxEntity);
    }
}