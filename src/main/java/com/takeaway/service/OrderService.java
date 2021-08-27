package com.takeaway.service;

import com.takeaway.pojo.OrderDetail;
import com.takeaway.pojo.Orders;

import java.util.Date;
import java.util.List;

/**
 * @author qzlzzz
 * 查询订单
 */
public interface OrderService {

    /**
     * 查询用户的所有订单(非详细)
     * @param page 第几页
     * @param size 一页中有多少行数据
     * @return
     */
    List<Orders> findMemberAllOrder(Integer member_id,Integer page,Integer size);

    /**
     * 根据订单的id查出所有的细节
     * @param order_id 订单的ID
     * @return 订单所有细节
     */
    Orders findOrderById(Integer order_id);

    /**
     *
     * 查询用户订单以及订单所产生的积分
     * @param member_id:用户的id
     * @return 一组集合
     */
    List<Orders> findMemberOrderCredit(Integer member_id);
}
