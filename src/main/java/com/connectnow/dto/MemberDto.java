package com.connectnow.dto;

import java.math.BigInteger;

public class MemberDto {
    private BigInteger id;
    private ChatBoxDto chatBoxDto;
    private UserDto userDto;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public ChatBoxDto getChatBoxDto() {
        return chatBoxDto;
    }

    public void setChatBoxDto(ChatBoxDto chatBoxDto) {
        this.chatBoxDto = chatBoxDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
