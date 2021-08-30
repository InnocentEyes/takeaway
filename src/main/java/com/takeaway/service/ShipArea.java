package com.takeaway.service;

/**
 * @author qzlzzz
 */
public interface ShipArea {

    /**
     * 根据区域的id查找送往该区域的价钱
     * @param area_id 区域的id
     * @return 区域的价钱
     */
    Float findAreaByAreaId(Integer area_id);
}
