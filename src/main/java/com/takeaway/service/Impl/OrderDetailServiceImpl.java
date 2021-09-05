package com.takeaway.service.Impl;

import com.takeaway.exception.NoAsGoodsException;
import com.takeaway.mapper.GoodsDao;
import com.takeaway.mapper.MemberMapper;
import com.takeaway.mapper.OrderDao;
import com.takeaway.mapper.OrderDetailDao;
import com.takeaway.pojo.Goods;
import com.takeaway.pojo.OrderDetail;
import com.takeaway.pojo.Orders;
import com.takeaway.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;

@Service
@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,rollbackFor = {
        NullPointerException.class
})
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired//这里可以使用@Resource
    private OrderDetailDao orderDetailDao;

    @Autowired//这里可以使用@Resource
    private GoodsDao goodsDao;

    @Autowired//这里可以使用@Resource
    private OrderDao orderDao;

    @Autowired//这里可以使用@Resource
    private MemberMapper memberMapper;

    @Override
    public boolean addOrderDetail(OrderDetail orderDetail) throws NoAsGoodsException {
        boolean flag = false;
        Goods goods = null;

        if (orderDetailDao != null && goodsDao != null){
            if (goodsDao.findGoodsByNo(orderDetail.getGoodsNo()) == null){
                throw new NoAsGoodsException("没有该商品!");
            }
            if (goodsDao.findGoodsByNo(orderDetail.getGoodsNo()) != null){
                goods = goodsDao.findGoodsByNo(orderDetail.getGoodsNo());
                Float memberPrice = goods.getDiscount() * goods.getPrice();
                orderDetail.setMemberPrice(memberPrice);
                Float allPrice = orderDetail.getQty() * memberPrice;
                orderDetail.setAllPrice(allPrice);
                flag = orderDetailDao.addOrderDetail(orderDetail);
            }
        }
        return flag;
    }

    @Override
    public OrderDetail addCart(OrderDetail orderDetail) throws NoAsGoodsException {
        OrderDetail orderDetail1 = null;
        boolean flag = addOrderDetail(orderDetail);
        if (flag = true){
            orderDetail = findOrderDetailByGoodsNo(orderDetail.getGoodsNo());
        }
        return orderDetail;
    }

    @Override
    public OrderDetail findOrderDetailByGoodsNo(String goodNo) throws NoAsGoodsException {
        OrderDetail orderDetail = null;
        if (orderDetailDao != null && goodsDao != null){
            if (goodsDao.findGoodsByNo(goodNo) == null){
                throw new NoAsGoodsException("没有该商品!");
            }
            if (goodsDao.findGoodsByNo(goodNo) != null){
                orderDetail = orderDetailDao.findOrderDetailByGoodNo(goodNo);
            }
        }
        return orderDetail;
    }

    @Override
    public List<OrderDetail> findOrderDetailByOrderNo(String order_no,Integer member_id) {
        List<OrderDetail> orderDetailList = null;
        if (orderDetailDao != null && memberMapper != null && orderDao != null){
            List<Orders> list = orderDao.findMemberOrder(member_id);
            Iterator<Orders> iterator = list.iterator();
            while (iterator.hasNext()){
                Orders order = iterator.next();
                if (order.getName() == order_no){
                    orderDetailList = orderDetailDao.findOrderDetailByOrderNo(order_no);
                    break;
                }
            }
        }
        return orderDetailList;
    }

    @Override
    public Boolean deleteOrderDetail(Integer orderDetail_id) {
        boolean flag = false;
        if (orderDetailDao != null){
            if (orderDetailDao.findOrderDetailBYOrderDetailId(orderDetail_id).getId() == orderDetail_id){
                flag = orderDetailDao.deleteOrderDetailById(orderDetail_id);
            }
        }
        return flag;
    }

    @Override
    public List<OrderDetail> findOrderDetailByOrderDetailId(Integer[] orderDetail_ids) {
        List<OrderDetail> orderDetailList = null;
        if (orderDetailDao != null){
            for (Integer orderDetail_id : orderDetail_ids) {
                if (orderDetailDao.findOrderDetailBYOrderDetailId(orderDetail_id).getId() == orderDetail_id){
                    OrderDetail orderDetail = orderDetailDao.findOrderDetailBYOrderDetailId(orderDetail_id);
                    orderDetailList.add(orderDetail);
                }
            }
        }
        return orderDetailList;
    }
}
