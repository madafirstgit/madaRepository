package com.pzj.base.sku.mapper;

import org.apache.ibatis.annotations.Param;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.sku.entity.XzSkuPriceEvent;
import com.pzj.base.sku.entity.XzSkuPriceEventExample;

@MyBatisDao
public interface XzSkuPriceEventMapper extends BaseMapper<XzSkuPriceEvent> {

    int countByExample(XzSkuPriceEventExample example);

    int deleteByExample(XzSkuPriceEventExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XzSkuPriceEvent record);

    int insertSelective(XzSkuPriceEvent record);

    java.util.List<XzSkuPriceEvent> selectByExample(XzSkuPriceEventExample example);

    XzSkuPriceEvent selectByPrimaryKey(Integer id);

    //XzSkuPriceEvent selectPriceEventByName(String name);

    int updateByExampleSelective(@Param("record") XzSkuPriceEvent record,
                                 @Param("example") XzSkuPriceEventExample example);

    int updateByExample(@Param("record") XzSkuPriceEvent record,
                        @Param("example") XzSkuPriceEventExample example);

    int updateByPrimaryKeySelective(XzSkuPriceEvent record);

    int updateByPrimaryKeyAndBossId(XzSkuPriceEvent record);
}