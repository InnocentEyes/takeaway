package com.takeaway.service;

import com.takeaway.mapper.MemberMapper;
import com.takeaway.mapper.ShipAddressDao;
import com.takeaway.pojo.ShipAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户地址薄
 */

@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,rollbackFor = {
        NullPointerException.class
})
@Service
public class ShipAdressServiceImpl implements ShipAdressService {

    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private ShipAddressDao shipAdressDao;

    @Override
    public ShipAddress addShipAdress(ShipAddress shipAddress) {
        boolean flag = false;
        ShipAddress address = null;
        if (shipAdressDao != null && memberMapper != null){
            /*这里需要加一个条件判断 判断areaId是不是0 或者 1呢*/
            if (memberMapper.findById(shipAddress.getMemberId()) == null){
                if (shipAddress.getAreaId() == 0 || shipAddress.getAreaId() == 1){
                    flag = shipAdressDao.addShipAddress(shipAddress);
                }
            }
        }
        if (flag = true){
            List<ShipAddress> shipAddressById = findAllShipAdressById(shipAddress.getMemberId());
            address = shipAddressById.get(0);
        }
        return address;
    }


    @Override
    public boolean updateShipAdress(ShipAddress shipAddress) {
        Integer isDefault = shipAddress.getIsDefault();
        boolean flag = false;
        if (shipAdressDao != null && memberMapper != null){
            if (memberMapper.findById(shipAddress.getMemberId()) != null){
                if (isDefault == 0){
                   flag = shipAdressDao.updateShipAddress(shipAddress);
                }else if (isDefault == 1){
                    List<ShipAddress> list = findAllShipAdressById(shipAddress.getMemberId());
                    list.forEach(address -> address.setIsDefault(0));
                    flag = shipAdressDao.updateShipAddress(shipAddress);
                }
            }
        }
        return  flag;
    }

    @Override
    public List<ShipAddress> findAllShipAdressById(Integer member_id) {
        List<ShipAddress> list = new ArrayList<>();
        if (shipAdressDao != null){
            list = shipAdressDao.findShipAddressById(member_id);
        }
        return list;
    }


    @Override
    public boolean deleteShipAdress(Integer member_id, Integer id) {
        boolean flag = false;
        if (shipAdressDao != null){
            flag = shipAdressDao.deleteShipAddressById(id,member_id);
        }
        return false;
    }

    @Override
    public boolean deleteAllShipAdress(Integer member_id) {
        boolean flag = false;
        if (shipAdressDao != null){
            flag = shipAdressDao.deleteShipAddress(member_id);
        }
        return false;
    }
}
