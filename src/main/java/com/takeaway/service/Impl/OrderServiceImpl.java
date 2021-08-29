package com.takeaway.service.Impl;

import com.github.pagehelper.PageHelper;
import com.takeaway.exception.NoAsShipAdressException;
import com.takeaway.mapper.*;
import com.takeaway.pojo.Orders;
import com.takeaway.service.OrderService;
import com.takeaway.util.OrderNoUtil;
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
public class OrderServiceImpl implements OrderService {

    @Autowired//这里可以使用@Resource
    private OrderDao orderDao;

    @Autowired//这里可以使用@Resource
    private GoodsDao goodsDao;

    @Autowired//这里可以使用@Resource
    private OrderDetailDao orderDetailDao;

    @Autowired//这里可以使用@Resource
    private MemberMapper memberMapper;

    @Autowired//这里可以使用@Resource
    private ShipAddressDao shipAddressDao;

    @Override
    public List<Orders> findMemberAllOrder(Integer member_id,Integer page,Integer size) throws NoAsShipAdressException {
        List<Orders> ordersList = null;
        if (orderDao != null && memberMapper != null && shipAddressDao != null){
            if (memberMapper.findById(member_id) == null){
                return ordersList;//跳转到注册页面
                //这里需要修改
            }
            if (shipAddressDao.findShipAddressById(member_id) == null){
                return ordersList;//判断地址为空，跳转到用户地址bo
            }
            if (orderDao.findMemberOrder(member_id) != null) {
                int count = orderDao.findMemberOrderCount(member_id);
                int limit = count / size + 1;
                if (page <= limit) {
                    PageHelper.startPage(page,size);
                    ordersList = orderDao.findMemberOrder(member_id);
                }
            }
        }
        return ordersList;//null 跳转注册页面
    }

    @Override
    public Orders findOrderById(Integer order_id) {
        Orders order = null;

        if (orderDao != null){
            if (orderDao.findOrderById(order_id) == null){
                return order;//这里return 空 需要在控制器判断空后跳转到商城首页
            }
            order = orderDao.findOrderById(order_id);
        }
        return order;
    }

    @Override
    public List<Orders> findMemberOrderCredit(Integer member_id) throws NoAsShipAdressException {
        List<Orders> ordersList = null;
        if (orderDao != null && memberMapper != null && shipAddressDao != null){
            if (memberMapper.findById(member_id) == null){
                return ordersList;//这里需要修改
                //这边应该换为异常 然后写一个切面类去处理这个异常 比如使用日志记录下来，在调试的时候好更改
            }
            if (shipAddressDao.findShipAddressById(member_id) == null){
                return ordersList;//判断地址为空，跳转到用户地址bo
            }
            if (orderDao.findMemberOrderCredit(member_id) != null){
                ordersList = orderDao.findMemberOrderCredit(member_id);
            }
        }
        return ordersList;
    }

    @Override
    public boolean addOrder(String[] goodNo, Orders orders) {
        boolean flag = false;
        if (orderDao != null && orderDetailDao != null && memberMapper != null){
            if (memberMapper.findById(orders.getType()) == null){
                return flag;
            }
            if (shipAddressDao.findShipAddressById(orders.getType()) == null){
                return flag;
            }
            String orderNo = OrderNoUtil.generateUID();
            orders.setName(orderNo);
            flag = orderDao.addOrder(orders);
            if (flag = true){
                flag = false;
                for (String goods : goodNo) {
                    if (goodsDao.findGoodsByNo(goods) != null) {
                        flag = orderDetailDao.updateOrderNo(goods,orderNo);
                    }
                }
            }
        }
        return flag;
    }
}
