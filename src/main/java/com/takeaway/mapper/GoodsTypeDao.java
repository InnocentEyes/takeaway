package com.takeaway.mapper;

import com.takeaway.pojo.GoodType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author qzlzzz
 */
@Mapper
public interface GoodsTypeDao {
    /**
     * 管理员页面用:增加商品的类别
     * @param goodType
     * @return
     */
    boolean addGoodsType(GoodType goodType);

    /**
     * 管理员页面用:修改商品的信息
     * @param goodType
     * @return
     */
    boolean updateGoodsType(GoodType goodType);

    /**
     * 管理员页面用:查询所有父类别
     * @return
     */
    List<GoodType> findParentGoodsType();

    /**
     * 根据父类别编码查询所有子类别
     * @param parentNo
     * @return
     */
    List<GoodType> findChildGoodsTypeById(@Param("parentType") String parentType);


}
