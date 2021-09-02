package com.takeaway.service.Impl;

import com.takeaway.mapper.GoodsDao;
import com.takeaway.pojo.Goods;
import com.takeaway.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,rollbackFor = {
        NullPointerException.class
})
public class GoodsServiceImpl implements GoodsService {

    @Autowired//这里可用@Resource
    private GoodsDao goodsDao;

    @Override
    public List<Goods> findGoodsByTypeNo(String typeNo) {
        List<Goods> goods = new ArrayList<>();
        Integer amount = goodsDao.findGoodsCount(typeNo);
        System.out.println(amount);
        if (goodsDao != null){
            if (amount > 0){
                goods = goodsDao.findGoodsByType(typeNo);
            }
        }
        return goods;
    }

    @Override
    public List<Goods> findGoodsByGoodNo(String[] goodNo) {
        List<Goods> goods = null;
        if (goodsDao != null){
            for (String good_no : goodNo) {
                goods.add(goodsDao.findGoodsByNo(good_no));
            }
        }
        return goods;
    }
}
