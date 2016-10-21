/*
 * ProductRebateRuleService.java
 
 * www.piaozhijia.com
 */
package com.pzj.base.service.product;

import java.util.List;

import com.pzj.base.common.BaseService;
import com.pzj.base.entity.product.ProductRebateRule;
import com.pzj.base.entity.product.ProductRebateRuleRelation;

/**
 * @Description:service接口.加点返产品
 * @author: 票之家
 */
public interface IProductRebateRuleService extends
		BaseService<ProductRebateRule> {

	Long insert(ProductRebateRule rebateRule,
			List<ProductRebateRuleRelation> list);

}
