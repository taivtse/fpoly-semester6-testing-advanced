package com.connectnow.dto;

import java.math.BigInteger;
import java.util.Date;

public class ChatBoxDto {
    private BigInteger id;
    private String name;
    private String photoUrl;
    private String lastMessageContent;
    private Date lastMessageDate;
    private String chatBoxParam;
    private boolean readStatus;
    private BigInteger memberId;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getLastMessageContent() {
        return lastMessageContent;
    }

    public void setLastMessageContent(String lastMessageContent) {
        this.lastMessageContent = lastMessageContent;
    }

    public Date getLastMessageDate() {
        return lastMessageDate;
    }

    public void setLastMessageDate(Date lastMessageDate) {
        this.lastMessageDate = lastMessageDate;
    }

    public String getChatBoxParam() {
        return chatBoxParam;
    }

    public void setChatBoxParam(String chatBoxParam) {
        this.chatBoxParam = chatBoxParam;
    }

    public boolean getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(boolean readStatus) {
        this.readStatus = readStatus;
    }

    public BigInteger getMemberId() {
        return memberId;
    }

    public void setMemberId(BigInteger memberId) {
        this.memberId = memberId;
    }
}
