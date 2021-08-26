package com.takeaway.service;

import com.takeaway.pojo.Member;

import java.util.Map;

public interface MemberService {
    //用户登录
    boolean queryByNick(String user_nick, String user_pwd);

    //注册会员
    boolean signinMember(Map map);

    //更新会员信息
    @Deprecated
    boolean updateMember(Map map);

    /**
     * 重置密码建议用此方法 效率高
     * @param user_nick
     * @param user_pwd
     * @return
     */
    boolean resetPassword(String user_nick,String user_pwd,String resetPassword);

    /**
     * 直接修改 不判断用户原先密码是否正确 不建议使用
     * @param user_nick
     * @param user_pwd
     * @return
     */
    @Deprecated
    boolean resetPassword(String user_nick,String user_pwd);

    /**
     * 注销用户 用户自行注销时 应该输入账户和密码
     * @param user_nick
     * @param user_pwd
     * @return
     */
    boolean deletePassword(String user_nick,String user_pwd);

    /**
     * 不建议使用该方法 管理员页面注销用户
     * @param user_nick
     * @return
     */
    @Deprecated
    boolean deletePassword(String user_nick);


}
