package com.pzj.base.sku.mapper;

import org.apache.ibatis.annotations.Param;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.sku.entity.XzSkuAttrApplyTo;
import com.pzj.base.sku.entity.XzSkuAttrApplyToExample;

@MyBatisDao
public interface XzSkuAttrApplyToMapper extends BaseMapper<XzSkuAttrApplyTo> {

    int countByExample(XzSkuAttrApplyToExample example);

    int deleteByExample(XzSkuAttrApplyToExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XzSkuAttrApplyTo record);

    int insertSelective(XzSkuAttrApplyTo record);

    java.util.List<XzSkuAttrApplyTo> selectByExample(XzSkuAttrApplyToExample example);

    XzSkuAttrApplyTo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XzSkuAttrApplyTo record,
                                 @Param("example") XzSkuAttrApplyToExample example);

    int updateByExample(@Param("record") XzSkuAttrApplyTo record,
                        @Param("example") XzSkuAttrApplyToExample example);

    int updateByPrimaryKeySelective(XzSkuAttrApplyTo record);

    int updateByPrimaryKey(XzSkuAttrApplyTo record);
}