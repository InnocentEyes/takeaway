package com.takeaway.service;

import com.takeaway.mapper.MemberMapper;
import com.takeaway.mapper.ShipAddressDao;
import com.takeaway.pojo.ShipAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipAdressServiceImpl implements ShipAdressService {

    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private ShipAddressDao shipAdressDao;

    @Override
    public boolean addShipAdress(ShipAddress shipAddress) {
        boolean flag = false;
        if (shipAdressDao != null && memberMapper != null){
            /*这里需要加一个条件判断 判断areaId是不是0 或者 1呢*/
            if (memberMapper.findById(shipAddress.getMemberId()) != null){
                if (shipAddress.getAreaId() == 0 || shipAddress.getAreaId() == 1){
                    flag = shipAdressDao.addShipAddress(shipAddress);
                }
            }
        }
        return flag;
    }

    @Override
    public boolean updateShipAdress(ShipAddress shipAddress) {
        boolean flag = false;
        if (shipAddress != null && memberMapper != null){
            flag = shipAdressDao.updateShipAddress(shipAddress);
        }
        return flag;
    }
}
