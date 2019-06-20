package com.connectnow.dto;

import java.sql.Timestamp;

public class MessageSocketDto {
    private Long id;
    private String content;
    private MessageType type;
    private Timestamp date;
    private Long sentMemberId;
    private String sentUserProviderId;
    private Long receivedMemberId;
    private String receivedUserProviderId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Long getSentMemberId() {
        return sentMemberId;
    }

    public void setSentMemberId(Long sentMemberId) {
        this.sentMemberId = sentMemberId;
    }

    public String getSentUserProviderId() {
        return sentUserProviderId;
    }

    public void setSentUserProviderId(String sentUserProviderId) {
        this.sentUserProviderId = sentUserProviderId;
    }

    public Long getReceivedMemberId() {
        return receivedMemberId;
    }

    public void setReceivedMemberId(Long receivedMemberId) {
        this.receivedMemberId = receivedMemberId;
    }

    public String getReceivedUserProviderId() {
        return receivedUserProviderId;
    }

    public void setReceivedUserProviderId(String receivedUserProviderId) {
        this.receivedUserProviderId = receivedUserProviderId;
    }
}
