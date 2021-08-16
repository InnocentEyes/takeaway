package com.takeaway.service;

import com.takeaway.mapper.MemberMapper;
import com.takeaway.pojo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    MemberMapper memberMapper;

    public Member queryById(Integer user_id, String user_pwd) {
        return memberMapper.queryById(user_id,user_pwd);
    }

    public boolean signinMember(Map map) {
        return memberMapper.signinMember(map);
    }

    public boolean updateMember(Map map) {
        return memberMapper.updateMember(map);
    }
}
