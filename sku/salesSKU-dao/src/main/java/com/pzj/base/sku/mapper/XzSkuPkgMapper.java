package com.pzj.base.sku.mapper;

import org.apache.ibatis.annotations.Param;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.sku.entity.XzSkuPkg;
import com.pzj.base.sku.entity.XzSkuPkgExample;

@MyBatisDao
public interface XzSkuPkgMapper extends BaseMapper<XzSkuPkg> {

    int countByExample(XzSkuPkgExample example);

    int deleteByExample(XzSkuPkgExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XzSkuPkg record);

    int insertSelective(XzSkuPkg record);

    java.util.List<XzSkuPkg> selectByExample(XzSkuPkgExample example);

    XzSkuPkg selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XzSkuPkg record,
                                 @Param("example") XzSkuPkgExample example);

    int updateByExample(@Param("record") XzSkuPkg record, @Param("example") XzSkuPkgExample example);

    int updateByPrimaryKeySelective(XzSkuPkg record);

    int updateByPrimaryKey(XzSkuPkg record);
}