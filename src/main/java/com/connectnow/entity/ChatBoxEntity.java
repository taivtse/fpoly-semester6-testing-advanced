package com.connectnow.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name = "chat_box")
public class ChatBoxEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "last_message_id", nullable = false)
    private BigInteger lastMessageId;

    @OneToMany(mappedBy = "chatBoxEntity", fetch = FetchType.EAGER)
    private List<MemberEntity> memberEntityList;

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

    public List<MemberEntity> getMemberEntityList() {
        return memberEntityList;
    }

    public void setMemberEntityList(List<MemberEntity> memberEntityList) {
        this.memberEntityList = memberEntityList;
    }
}
