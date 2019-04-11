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
}
