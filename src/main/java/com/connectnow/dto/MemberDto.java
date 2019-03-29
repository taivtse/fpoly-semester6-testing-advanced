package com.connectnow.dto;

import com.connectnow.entity.ChatBoxEntity;
import com.connectnow.entity.UserEntity;

import java.math.BigInteger;

public class MemberDto {
    private BigInteger id;
    private ChatBoxEntity chatBoxEntity;
    private UserEntity userEntity;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public ChatBoxEntity getChatBoxEntity() {
        return chatBoxEntity;
    }

    public void setChatBoxEntity(ChatBoxEntity chatBoxEntity) {
        this.chatBoxEntity = chatBoxEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
