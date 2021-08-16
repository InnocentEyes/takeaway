package com.takeaway.mapper;

import com.takeaway.pojo.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper //可加可不加，已经在spring-mybatis.xml已经实现扫描注入spring
public interface MemberMapper {

    //用户登录
    Member queryById(@Param("id")Integer user_id, @Param("pwd") String user_pwd);

    //注册会员
    boolean signinMember(Map map);

    //更新会员信息
    boolean updateMember(Map map);

}
