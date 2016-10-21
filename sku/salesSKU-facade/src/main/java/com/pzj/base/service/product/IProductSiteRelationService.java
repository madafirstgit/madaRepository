/*
 * ProductSiteRelationService.java
 
 * www.piaozhijia.coim
 */
package com.pzj.base.service.product;

import java.util.List;

import com.pzj.base.common.BaseService;
import com.pzj.base.entity.product.ProductInfo;
import com.pzj.base.entity.product.ProductSiteRelation;



/**
 * @Description:service接口.区域
 * @author: 票之家
 */
public interface IProductSiteRelationService extends BaseService<ProductSiteRelation>{
	
	/**
     * 更新产品组与景点关系
     * @param info 产品组信息
     * @param supplierId 关系的提供者id
     * @param scenicIds 景区id集合
     * @throws Exception
     */
	public void saveSkuAndSiteRelation(ProductInfo info, Long supplierId,List<ProductSiteRelation> siteList);
    
    Integer deleteBatchByParam(List<ProductSiteRelation> deleteRelationList);
}
