package com.takeaway.service;

import com.takeaway.exception.NotEnoughtException;
import com.takeaway.mapper.MemberMapper;
import com.takeaway.pojo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberMapper memberMapper;

    @Transactional(isolation = Isolation.REPEATABLE_READ,
            propagation = Propagation.REQUIRED,rollbackFor = {
            NullPointerException.class
    })
    public Member queryById(Integer user_id, String user_pwd) {
        return memberMapper.queryById(user_id,user_pwd);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ,
            propagation = Propagation.REQUIRED,rollbackFor = {
            NullPointerException.class
    })
    public boolean signinMember(Map map) {
        return memberMapper.signinMember(map);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ,
            propagation = Propagation.REQUIRED,rollbackFor = {
            NullPointerException.class
    })
    public boolean updateMember(Map map) {
        return memberMapper.updateMember(map);
    }
}
