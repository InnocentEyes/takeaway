package com.takeaway.service;

import com.takeaway.pojo.MemberLayer;

/**
 * @author qzlzzz
 */
public interface MemberLayerService {

    /**
     * 添加用户会员的等级 在用户注册时用
     * @param member_id 用户的ID 从session中拿
     * @return
     */
    boolean addMemberLayerByMemberId(MemberLayer memberLayer);

    /**
     * 根据用户的id更新用户的会员等级
     * @param member_id 用户的ID
     * @param order_no 订单的编号
     * @return
     */
    boolean updateMemberLayerByMemberId(Integer member_id,String order_no);

    /**
     * 根据用户的ID查询用户的会员等级
     * @param member_id 用户的ID 从session中拿
     * @return
     */
    MemberLayer findMemberLayerByMemberId(Integer member_id);
}
