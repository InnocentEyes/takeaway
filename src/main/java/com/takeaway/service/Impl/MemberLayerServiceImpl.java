package com.takeaway.service.Impl;

import com.takeaway.mapper.MemberLayerDao;
import com.takeaway.mapper.MemberMapper;
import com.takeaway.mapper.OrderDao;
import com.takeaway.pojo.MemberLayer;
import com.takeaway.pojo.Orders;
import com.takeaway.service.MemberLayerService;
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
public class MemberLayerServiceImpl implements MemberLayerService {

    private static final Integer ORDINARY = 0;
    private static final Integer SILVER = 3000;
    private static final Integer GOLD= 8000;
    private static final Integer PLATINUM = 15000;
    private static final Float SECOND_POINT = 1.2f;
    private static final Float THIRD_POINT = 1.3f;
    private static final Float FOUR_POINT = 1.4f;

    @Autowired//这里可以用@Resource
    private MemberMapper memberMapper;

    @Autowired//这里可以用@Resource
    private MemberLayerDao memberLayerDao;

    @Autowired//这里可以用@Resource
    private OrderDao orderDao;

    @Override
    public boolean addMemberLayerByMemberId(MemberLayer memberLayer) {
        boolean flag = false;
        if (memberMapper != null && memberLayerDao != null){
            if (memberMapper.findById(memberLayer.getId()).getId() == memberLayer.getId()){
                flag = memberLayerDao.addMemberLayer(memberLayer);
            }
        }
        return flag;
    }

    @Override
    public boolean updateMemberLayerByMemberId(Integer member_id,String order_no) {
        boolean flag = false;
        MemberLayer memberLayer = null;
        memberLayer.setId(member_id);
        Integer credit = 0;
        Integer addCredit = 0;
        Integer deleteCredit = 0;
        if (memberLayerDao != null && orderDao != null){
            if (memberLayerDao.findMemberLayerById(member_id).getId() == member_id){
                List<Orders> ordersList = orderDao.findMemberOrder(member_id);
                Orders[] order = null;
                ordersList.forEach(orders -> {
                    if (orders.getName() == order_no) {
                        order[0] = orders;
                    }
                });
                deleteCredit = order[0].getCreditUsed();
                addCredit = order[0].getCredit();
                credit = memberLayerDao.findMemberLayerById(member_id).getMinCredit();
                if (credit < deleteCredit){
                    return flag;
                }
                Integer amount = addCredit + credit - deleteCredit;
                if (amount >= ORDINARY && amount <= SILVER){
                    flag = true;
                }else if (amount >= SILVER && amount <= GOLD) {
                    memberLayer.setLayer("白银会员");
                    memberLayer.setMinCredit(amount);
                    memberLayer.setCreditScale(SECOND_POINT);
                    flag = memberLayerDao.updateMemberLayer(memberLayer);
                }else if (amount >= GOLD && amount <= PLATINUM){
                    memberLayer.setLayer("黄金会员");
                    memberLayer.setMinCredit(amount);
                    memberLayer.setCreditScale(THIRD_POINT);
                    flag = memberLayerDao.updateMemberLayer(memberLayer);
                }else if (amount >= PLATINUM){
                    memberLayer.setLayer("白金会员");
                    memberLayer.setMinCredit(amount);
                    memberLayer.setCreditScale(FOUR_POINT);
                    flag = memberLayerDao.updateMemberLayer(memberLayer);
                }

            }
        }
        return flag;
    }

    @Override
    public MemberLayer findMemberLayerByMemberId(Integer member_id) {
        MemberLayer memberLayer = null;
        if (memberLayerDao != null){
            memberLayer = memberLayerDao.findMemberLayerById(member_id);
        }
        return memberLayer;
    }
}
