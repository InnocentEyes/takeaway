package com.takeaway.mapper;

import com.takeaway.pojo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qzlzzz
 * 商品接口
 */
public interface GoodsDao {
    /**
     * 管理员用:增加商品
     * @param goods
     * @return
     */
    boolean addGood(Goods goods);

    /**
     * 更改商品的信息 如价格等 管理员用
     * @param goods
     * @return
     */
    boolean updateGood(Goods goods);

    /**
     * 删除商品 管理员用
     * @param goods_id
     * @return
     */
    boolean deleteGood(@Param("id") Integer goods_id);

    /**
     * 根据商品ID查询商品,管理员调用
     * @param goods_id
     * @return
     */
    Goods findGoodsById(@Param("id") Integer goods_id);

    /**
     * 在业务方法用此方法根据条件分页查询 使用PageHelp插件 与商品的评论一样
     *
     * 具体的使用方法:
     *      PageHelper.startPage(1,3)
     *      第一个参数是第几页
     *      第二个参数是一页中有多少行数据
     *
     * @return
     */
    List<Goods> findAllGoods();

    /**
     * 根据商品的类别 查询商品属于该类别的数量
     * 此方法理解有所不同 可以修改
     * 对应数据访问类的GoodsDao中的findCount()方法
     * @param type
     * @return
     */
    boolean findGoodsCount(@Param("typeno") String type);


}
