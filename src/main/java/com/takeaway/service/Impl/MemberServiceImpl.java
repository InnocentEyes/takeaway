package com.takeaway.service.Impl;

import com.takeaway.mapper.MemberMapper;
import com.takeaway.pojo.Member;
import com.takeaway.service.MemberService;
import com.takeaway.util.BASE64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Transactional(isolation = Isolation.REPEATABLE_READ,
        propagation = Propagation.REQUIRED,rollbackFor = {
        NullPointerException.class
})
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired//这里可以使用@Resource
    MemberMapper memberMapper;


    @Override
    public boolean queryByNick(String user_nick, String user_pwd) {
        boolean flag = false;
        if(memberMapper != null){
            Member member = memberMapper.queryByNick(user_nick);
            String userPassword = BASE64.decode(member.getPassword());
            if (userPassword.equals(user_pwd)){
                flag = true;
            }
        }
        return flag;
    }


    @Override
    public boolean signinMember(Map map) {
        boolean flag = false;
        if (memberMapper != null){
            String userPassword = BASE64.encode((String) map.get("password"));
            map.put("password",userPassword);
            flag = memberMapper.signinMember(map);
        }
        return flag;
    }


    @Override
    public boolean updateMember(Map map) {
        boolean flag = false;
        String nick = (String) map.get("nick");
        if (memberMapper != null){
            if (!map.get("password").equals("")){
                if (memberMapper.queryByNick(nick) == null){
                    String userPassword = (String) map.get("password");
                    map.put("password",BASE64.encode(userPassword));
                    flag = memberMapper.updateMember(map);
                }
            }
        }
        return flag;
    }


    @Override
    public boolean resetPassword(String user_nick, String user_pwd,String reset_pwd) {
        boolean flag = false;
        if (memberMapper != null){
            user_pwd = BASE64.encode(user_pwd);
            flag = queryByNick(user_nick, user_pwd);
            if (flag == true){
                reset_pwd = BASE64.encode(reset_pwd);
                flag = memberMapper.resetPassword(user_nick,reset_pwd);
            }
        }
        return flag;
    }


    @Override
    public boolean resetPassword(String user_nick, String user_pwd) {
        boolean flag = false;
        if (memberMapper != null){
            user_pwd = BASE64.encode(user_pwd);
            flag = memberMapper.resetPassword(user_nick, user_pwd);
        }
        return flag;
    }


    @Override
    public boolean deleteMember(String user_nick, String user_pwd) {
        boolean flag = false;
        if (memberMapper != null){
            user_pwd = BASE64.encode(user_pwd);
            flag = queryByNick(user_nick,user_pwd);
            if (flag == true){
                flag = memberMapper.deleteMember(user_nick);
            }
        }
        return flag;
    }


    @Override
    public boolean deleteMember(String user_nick) {
        boolean flag = false;
        if (memberMapper != null){
            flag = memberMapper.deleteMember(user_nick);
        }
        return flag;
    }


    @Override
    public Member login(String user_nick, String user_pwd) {
        boolean flag = false;
        Member member = null;
        if (memberMapper != null){
            flag = queryByNick(user_nick, user_pwd);
            if (flag == true){
                member = memberMapper.queryByNick(user_nick);
            }
        }
        return member;
    }

    @Override
    public Member register(Map map) {
        boolean flag = false;
        Member member = null;
        String user_nick = (String) map.get("nick");
        if (memberMapper != null){
            flag = signinMember(map);
            if (flag == true){
                member = memberMapper.queryByNick(user_nick);
            }
        }
        return member;
    }
}
