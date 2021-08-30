package com.takeaway.service.Impl;

import com.takeaway.mapper.ShipAreaDao;
import com.takeaway.service.ShipArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED,rollbackFor = {
        NullPointerException.class
})
public class ShipAreaImpl implements ShipArea {

    @Autowired
    private ShipAreaDao shipAreaDao;

    @Override
    public Float findAreaByAreaId(Integer area_id) {
        Float price = 0f;
        if (shipAreaDao != null){
            price = shipAreaDao.findShipAreaById(area_id).getCost();
        }
        return price;
    }
}
