package com.pzj.base.sku.mapper;

import org.apache.ibatis.annotations.Param;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.sku.entity.XzSkuAttrI18n;
import com.pzj.base.sku.entity.XzSkuAttrI18nExample;

@MyBatisDao
public interface XzSkuAttrI18nMapper extends BaseMapper<XzSkuAttrI18n> {

    int countByExample(XzSkuAttrI18nExample example);

    int deleteByExample(XzSkuAttrI18nExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XzSkuAttrI18n record);

    int insertSelective(XzSkuAttrI18n record);

    java.util.List<XzSkuAttrI18n> selectByExample(XzSkuAttrI18nExample example);

    XzSkuAttrI18n selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XzSkuAttrI18n record,
                                 @Param("example") XzSkuAttrI18nExample example);

    int updateByExample(@Param("record") XzSkuAttrI18n record,
                        @Param("example") XzSkuAttrI18nExample example);

    int updateByPrimaryKeySelective(XzSkuAttrI18n record);

    int updateByPrimaryKey(XzSkuAttrI18n record);
}