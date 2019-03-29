package com.connectnow.dao.impl;

import com.connectnow.dao.MemberDao;
import com.connectnow.entity.MemberEntity;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public class MemberDaoImpl extends AbstractDaoImpl<BigInteger, MemberEntity> implements MemberDao {
}
