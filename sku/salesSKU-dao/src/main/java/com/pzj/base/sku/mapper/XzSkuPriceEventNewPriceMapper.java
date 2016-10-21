package com.pzj.base.sku.mapper;

import org.apache.ibatis.annotations.Param;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.sku.entity.XzSkuPriceEventNewPrice;
import com.pzj.base.sku.entity.XzSkuPriceEventNewPriceExample;

@MyBatisDao
public interface XzSkuPriceEventNewPriceMapper {

    int countByExample(XzSkuPriceEventNewPriceExample example);

    int deleteByExample(XzSkuPriceEventNewPriceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XzSkuPriceEventNewPrice record);

    int insertSelective(XzSkuPriceEventNewPrice record);

    java.util.List<XzSkuPriceEventNewPrice> selectByExample(XzSkuPriceEventNewPriceExample example);

    XzSkuPriceEventNewPrice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XzSkuPriceEventNewPrice record,
                                 @Param("example") XzSkuPriceEventNewPriceExample example);

    int updateByExample(@Param("record") XzSkuPriceEventNewPrice record,
                        @Param("example") XzSkuPriceEventNewPriceExample example);

    int updateByPrimaryKeySelective(XzSkuPriceEventNewPrice record);

    int updateByPrimaryKey(XzSkuPriceEventNewPrice record);
}