package com.takeaway.service;

import com.takeaway.pojo.ShipAddress;

import java.util.List;

/**
 * @author qzlzzz
 * 对修改关闭 对扩展开放 在修改时新增方法便可 无需改变原来的方法
 */
public interface ShipAdressService {
    /**
     * 用户操作:增加用户的送货地址
     * @param shipAddress
     * @return
     */
    ShipAddress addShipAdress(ShipAddress shipAddress);

    /**
     * 用户操作:更新地址信息
     * @param shipAddress
     * @return
     */
    boolean updateShipAdress(ShipAddress shipAddress);

    /**
     * 这里的Id不是主键ID 是用户Id
     * @param member_id
     * @return
     */
    List<ShipAddress> findAllShipAdressById(Integer member_id);

    /**
     * 删除用户单条的送货地址
     * @param member_id
     * @param id
     * @return
     */
    boolean deleteShipAdress(Integer member_id,Integer id);

    /**
     * 根据用户ID删除所有用户的送货地址
     * @param member_id
     * @return
     */
    boolean deleteAllShipAdress(Integer member_id);
}
