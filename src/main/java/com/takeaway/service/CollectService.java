package com.takeaway.service;

import com.takeaway.pojo.Collect;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qzlzzz
 * 收藏夹业务接口
 */
public interface CollectService {

    /**
     * 收藏商品
     * @param collect 收藏商品的对象
     * @return 添加成功或失败
     */
    boolean addCollect(Collect collect);

    /**
     * 根据收藏商品的ID值删除收藏的商品
     * @param member_id 用户的ID
     * @param collect_id 收藏商品的ID
     * @return 删除成功或失败
     */
    boolean deleteCollect(Integer member_id,Integer collect_id);

    /**
     * 根据用户ID查询用户所有的收藏
     * @param member_id 用户ID
     * @param page 第几页
     * @param size 一页有多少行
     * @return 一组收藏商品的集合
     */
    List<Collect> findCollectByMemberId(Integer member_id,Integer page,Integer size);

    /**
     * 根据用户的ID查找用户收藏商品的数量
     * @param member_id 用户的ID
     * @return 收藏商品的数量
     */
    Integer findCollectCountByMemberId(Integer member_id);
}
