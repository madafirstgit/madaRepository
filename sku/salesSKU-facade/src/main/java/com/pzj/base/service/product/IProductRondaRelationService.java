/*
 * ProductRondaRelationService.java
 
 * www.piaozhijia.coim
 */
package com.pzj.base.service.product;

import java.util.List;
import java.util.Map;

import com.pzj.base.common.BaseService;
import com.pzj.base.entity.product.ProductRelease;
import com.pzj.base.entity.product.ProductRondaRelation;




/**
 * @Description:service接口.区域
 * @author: 票之家
 */
public interface IProductRondaRelationService extends BaseService<ProductRondaRelation>{
	public  void saveSkuAndRondaRelation(Map<ProductRelease, List<ProductRondaRelation>> rondaMap);
	
	/**
	 * 根据产品id获取产品与场次区域的对应关系
	 * @param productId
	 * @return
	 */
	List<ProductRondaRelation> queryPRondaRelationByProductId(Long productId);
}
