package com.takeaway.service;

import com.takeaway.exception.NoAsGoodsException;
import com.takeaway.pojo.OrderDetail;

import java.util.List;

/**
 * @author qzlzzz
 */
public interface OrderDetailService {

    /**
     * 添加商品的清单
     * @param orderDetail
     * @return
     */
    boolean addOrderDetail(OrderDetail orderDetail) throws NoAsGoodsException;

    /**
     *根据商品的代码查询商品清单
     * @param goodNo 商品代码
     * @return
     */
    OrderDetail findOrderDetailByGoodsNo(String goodNo) throws NoAsGoodsException;

    /**
     * 根据订单编号查询所有的商品清单
     * @param order_no 订单编号
     * @param member_id 用户的id 从session里面取
     * @return
     */
    List<OrderDetail> findOrderDetailByOrderNo(String order_no,Integer member_id);


}
