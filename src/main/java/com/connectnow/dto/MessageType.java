package com.connectnow.dto;

public enum MessageType {
    TEXT("TEXT"), IMAGE("IMAGE"), VIDEO("VIDEO"), FILE("FILE"), ICON("ICON"), STICKER("STICKER");
    private String type;

    MessageType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
