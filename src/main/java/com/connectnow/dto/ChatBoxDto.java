package com.connectnow.dto;

import java.math.BigInteger;
import java.util.Date;

public class ChatBoxDto {
    private BigInteger id;
    private BigInteger lastMessageId;
    private Date lastMessageDate;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getLastMessageId() {
        return lastMessageId;
    }

    public void setLastMessageId(BigInteger lastMessageId) {
        this.lastMessageId = lastMessageId;
    }

    public Date getLastMessageDate() {
        return lastMessageDate;
    }

    public void setLastMessageDate(Date lastMessageDate) {
        this.lastMessageDate = lastMessageDate;
    }
}
