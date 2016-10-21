package com.pzj.base.service.product;

import java.util.List;
import java.util.Map;

import com.pzj.base.common.BaseService;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.product.ProductScenicRelation;

public interface IProductScenicRelationService extends
		BaseService<ProductScenicRelation> {

	/**
	 * 查询关联id集合
	 * 
	 * @param param
	 * @return
	 */
	List<ProductScenicRelation> findByIdsMap(Map<String, Object> ids);

	/**
	 * 根据参数删除数据
	 * 
	 * @param param
	 * @return
	 */
	int deleteByParam(ProductScenicRelation param);

	void setRelationBatch(List<Long> scenicIdList, Long supplierId);

	void setRelationBatch(Long scenicId, List<Long> supplierIdList);

	public PageList<ProductScenicRelation> queryScenicRelationByParam(
			PageModel pager, ProductScenicRelation entity);
}
