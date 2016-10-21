/*
 * ProductBedMapper.java
 
 * www.piaozhijia.coim
 */
package com.pzj.base.product;

import org.apache.ibatis.annotations.Param;

import com.pzj.base.common.child.BaseChildCommonMapper;
import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.product.ProductRuleRel;

/**
 * @Author :DongChf
 * @Date :2016年6月5日
 * @Describe:
 */
@MyBatisDao
public interface IProductRuleRelMapper extends BaseChildCommonMapper<ProductRuleRel> {
    public Integer deleteByParams(@Param("bParam") ProductRuleRel rel);
}
