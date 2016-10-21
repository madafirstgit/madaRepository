package com.pzj.base.sku.mapper;

import org.apache.ibatis.annotations.Param;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.sku.entity.XzSkuAllocation;
import com.pzj.base.sku.entity.XzSkuAllocationExample;

@MyBatisDao
public interface XzSkuAllocationMapper extends BaseMapper<XzSkuAllocation> {

    int countByExample(XzSkuAllocationExample example);

    int deleteByExample(XzSkuAllocationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XzSkuAllocation record);

    int insertSelective(XzSkuAllocation record);

    java.util.List<XzSkuAllocation> selectByExample(XzSkuAllocationExample example);

    XzSkuAllocation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XzSkuAllocation record,
                                 @Param("example") XzSkuAllocationExample example);

    int updateByExample(@Param("record") XzSkuAllocation record,
                        @Param("example") XzSkuAllocationExample example);

    int updateByPrimaryKeySelective(XzSkuAllocation record);

    int updateByPrimaryKey(XzSkuAllocation record);
}