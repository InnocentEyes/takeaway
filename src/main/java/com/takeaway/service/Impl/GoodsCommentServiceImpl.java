package com.takeaway.service.Impl;

import com.takeaway.mapper.GoodsCommentDao;
import com.takeaway.mapper.GoodsDao;
import com.takeaway.mapper.MemberMapper;
import com.takeaway.pojo.GoodsComment;
import com.takeaway.service.GoodsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,rollbackFor = {
        NullPointerException.class
})
public class GoodsCommentServiceImpl implements GoodsCommentService {

    @Autowired
    private GoodsCommentDao goodsCommentDao;

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public boolean addGoodsComment(GoodsComment goodsComment) {
        boolean flag = false;
        if (goodsCommentDao != null && memberMapper != null && goodsDao != null){

        }

        return flag;
    }
}
