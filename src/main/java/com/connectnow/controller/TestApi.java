package com.connectnow.controller;

import com.connectnow.dao.MessageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class TestApi {
    @Autowired
    private MessageDao messageDao;

    @GetMapping("/test")
    public void test(){
        try {
            messageDao.deleteById(BigInteger.valueOf(5));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
