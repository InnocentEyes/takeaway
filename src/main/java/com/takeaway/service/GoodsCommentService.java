package com.takeaway.service;

import com.takeaway.pojo.GoodsComment;

/**
 * @author qzlzzz
 * 商品评论的业务接口
 */
public interface GoodsCommentService {

    /**
     * 发表评论
     */
    boolean addGoodsComment(GoodsComment goodsComment);

}
