package com.connectnow.dto;

import com.connectnow.entity.MemberEntity;
import com.connectnow.entity.MessageEntity;

import java.math.BigInteger;
import java.util.Date;

public class MessageDto {
    private BigInteger id;
    private String content;
    private Date date;
    private MessageEntity.Type type;
    private MemberEntity memberEntity;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public MessageEntity.Type getType() {
        return type;
    }

    public void setType(MessageEntity.Type type) {
        this.type = type;
    }

    public MemberEntity getMemberEntity() {
        return memberEntity;
    }

    public void setMemberEntity(MemberEntity memberEntity) {
        this.memberEntity = memberEntity;
    }
}
