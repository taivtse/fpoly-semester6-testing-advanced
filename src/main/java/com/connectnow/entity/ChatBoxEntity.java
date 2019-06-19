package com.connectnow.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "chat_box")
public class ChatBoxEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "last_message_id")
    private Long lastMessageId;

    @Column(name = "last_message_date")
    private Date lastMessageDate;

    @OneToMany(mappedBy = "chatBox", fetch = FetchType.LAZY)
    private List<MemberEntity> memberList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLastMessageId() {
        return lastMessageId;
    }

    public void setLastMessageId(Long lastMessageId) {
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
