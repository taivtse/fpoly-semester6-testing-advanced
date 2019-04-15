package com.connectnow.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_box_id", nullable = false)
    private ChatBoxEntity chatBox;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "read_status", nullable = false)
    private boolean readStatus;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<MessageEntity> messageList;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public ChatBoxEntity getChatBox() {
        return chatBox;
    }

    public void setChatBox(ChatBoxEntity chatBox) {
        this.chatBox = chatBox;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<MessageEntity> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<MessageEntity> messageList) {
        this.messageList = messageList;
    }

    public boolean getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(boolean readStatus) {
        this.readStatus = readStatus;
    }
}
