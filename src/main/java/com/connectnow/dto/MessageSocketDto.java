package com.connectnow.dto;

import java.math.BigInteger;
import java.util.Date;

public class MessageSocketDto {
    private BigInteger id;
    private String content;
    private String type;
    private Date date;
    private BigInteger memberId;
    private String userProviderId;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigInteger getMemberId() {
        return memberId;
    }

    public void setMemberId(BigInteger memberId) {
        this.memberId = memberId;
    }

    public String getUserProviderId() {
        return userProviderId;
    }

    public void setUserProviderId(String userProviderId) {
        this.userProviderId = userProviderId;
    }
}
