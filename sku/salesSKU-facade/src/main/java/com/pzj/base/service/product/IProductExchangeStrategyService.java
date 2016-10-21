/*
 * ProductExchangeStrategyService.java
 
 * www.piaozhijia.com
 */
package com.pzj.base.service.product;

import java.util.List;

import com.pzj.base.common.BaseService;
import com.pzj.base.entity.product.ProductExchangeRelation;
import com.pzj.base.entity.product.ProductExchangeStrategy;

/**
 * @Description:service接口.退换票规则
 * @author: 票之家
 */
public interface IProductExchangeStrategyService extends
		BaseService<ProductExchangeStrategy> {

	Long insert(ProductExchangeStrategy entity,
			List<ProductExchangeRelation> erList);
}
