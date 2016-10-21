package com.pzj.base.sku.mapper;

import org.apache.ibatis.annotations.Param;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.sku.entity.XzSkuPriceEventRules;
import com.pzj.base.sku.entity.XzSkuPriceEventRulesExample;

@MyBatisDao
public interface XzSkuPriceEventRulesMapper {
    /**
     * 根据公司ID查询价格事件规则
     * 
     * @param bossid
     * @return
     */
    //List<XzSkuPriceEventRules> selectListPriceEventRulesByBossId(Integer bossid);

    int countByExample(XzSkuPriceEventRulesExample example);

    int deleteByExample(XzSkuPriceEventRulesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(XzSkuPriceEventRules record);

    int insertSelective(XzSkuPriceEventRules record);

    java.util.List<XzSkuPriceEventRules> selectByExample(XzSkuPriceEventRulesExample example);

    XzSkuPriceEventRules selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") XzSkuPriceEventRules record,
                                 @Param("example") XzSkuPriceEventRulesExample example);

    int updateByExample(@Param("record") XzSkuPriceEventRules record,
                        @Param("example") XzSkuPriceEventRulesExample example);

    int updateByPrimaryKeySelective(XzSkuPriceEventRules record);

    int updateByPrimaryKeyAndBossId(XzSkuPriceEventRules record);
}