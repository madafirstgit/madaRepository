/*
 * ProductSiteRelationMapper.java
 
 * www.piaozhijia.coim
 */
package com.pzj.base.product;

import java.util.List;

import com.pzj.base.common.BaseMapper;
import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.product.ProductSiteRelation;

/**
 * Mapper接口.区域
 * @author 票之家
 */
@MyBatisDao
public interface IProductSiteRelationMapper extends BaseMapper<ProductSiteRelation> {

    Integer deleteBatchByParam(List<ProductSiteRelation> list);
}
