package com.pzj.base.sku.mapper;

import org.apache.ibatis.annotations.Param;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.sku.entity.XzSkuI18n;
import com.pzj.base.sku.entity.XzSkuI18nExample;

@MyBatisDao
public interface XzSkuI18nMapper extends BaseMapper<XzSkuI18n> {

    int countByExample(XzSkuI18nExample example);

    int deleteByExample(XzSkuI18nExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XzSkuI18n record);

    int insertSelective(XzSkuI18n record);

    java.util.List<XzSkuI18n> selectByExampleWithBLOBs(XzSkuI18nExample example);

    java.util.List<XzSkuI18n> selectByExample(XzSkuI18nExample example);

    XzSkuI18n selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XzSkuI18n record,
                                 @Param("example") XzSkuI18nExample example);

    int updateByExampleWithBLOBs(@Param("record") XzSkuI18n record,
                                 @Param("example") XzSkuI18nExample example);

    int updateByExample(@Param("record") XzSkuI18n record,
                        @Param("example") XzSkuI18nExample example);

    int updateByPrimaryKeySelective(XzSkuI18n record);

    int updateByPrimaryKeyWithBLOBs(XzSkuI18n record);

    int updateByPrimaryKey(XzSkuI18n record);
}