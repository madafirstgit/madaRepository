/*
 * ProductDictMapper.java
 * 票之家科技有限公司
 * ------------------*
 * 2015-09-28 created
 */
package com.pzj.base.product;

import com.pzj.base.common.BaseMapper;
import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.product.ProductExchangeRelation;

/**
 * 产品字典表
 * 
 * @author apple
 * 
 */
@MyBatisDao
public interface IProductExchangeRelationMapper extends BaseMapper<ProductExchangeRelation> {

}