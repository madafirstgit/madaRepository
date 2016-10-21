package com.pzj.base.sku.mapper;

import org.apache.ibatis.annotations.Param;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.sku.entity.XzSkuImage;
import com.pzj.base.sku.entity.XzSkuImageExample;

@MyBatisDao
public interface XzSkuImageMapper extends BaseMapper<XzSkuImage> {

    int countByExample(XzSkuImageExample example);

    int deleteByExample(XzSkuImageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XzSkuImage record);

    int insertSelective(XzSkuImage record);

    java.util.List<XzSkuImage> selectByExample(XzSkuImageExample example);

    XzSkuImage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XzSkuImage record,
                                 @Param("example") XzSkuImageExample example);

    int updateByExample(@Param("record") XzSkuImage record,
                        @Param("example") XzSkuImageExample example);

    int updateByPrimaryKeySelective(XzSkuImage record);

    int updateByPrimaryKey(XzSkuImage record);
}