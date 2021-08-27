package com.takeaway.mapper;

import com.takeaway.pojo.ShipAddress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qzlzzz
 */
public interface ShipAddressDao {
    /**
     * 用户操作:增加用户的送货地址
     * @param shipAddress
     * @return
     */
    boolean addShipAddress(ShipAddress shipAddress);

    /**
     * 用户操作:更改用户的送货地址
     * @param shipAddress
     * @return
     */
    boolean updateShipAddress(ShipAddress shipAddress);

    /**
     * 用户操作:删除用户所有的送货地址
     * @param memeber_id
     * @return
     */
    boolean deleteShipAddress(@Param("id") Integer memeber_id);

    /**
     * 删除用户单条送货地址
     * @param id
     * @param member_id
     * @return
     */
    boolean deleteShipAddressById(@Param("id") Integer id,@Param("memberid") Integer member_id);

    /**
     * 管理员操作:根据id查找用户所有的送货地址
     * @param member_id
     * @return
     */
    List<ShipAddress> findShipAddressById(@Param("id") Integer member_id);

    /**
     * 管理员操作/用户操作:根据用户的id设置所有的Default为0
     * @param member_id
     * @return
     */
    @Deprecated
    boolean clearDefaultAddress(@Param("id") Integer member_id);

}
