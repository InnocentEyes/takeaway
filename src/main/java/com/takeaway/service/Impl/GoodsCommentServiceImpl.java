package com.takeaway.service.Impl;

import com.github.pagehelper.PageHelper;
import com.takeaway.exception.NoAsGoodsException;
import com.takeaway.exception.PageEnoughException;
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

import java.util.List;

@Service
@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,rollbackFor = {
        NullPointerException.class
})
public class GoodsCommentServiceImpl implements GoodsCommentService {

    @Autowired//这里可以使用@Resource
    private GoodsCommentDao goodsCommentDao;

    @Autowired//这里可以使用@Resource
    private MemberMapper memberMapper;

    @Autowired//这里可以使用@Resource
    private GoodsDao goodsDao;

    @Override
    public boolean addGoodsComment(GoodsComment goodsComment) throws NoAsGoodsException {
        boolean flag = false;
        if (goodsCommentDao != null && memberMapper != null && goodsDao != null){
            if (memberMapper.findById(goodsComment.getMemberid()) == null){
                return flag;//跳转注册页面
            }
            if (goodsDao.findGoodsByNo(goodsComment.getGoodsNo()) == null){
                throw new NoAsGoodsException("没有此商品");
            }
            flag = goodsCommentDao.addGoodsComment(goodsComment);
        }

        return flag;
    }

    @Override
    public List<GoodsComment> findAllComments(String goodId, Integer page, Integer size) throws PageEnoughException, NoAsGoodsException {
        List<GoodsComment> goodsCommentList = null;
        if (goodsCommentDao != null && memberMapper != null && goodsDao != null){
            if (goodsDao.findGoodsByNo(goodId) == null){
                throw new NoAsGoodsException("没有此商品!");
            }
            Integer amount = goodsCommentDao.findGoodsCommentCountByNo(goodId) / size +1;
            if (page <= amount){
                PageHelper.startPage(page,size);
                //这里不用findAllCommentByGoodsId是为了效率
                goodsCommentList = goodsCommentDao.findGoodsCommentByGoodsId(goodId);
            }else {
                throw new PageEnoughException("页面超出异常!");
            }

        }
        return goodsCommentList;
    }

    @Override
    public Integer findAllCommentByGoodsId(String goodId) {
        Integer size = 0;
        if (goodsCommentDao != null){
            size = goodsCommentDao.findGoodsCommentCountByNo(goodId);
        }
        return size;
    }


}
