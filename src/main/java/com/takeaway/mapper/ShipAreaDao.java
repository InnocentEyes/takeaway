package com.takeaway.mapper;

import com.takeaway.pojo.ShipArea;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qzlzzz
 *  送货区域接口
 */
public interface ShipAreaDao {
    /**
     * 管理员操作:增加送货的区域
     * @param shipArea
     * @return
     */
    boolean addShipArea(ShipArea shipArea);

    /**
     * 管理员操作:修改送货区域的金钱或信息
     * @param shipArea
     * @return
     */
    boolean updateShipArea(ShipArea shipArea);

    /**
     * 管理员操作:删除送货的区域
     * @param shipArea_id
     * @return
     */
    boolean deleteShipArea(@Param("id") Integer shipArea_id);

    /**
     * 管理员操作：根据id查找送货区域
     * @param shipArea_id
     * @return
     */
    ShipArea findShipAreaById(@Param("id") Integer shipArea_id);


    /**
     * 管理员操作:查找所有的送货区域
     * @return
     */
    List<ShipArea> findAllShipArea();
}
