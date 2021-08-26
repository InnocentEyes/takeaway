package com.takeaway.service;

import com.takeaway.pojo.ShipAddress;

/**
 * @author qzlzzz
 */
public interface ShipAdressService {
    /**
     * 用户操作:增加用户的送货地址
     * @param shipAddress
     * @return
     */
    boolean addShipAdress(ShipAddress shipAddress);

    /**
     * 用户操作:更新地址信息
     * @param shipAddress
     * @return
     */
    @Deprecated
    boolean updateShipAdress(ShipAddress shipAddress);
}
