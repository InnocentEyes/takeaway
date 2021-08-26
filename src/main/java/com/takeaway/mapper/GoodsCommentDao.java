package com.takeaway.mapper;

import com.takeaway.pojo.GoodsComment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qzlzzz
 */
public interface GoodsCommentDao {
    /**
     * 增加商品的评论 评分 等
     * @param goodsComment
     * @return
     */
    boolean addGoodsComment(GoodsComment goodsComment);

    /**
     * 在业务方法用此方法根据条件分页查询 使用PageHelp插件 与查找商品的一样
     *
     * 具体的使用方法:
     *      PageHelper.startPage(1,3)
     *      第一个参数是第几页
     *      第二个参数是一页中有多少行数据
     *
     * @return
     */
    List<GoodsComment> findAllGoodsComment();

    /**
     * 根据商品的类别查找具体的数量
     * @param no
     * @return
     */
    int findGoodsCommentByNo(@Param("no") String no);
}
