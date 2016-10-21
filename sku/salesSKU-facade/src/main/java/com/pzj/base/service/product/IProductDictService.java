package com.pzj.base.service.product;

import java.util.List;
import java.util.Map;

import com.pzj.base.common.BaseService;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.product.ProductDict;
import com.pzj.base.entity.product.ProductRelease;
import com.pzj.base.entity.product.ProductRulesIntegral;

/**
 * 产品字典信息接口定义
 * 
 * @author apple
 * 
 */
public interface IProductDictService extends BaseService<ProductDict> {

	ProductDict insertDict(ProductDict productDict);

	List<ProductDict> findByIdsMap(Map<String, List<Long>> ids);

	Long queryMaxVal(String type);

	PageList<ProductRulesIntegral> findListAndProductByParams(ProductDict dict, ProductRelease release, PageModel page);

	List<ProductRulesIntegral> findProductOfRulesIntegralByParams(List<Long> ruleIds);
}
