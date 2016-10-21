package com.pzj.base.sku.mapper;

import org.apache.ibatis.annotations.Param;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.sku.entity.XzSkuAttr;
import com.pzj.base.sku.entity.XzSkuAttrExample;

@MyBatisDao
public interface XzSkuAttrMapper extends BaseMapper<XzSkuAttr> {

    XzSkuAttr selectByPrimaryKey(Integer id);

    int countByExample(XzSkuAttrExample example);

    int deleteByExample(XzSkuAttrExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XzSkuAttr record);

    int insertSelective(XzSkuAttr record);

    java.util.List<XzSkuAttr> selectByExample(XzSkuAttrExample example);

    int updateByExampleSelective(@Param("record") XzSkuAttr record,
                                 @Param("example") XzSkuAttrExample example);

    int updateByExample(@Param("record") XzSkuAttr record,
                        @Param("example") XzSkuAttrExample example);

    int updateByPrimaryKeySelective(XzSkuAttr record);

    int updateByPrimaryKey(XzSkuAttr record);

}