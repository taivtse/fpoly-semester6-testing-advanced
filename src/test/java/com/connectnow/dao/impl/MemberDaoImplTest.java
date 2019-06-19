package com.connectnow.dao.impl;

import com.connectnow.config.SpringWebConfig;
import com.connectnow.dao.MemberDao;
import com.connectnow.entity.MemberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

@WebAppConfiguration
@ContextConfiguration(classes = {SpringWebConfig.class})
public class MemberDaoImplTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private MemberDao memberDao;

    @Test
    public void findOneByChatBoxIdAndUserIdTest() {
        MemberEntity memberEntity = memberDao.findOneByChatBoxIdAndUserId(4L, 6L);
        assertNotNull(memberEntity);
        assertEquals(memberEntity.getId(), Long.valueOf(5));
    }
}