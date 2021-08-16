package com.takeaway.service;

import com.takeaway.pojo.Member;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface MemberService {
    //用户登录
    Member queryById(@Param("id")Integer user_id, @Param("pwd") String user_pwd);

    //注册会员
    boolean signinMember(Map map);

    //更新会员信息
    boolean updateMember(Map map);
}
