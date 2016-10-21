package com.pzj.base.sku.mapper;

import org.apache.ibatis.annotations.Param;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.sku.entity.XzSkuDyncProp;
import com.pzj.base.sku.entity.XzSkuDyncPropExample;

@MyBatisDao
public interface XzSkuDyncPropMapper {

    int countByExample(XzSkuDyncPropExample example);

    int deleteByExample(XzSkuDyncPropExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XzSkuDyncProp record);

    int insertSelective(XzSkuDyncProp record);

    java.util.List<XzSkuDyncProp> selectByExampleWithBLOBs(XzSkuDyncPropExample example);

    java.util.List<XzSkuDyncProp> selectByExample(XzSkuDyncPropExample example);

    XzSkuDyncProp selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XzSkuDyncProp record,
                                 @Param("example") XzSkuDyncPropExample example);

    int updateByExampleWithBLOBs(@Param("record") XzSkuDyncProp record,
                                 @Param("example") XzSkuDyncPropExample example);

    int updateByExample(@Param("record") XzSkuDyncProp record,
                        @Param("example") XzSkuDyncPropExample example);

    int updateByPrimaryKeySelective(XzSkuDyncProp record);

    int updateByPrimaryKeyWithBLOBs(XzSkuDyncProp record);

    int updateByPrimaryKey(XzSkuDyncProp record);
}