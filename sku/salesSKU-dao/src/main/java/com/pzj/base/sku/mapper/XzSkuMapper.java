package com.pzj.base.sku.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.sku.SkuQueryDto;
import com.pzj.base.sku.entity.XzSku;
import com.pzj.base.sku.entity.XzSkuExample;

@MyBatisDao
public interface XzSkuMapper extends BaseMapper<XzSku> {

    int countByExample(XzSkuExample example);

    int deleteByExample(XzSkuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XzSku record);

    int insertSelective(XzSku record);

    java.util.List<XzSku> selectByExample(XzSkuExample example);

    List<SkuQueryDto> selectByPage(SkuQueryDto skuQueryDto);

    int selectByPageCount(SkuQueryDto skuQueryDto);

    XzSku selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XzSku record, @Param("example") XzSkuExample example);

    int updateByExample(@Param("record") XzSku record, @Param("example") XzSkuExample example);

    int updateByPrimaryKeySelective(XzSku record);

    int updateByPrimaryKey(XzSku record);
}