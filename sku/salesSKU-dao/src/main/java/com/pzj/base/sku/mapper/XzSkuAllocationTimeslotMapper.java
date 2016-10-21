package com.pzj.base.sku.mapper;

import org.apache.ibatis.annotations.Param;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.sku.entity.XzSkuAllocationTimeslot;
import com.pzj.base.sku.entity.XzSkuAllocationTimeslotExample;

@MyBatisDao
public interface XzSkuAllocationTimeslotMapper extends BaseMapper<XzSkuAllocationTimeslot> {

    int countByExample(XzSkuAllocationTimeslotExample example);

    int deleteByExample(XzSkuAllocationTimeslotExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XzSkuAllocationTimeslot record);

    int insertSelective(XzSkuAllocationTimeslot record);

    java.util.List<XzSkuAllocationTimeslot> selectByExample(XzSkuAllocationTimeslotExample example);

    XzSkuAllocationTimeslot selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XzSkuAllocationTimeslot record,
                                 @Param("example") XzSkuAllocationTimeslotExample example);

    int updateByExample(@Param("record") XzSkuAllocationTimeslot record,
                        @Param("example") XzSkuAllocationTimeslotExample example);

    int updateByPrimaryKeySelective(XzSkuAllocationTimeslot record);

    int updateByPrimaryKey(XzSkuAllocationTimeslot record);
}