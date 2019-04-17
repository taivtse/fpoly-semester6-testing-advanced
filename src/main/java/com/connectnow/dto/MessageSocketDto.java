package com.connectnow.dto;

import java.math.BigInteger;
import java.util.Date;

public class MessageSocketDto {
    private BigInteger id;
    private String content;
    private MessageType type;
    private Date date;
    private BigInteger sentMemberId;
    private String sentUserProviderId;
    private BigInteger receivedMemberId;
    private String receivedUserProviderId;

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

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigInteger getSentMemberId() {
        return sentMemberId;
    }

    public void setSentMemberId(BigInteger sentMemberId) {
        this.sentMemberId = sentMemberId;
    }

    public String getSentUserProviderId() {
        return sentUserProviderId;
    }

    public void setSentUserProviderId(String sentUserProviderId) {
        this.sentUserProviderId = sentUserProviderId;
    }

    public BigInteger getReceivedMemberId() {
        return receivedMemberId;
    }

    public void setReceivedMemberId(BigInteger receivedMemberId) {
        this.receivedMemberId = receivedMemberId;
    }

    public String getReceivedUserProviderId() {
        return receivedUserProviderId;
    }

    public void setReceivedUserProviderId(String receivedUserProviderId) {
        this.receivedUserProviderId = receivedUserProviderId;
    }
}
