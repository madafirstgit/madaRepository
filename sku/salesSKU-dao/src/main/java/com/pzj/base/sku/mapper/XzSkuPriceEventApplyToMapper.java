package com.pzj.base.sku.mapper;

import org.apache.ibatis.annotations.Param;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.sku.entity.XzSkuPriceEventApplyTo;
import com.pzj.base.sku.entity.XzSkuPriceEventApplyToExample;

@MyBatisDao
public interface XzSkuPriceEventApplyToMapper extends BaseMapper<XzSkuPriceEventApplyTo> {

    int countByExample(XzSkuPriceEventApplyToExample example);

    int deleteByExample(XzSkuPriceEventApplyToExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XzSkuPriceEventApplyTo record);

    int insertSelective(XzSkuPriceEventApplyTo record);

    java.util.List<XzSkuPriceEventApplyTo> selectByExample(XzSkuPriceEventApplyToExample example);

    XzSkuPriceEventApplyTo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XzSkuPriceEventApplyTo record,
                                 @Param("example") XzSkuPriceEventApplyToExample example);

    int updateByExample(@Param("record") XzSkuPriceEventApplyTo record,
                        @Param("example") XzSkuPriceEventApplyToExample example);

    int updateByPrimaryKeySelective(XzSkuPriceEventApplyTo record);

    int updateByPrimaryKey(XzSkuPriceEventApplyTo record);
}