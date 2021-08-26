package com.takeaway.mapper;

import com.takeaway.pojo.Collect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qzlzzz
 */
public interface CollectDao {
    /**
     * 在商品页面点击收藏 调用该方法
     * @param collect
     * @return
     */
    boolean addCollect(Collect collect);

    /**
     * 个人页面中删除该收藏记录
     * @param collect_id
     * @return
     */
    boolean deleteCollect(@Param("id") Integer collect_id);

    /**
     * 在业务方法用此方法根据条件分页查询 使用PageHelp插件 与查找商品的方法一样
     *
     * 具体的使用方法:
     *      PageHelper.startPage(1,3)
     *      第一个参数是第几页
     *      第二个参数是一页中有多少行数据
     *
     * @return
     */
    List<Collect> findAllCollect(@Param("memberid") Integer member_id);

    /**
     * 根据会员的ID查找收藏的商品数量
     * @param member_id
     * @return
     */
    int findCollectCount(@Param("memberid") Integer member_id);
}
