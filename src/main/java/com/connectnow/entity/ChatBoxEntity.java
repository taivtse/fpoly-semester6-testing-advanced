package com.connectnow.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "chat_box")
public class ChatBoxEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "last_message_id")
    private BigInteger lastMessageId;

    @Column(name = "last_message_date")
    private Date lastMessageDate;

    @OneToMany(mappedBy = "chatBox", fetch = FetchType.LAZY)
    private List<MemberEntity> memberList;

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

    public List<MemberEntity> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<MemberEntity> memberList) {
        this.memberList = memberList;
    }
}
