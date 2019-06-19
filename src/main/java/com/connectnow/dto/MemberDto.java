package com.connectnow.dto;

import java.math.BigInteger;

public class MemberDto {
    private Long id;
    private ChatBoxDto chatBox;
    private UserDto user;
    private boolean readStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ChatBoxDto getChatBox() {
        return chatBox;
    }

    public void setChatBox(ChatBoxDto chatBox) {
        this.chatBox = chatBox;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public boolean isReadStatus() {
        return readStatus;
    }

    public void setReadStatus(boolean readStatus) {
        this.readStatus = readStatus;
    }
}
