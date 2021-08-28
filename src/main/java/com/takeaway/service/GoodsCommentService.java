package com.takeaway.service;

import com.takeaway.exception.NoAsGoodsException;
import com.takeaway.exception.PageEnoughException;
import com.takeaway.pojo.GoodsComment;

import java.util.List;

/**
 * @author qzlzzz
 * 商品评论的业务接口
 */
public interface GoodsCommentService {

    /**
     * 发表评论
     * @param goodsComment
     * @return
     */
    boolean addGoodsComment(GoodsComment goodsComment) throws NoAsGoodsException;

    /**
     * 查询商品的评论
     * @param page
     * @param size
     * @return
     */
    List<GoodsComment> findAllComments(String goodId,Integer page,Integer size) throws PageEnoughException, NoAsGoodsException;

    /**
     * 根据商品的代码查找该商品的评论的数量 好做前端和后端的分页
     * @param goodId
     * @return
     */
    Integer findAllCommentBiGoodsId(String goodId);

}
