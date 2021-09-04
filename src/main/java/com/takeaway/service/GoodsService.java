package com.takeaway.service;

import com.takeaway.pojo.Goods;

import java.util.List;

/**
 * @author qzlzzz
 */
public interface GoodsService {

    /**
     * 根据商品的类型查询所有属于该类型的商品(其中包括商品代码)
     * @param typeNo 商品的类型
     * @return 一组属于该类型的商品
     */
    List<Goods> findGoodsByTypeNo(String typeNo);

    /**
     * 根据商品的商品代码 查询商品
     * @param goodNo 商品的代码 这要从同一类型的一组List集合中获取 与上面的方法配合
     * @return 属于同一商品类型的不同商品的对象
     */
    List<Goods> findGoodsByGoodNo(String[] goodNo);

    /**
     * 根据商品的Id查询商品的信息
     * @param goods_id 商品的id
     * @return 符合条件的商品对象
     */
    Goods findGoodByGoodId(Integer goods_id);

}
