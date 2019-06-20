package com.connectnow.service.impl;

import com.connectnow.config.SpringWebConfig;
import com.connectnow.constant.SystemConstant;
import com.connectnow.dto.ChatBoxDto;
import com.connectnow.paging.PageRequest;
import com.connectnow.paging.Pageable;
import com.connectnow.paging.Sorter;
import com.connectnow.service.ChatBoxService;
import org.hibernate.StaleStateException;
import org.hibernate.TransientObjectException;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@WebAppConfiguration
@ContextConfiguration(classes = {SpringWebConfig.class})
public class AbstractServiceImplTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private ChatBoxService chatBoxService;
    private Long lastSaveId;

    @Test(priority = 0)
    public void findAllTest() {
        List<ChatBoxDto> chatBoxDtoList = chatBoxService.findAll(null);
        int actualSize = chatBoxDtoList.size();
        int expectedSize = 3;

        assertEquals(actualSize, expectedSize);
    }

    @Test(priority = 1)
    public void findAll_pageableTest() {
        Sorter sorter = new Sorter("id", SystemConstant.SORT_DESC);
        Pageable pageable = new PageRequest(1, 2, sorter);
        List<ChatBoxDto> chatBoxDtoList = chatBoxService.findAll(pageable);

        int actualSize = chatBoxDtoList.size();
        int expectedSize = 2;
        assertEquals(actualSize, expectedSize);
        assertEquals(chatBoxDtoList.get(0).getId(), Long.valueOf(4));
    }

    @Test(priority = 2)
    public void findOneByIdTest() {
        ChatBoxDto chatBoxDto = chatBoxService.findOneById(2L);

        assertNotNull(chatBoxDto);
        assertEquals(chatBoxDto.getId(), Long.valueOf(2));
    }

    @Test(priority = 3)
    public void findAllByPropertiesTest() {
        List<Criterion> criterionList = new ArrayList<>();
        criterionList.add(Restrictions.gt("lastMessageId", 10L));
        List<ChatBoxDto> ChatBoxDtoList = chatBoxService.findAllByProperties(null, criterionList);

        int actualSize = ChatBoxDtoList.size();
        int expectedSize = 1;
        assertEquals(actualSize, expectedSize);
    }

    @Test(priority = 4)
    public void findOneByPropertiesTest() {
        List<Criterion> criterionList = new ArrayList<>();
        criterionList.add(Restrictions.eq("lastMessageId", 171L));
        ChatBoxDto chatBoxDto = chatBoxService.findOneByProperties(criterionList);

        assertNotNull(chatBoxDto);
        assertEquals(chatBoxDto.getId(), Long.valueOf(1));
    }

    @Test(priority = 5)
    public void saveTest() throws Exception {
        ChatBoxDto chatBoxDto = new ChatBoxDto();

        chatBoxDto = chatBoxService.save(chatBoxDto);
        lastSaveId = chatBoxDto.getId();

        assertNotNull(lastSaveId);
    }

    @Test(priority = 6)
    public void updateTest() throws Exception {
        ChatBoxDto chatBoxDto = chatBoxService.findOneById(lastSaveId);

        Timestamp lastMessageDate = new Timestamp(new Date().getTime());
        chatBoxDto.setLastMessageDate(lastMessageDate);
        chatBoxDto = chatBoxService.update(chatBoxDto);

        ChatBoxDto updatedChatBoxDto = chatBoxService.findOneById(lastSaveId);

        assertEquals(updatedChatBoxDto.getLastMessageDate(), chatBoxDto.getLastMessageDate());
    }

    @Test(priority = 7, expectedExceptions = IllegalArgumentException.class)
    public void update_exceptionTest() throws Exception {
        chatBoxService.update(null);
    }

    @Test(priority = 8, expectedExceptions = TransientObjectException.class)
    public void update_exception1Test() throws Exception {
        ChatBoxDto chatBoxDto = new ChatBoxDto();
        chatBoxService.update(chatBoxDto);
    }

    @Test(priority = 9)
    public void deleteTest() throws Exception {
        ChatBoxDto chatBoxDto = chatBoxService.findOneById(lastSaveId);
        chatBoxService.delete(chatBoxDto);
    }

    @Test(priority = 10, expectedExceptions = IllegalArgumentException.class)
    public void delete_exceptionTest() throws Exception {
        chatBoxService.delete(null);
    }

    @Test(priority = 11, expectedExceptions = StaleStateException.class)
    public void delete_exception1Test() throws Exception {
        ChatBoxDto ChatBoxDto = new ChatBoxDto();
        ChatBoxDto.setId(100L);
        chatBoxService.delete(ChatBoxDto);
    }
}