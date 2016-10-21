/**
 * 
 */
package com.pzj.base.service.product;

import java.util.List;

import com.pzj.base.common.BaseService;
import com.pzj.base.entity.product.ProductRuleRel;

/**
 * @Author :DongChf
 * @Date :2016年6月5日
 * @Describe:
 */
public interface IProductRuleRelService extends BaseService<ProductRuleRel> {
	public List<Long> getRuleIdList(List<ProductRuleRel> voList);

}
