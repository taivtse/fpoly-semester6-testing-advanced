package com.connectnow.dto;

import java.math.BigInteger;
import java.util.Date;

public class MessageDto {
    private BigInteger id;
    private String content;
    private Date date;
    private MessageType type;
    private MemberDto member;

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

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public MemberDto getMember() {
        return member;
    }

    public void setMember(MemberDto member) {
        this.member = member;
    }
}
