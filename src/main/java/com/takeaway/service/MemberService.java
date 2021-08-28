package com.takeaway.service;

import com.takeaway.pojo.Member;

import java.util.Map;

/**
 * @author qzlzzz Orange橙橙
 * 对修改关闭 对扩展开放 在修改时新增方法便可 无需改变原来的方法
 */
public interface MemberService {

    @Deprecated
    //用户登录,不推荐使用
    boolean queryByNick(String user_nick, String user_pwd);

    @Deprecated
    //注册会员
    boolean signinMember(Map map);

    //更新会员信息
    @Deprecated
    boolean updateMember(Map map);

    /**
     * 重置密码建议用此方法 效率高
     * @param user_nick 用户的昵称
     * @param user_pwd 用户的密码
     * @return
     */
    boolean resetPassword(String user_nick,String user_pwd,String resetPassword);

    /**
     * 直接修改 不判断用户原先密码是否正确 不建议使用
     * @param user_nick 用户的昵称
     * @param user_pwd 用户的密码
     * @return
     */
    @Deprecated
    boolean resetPassword(String user_nick,String user_pwd);

    /**
     * 注销用户 用户自行注销时 应该输入账户和密码
     * @param user_nick 用户的昵称
     * @param user_pwd 用户的密码
     * @return
     */
    boolean deleteMember(String user_nick,String user_pwd);

    /**
     * 不建议使用该方法 管理员页面注销用户
     * @param user_nick 用户的昵称
     * @return
     */
    @Deprecated
    boolean deleteMember(String user_nick);

    /**
     * 用来登录的真正方法
     * @param user_nick 用户的昵称
     * @param user_pwd 用户的密码
     * @return
     */
    Member login(String user_nick,String user_pwd);

    /**
     * 用于注册的真正方法
     * @param map
     * @return
     */
    Member register(Map map);
}
