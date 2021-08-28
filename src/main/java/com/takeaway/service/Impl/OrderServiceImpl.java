package com.takeaway.service.Impl;

import com.github.pagehelper.PageHelper;
import com.takeaway.mapper.MemberMapper;
import com.takeaway.mapper.OrderDao;
import com.takeaway.mapper.ShipAddressDao;
import com.takeaway.pojo.Orders;
import com.takeaway.service.OrderService;
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

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private ShipAddressDao shipAddressDao;

    @Override
    public List<Orders> findMemberAllOrder(Integer member_id,Integer page,Integer size) {
        List<Orders> ordersList = null;
        if (orderDao != null && memberMapper != null && shipAddressDao != null){
            if (memberMapper.findById(member_id) == null){
                return ordersList;//这边应该换为异常 然后写一个切面类去处理这个异常 比如使用日志记录下来，在调试的时候好更改
            }
            if (shipAddressDao.findShipAddressById(member_id) == null){
                return ordersList;//这里return 空 需要在控制器判断空后跳转到地址薄添加页面
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
        return ordersList;
    }

    @Override
    public Orders findOrderById(Integer order_id) {
        Orders order = null;

        if (orderDao != null){
            if (orderDao.findOrderById(order_id) == null){
                return order;////这里return 空 需要在控制器判断空后跳转到商城首页
            }
            order = orderDao.findOrderById(order_id);
        }
        return order;
    }

    @Override
    public List<Orders> findMemberOrderCredit(Integer member_id) {
        List<Orders> ordersList = null;
        if (orderDao != null && memberMapper != null && shipAddressDao != null){
            if (memberMapper.findById(member_id) == null){
                return ordersList;
                //这边应该换为异常 然后写一个切面类去处理这个异常 比如使用日志记录下来，在调试的时候好更改
            }
            if (shipAddressDao.findShipAddressById(member_id) == null){
                return ordersList;//这里return 空 需要在控制器判断空后跳转到地址薄添加页面
                //这边应该换为异常 然后写一个切面类去处理这个异常 比如使用日志记录下来，在调试的时候好更改
            }
            if (orderDao.findMemberOrderCredit(member_id) != null){
                ordersList = findMemberOrderCredit(member_id);
            }
        }
        return ordersList;
    }
}
