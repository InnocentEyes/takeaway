package com.takeaway.service;

import com.takeaway.pojo.MemberLayer;

/**
 * @author qzlzzz
 */
public interface MemberLayerService {

    /**
     * 根据会员等级的ID查询会员的等级
     * @param layer_id 该会员等级的ID从session中获取
     * @return
     */
    MemberLayer findMemberLayerByLayerId(Integer layer_id);
}
