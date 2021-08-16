package com.takeaway.service;

import com.takeaway.mapper.MemberMapper;
import com.takeaway.pojo.Member;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberMapper memberMapper;

    public Member queryById(Integer user_id, String user_pwd) {
        return null;
    }

    public boolean signinMember(Map map) {
        return false;
    }

    public boolean updateMember(Map map) {
        return false;
    }
}
