package com.takeaway.mapper;

import com.takeaway.pojo.Orders;
import org.apache.ibatis.annotations.Param;
import org.aspectj.weaver.ast.Or;

import java.util.List;

/**
 * @author qzlzzz
 */
public interface OrderDao {
    /**
     * 增加订单
     * @param orders
     * @return
     */
    boolean addOrder(Orders orders);

    /**
     * 在业务方法用此方法根据条件分页查询 使用PageHelp插件 与查找商品的方法一样
     * 此方法查询所有的订单 但不是订单的全部内容 订单编号 送货地址 下单的时间 订单金额 支付方式
     *
     * 具体的使用方法:
     *      PageHelper.startPage(1,3)
     *      第一个参数是第几页
     *      第二个参数是一页中有多少行数据
     *
     * @return
     */
    List<Orders> findAllOrder();

    /**
     * 根据订单Id查出订单的明细
     * @param orderId
     * @return
     */
    Orders findOrderById(@Param("orderId") Integer orderId);


}
