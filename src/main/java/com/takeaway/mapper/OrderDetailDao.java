package com.takeaway.mapper;

import com.takeaway.pojo.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qzlzzz
 * 商品清单数据访问层接口
 */
@Mapper
public interface OrderDetailDao {

    /**
     *添加商品的清单
     * @param orderDetail
     * @return
     */
    boolean addOrderDetail(OrderDetail orderDetail);

    /**
     * 注入商品清单的订单编号
     * @param order_no
     * @return
     */
    boolean updateOrderNo(@Param("goodNo") String goodNo,@Param("orderNo") String order_no);

    /**
     * 根据商品的编号来查询商品清单
     * @param goodNo
     * @return
     */
    OrderDetail findOrderDetailByGoodNo(@Param("goodNo") String goodNo);

    /**
     * 根据订单的编号来查询商品清单
     * @param order_no
     * @return
     */
    List<OrderDetail> findOrderDetailByOrderNo(@Param("orderNo") String order_no);
}
