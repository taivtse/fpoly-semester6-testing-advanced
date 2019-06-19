package com.connectnow.dao.impl;

import com.connectnow.config.SpringWebConfig;
import com.connectnow.dao.ChatBoxDao;
import com.connectnow.dao.MemberDao;
import com.connectnow.entity.MemberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import java.math.BigInteger;

import static org.testng.Assert.*;

@WebAppConfiguration
@ContextConfiguration(classes = {SpringWebConfig.class})
public class MemberDaoImplTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private MemberDao memberDao;

    @Test
    public void findOneByChatBoxIdAndUserIdTest() {
        MemberEntity memberEntity = memberDao.findOneByChatBoxIdAndUserId(BigInteger.valueOf(4), BigInteger.valueOf(6));
        assertNotNull(memberEntity);
        assertEquals(memberEntity.getId(), BigInteger.valueOf(5));
    }
}