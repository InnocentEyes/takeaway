package com.takeaway.service;

import com.takeaway.exception.NoAsGoodsException;
import com.takeaway.pojo.OrderDetail;

import java.util.List;

/**
 * @author qzlzzz
 */
public interface OrderDetailService {

    /**
     * 封装了addOrderDetail方法和findOrderDetailByGoodsNo方法 真正在加入购物车时使用
     * @param orderDetail
     * @return 一个商品清单的对象
     * @throws NoAsGoodsException
     */
    OrderDetail addCart(OrderDetail orderDetail) throws NoAsGoodsException;

    /**
     * 根据订单编号查询所有的商品清单
     * @param order_no 订单编号
     * @param member_id 用户的id 从session里面取
     * @return
     */
    List<OrderDetail> findOrderDetailByOrderNo(String order_no,Integer member_id);

    /**
     * 根据用户的ID删除商品的清单 删除购物车里面的清单
     * @param orderDetail_id 商品清单的ID 从request作用域中获取
     * @return
     */
    Boolean deleteOrderDetail(Integer orderDetail_id);

    /**
     * 根据商品清单的ID获取商品清单
     * @param orderDetail_id 商品清单的ID从session获取
     * @return
     */
    List<OrderDetail> findOrderDetailByOrderDetailId(Integer[] orderDetail_ids);

    /**
     * 添加商品的清单 加入购物车时用
     * @param orderDetail
     * @return
     */
    @Deprecated
    boolean addOrderDetail(OrderDetail orderDetail) throws NoAsGoodsException;

    /**
     *根据商品的代码查询商品清单
     * @param goodNo 商品代码
     * @return
     */
    @Deprecated
    OrderDetail findOrderDetailByGoodsNo(String goodNo) throws NoAsGoodsException;


}
