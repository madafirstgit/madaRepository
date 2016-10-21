package com.pzj.base.sku.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.sku.entity.XzSkuI18n;
import com.pzj.base.sku.entity.XzSkuPriceBase;
import com.pzj.base.sku.entity.XzSkuPriceBaseExample;
import com.pzj.base.sku.entity.XzSkuPriceEvent;
import com.pzj.base.sku.entity.XzSkuPriceEventExample;

@MyBatisDao
public interface XzSkuPriceBaseMapper extends BaseMapper<XzSkuPriceBase> {
    /**
     * 查询产品的价格，关联查询参数
     * 
     * @param skuId
     * @return
     */
    List<XzSkuPriceBase> selectListPrice(Integer skuId);

    //List<XzSkuPriceEvent> selectXzSkuPriceEventByskuIdAndMediaTable(Integer skuId, Integer eventApplyToId);

    /**
     * 删除产品价格
     * 
     * @param bossid
     * @param skuId
     * @param attrId
     * @return
     */
    int skuDeletetAttrPrice(@Param(value = "record") XzSkuPriceBase record);

    /**
     * 通用查询语言
     * 
     * @param record
     * @return List<XzSkuI18n>
     */
    List<XzSkuI18n> selectXzSkuI18ns(@Param(value = "record") XzSkuI18n record);

    /**
     * 通用查询语言
     * 
     * @param record
     * @return List<XzSkuI18n>
     */
    //List<XzSkuAttrI18n> selectXzSkuAttrI18ns(@Param(value = "record") XzSkuAttrI18n record);

    /** 原始方法 */

    List<XzSkuPriceBase> selectByExample(XzSkuPriceBaseExample example);

    List<XzSkuPriceEvent> selectByExample(XzSkuPriceEventExample example);

    Integer updateByPrimaryKeySelective(XzSkuPriceBase record);

    Integer insertSelective(XzSkuPriceBase record);

    Integer countByExample(XzSkuPriceBaseExample example);

    int deleteByExample(XzSkuPriceBaseExample example);
    /*
     * deleteByExample(XzSkuPriceBaseExample example); Integer
     * deleteByPrimaryKey(Integer id); Integer insert(XzSkuPriceBase record);
     * XzSkuPriceBase selectByPrimaryKey(Integer id); Integer
     * updateByExampleSelective(@Param("record") XzSkuPriceBase
     * record, @Param("example") XzSkuPriceBaseExample example); Integer
     * updateByExample(@Param("record") XzSkuPriceBase record, @Param("example")
     * XzSkuPriceBaseExample example); Integer updateByPrimaryKey(XzSkuPriceBase
     * record);
     */
}