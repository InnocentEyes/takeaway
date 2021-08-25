package com.takeaway.mapper;

import com.takeaway.pojo.MemberLayer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qzlzzz
 * 会员等级操作接口
 */
public interface MemberLayerDao {
    /**
     * 添加用户的会员等级 (在用户注册时用)
     * @param memberLayer
     * @return
     */
    boolean addMemberLayer(MemberLayer memberLayer);

    /**
     * 更新用户的会员等级 在购买商品时添加积分判断是否可以升级
     * @param memberLayer
     * @return
     */
    boolean updateMemberLayer(MemberLayer memberLayer);

    /**
     * 管理员用 查询用户的会员等级
     * @param memberLayer_id
     * @return
     */
    MemberLayer findMemberLayerById(@Param("id") Integer memberLayer_id);

    /**
     * 管理员用 查询所有的会员等级信息
     * @return
     */
    List<MemberLayer> findAllMemberLayer();
}
