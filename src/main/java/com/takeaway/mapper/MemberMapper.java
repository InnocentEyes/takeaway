package com.takeaway.mapper;

import com.takeaway.pojo.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper //可加可不加，已经在spring-mybatis.xml已经实现扫描注入spring
public interface MemberMapper {
    @Deprecated
    //用户登录
    Member queryById(@Param("id") Integer user_id,@Param("pwd") String user_pwd);

    //用户登录
    Member queryByNick(@Param("nick")String user_nick);

    //注册会员
    boolean signinMember(Map map);

    //更新会员信息
    boolean updateMember(Map map);

    //重置密码
    boolean resetPassword(@Param("nick") String user_nick,@Param("pwd") String user_pwd);

    //根据ID删除会员
    boolean deleteMember(@Param("nick") String user_nick);


}
