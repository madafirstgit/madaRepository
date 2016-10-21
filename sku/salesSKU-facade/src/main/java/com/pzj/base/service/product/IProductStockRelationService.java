/*
 * ProductStockRelationService.java
 
 * www.piaozhijia.coim
 */
package com.pzj.base.service.product;



import java.util.ArrayList;
import java.util.List;

import com.pzj.base.common.BaseService;
import com.pzj.base.entity.product.ProductRelease;
import com.pzj.base.entity.product.ProductStockRelation;
import com.pzj.core.stock.model.result.SkuStockRelationResult;
/**
 * @Description:service接口.区域
 * @author: 票之家
 */
public interface IProductStockRelationService extends BaseService<ProductStockRelation>{
	/**
	 * 根据库存id获取有效的产品id集合
	 * @param stockId 库存id
	 * @return
	 */
	List<Long> getValidProductIdsByStockId(Long stockId);
	
	/**
	 * 根据产品id获取有效的库存id集合
	 * @param productId 产品id
	 * @return
	 */
	List<Long> getValidStockIdsByProductId(Long productId);
	
	/**
	 * 根据库存id集合获取有效的库存产品关系
	 * @param stockIds 库存id集合
	 * @return
	 */
	ArrayList<SkuStockRelationResult> getValidRelationByStockIds(List<Long> stockIds);
	
	
	/**
	 * 根据产品id集合获取有效的库存产品关系
	 * @param productIds 产品id集合
	 * @return
	 */
	List<SkuStockRelationResult> getValidRelationByProductIds(List<Long> productIds);
	
	/**
	 * 新建产品与库存规则关系
	 * @param list 产品集合
	 */
	void addSkuAndStockRelation(List<ProductRelease> list);
	
	/**
	 * 新建产品与库存规则关系
	 * @param pr 产品
	 */
	void addSkuAndStockRelation(ProductRelease pr);
}
