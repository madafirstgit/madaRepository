package com.pzj.base.sku.mapper;

import org.apache.ibatis.annotations.Param;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.sku.entity.XzSkuPkgAttrMapping;
import com.pzj.base.sku.entity.XzSkuPkgAttrMappingExample;

@MyBatisDao
public interface XzSkuPkgAttrMappingMapper {

    int countByExample(XzSkuPkgAttrMappingExample example);

    int deleteByExample(XzSkuPkgAttrMappingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XzSkuPkgAttrMapping record);

    int insertSelective(XzSkuPkgAttrMapping record);

    java.util.List<XzSkuPkgAttrMapping> selectByExample(XzSkuPkgAttrMappingExample example);

    XzSkuPkgAttrMapping selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XzSkuPkgAttrMapping record,
                                 @Param("example") XzSkuPkgAttrMappingExample example);

    int updateByExample(@Param("record") XzSkuPkgAttrMapping record,
                        @Param("example") XzSkuPkgAttrMappingExample example);

    int updateByPrimaryKeySelective(XzSkuPkgAttrMapping record);

    int updateByPrimaryKey(XzSkuPkgAttrMapping record);
}