package com.pzj.base.sku.mapper;

import org.apache.ibatis.annotations.Param;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.sku.entity.XzSkuInventory;
import com.pzj.base.sku.entity.XzSkuInventoryExample;

@MyBatisDao
public interface XzSkuInventoryMapper {

    int countByExample(XzSkuInventoryExample example);

    int deleteByExample(XzSkuInventoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XzSkuInventory record);

    int insertSelective(XzSkuInventory record);

    java.util.List<XzSkuInventory> selectByExample(XzSkuInventoryExample example);

    XzSkuInventory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XzSkuInventory record,
                                 @Param("example") XzSkuInventoryExample example);

    int updateByExample(@Param("record") XzSkuInventory record,
                        @Param("example") XzSkuInventoryExample example);

    int updateByPrimaryKeySelective(XzSkuInventory record);

    int updateByPrimaryKey(XzSkuInventory record);
}