package com.pzj.base.service.product;

import java.util.List;

import com.pzj.base.entity.product.ProductRelease;
import com.pzj.common.QueryPageList;
import com.pzj.common.QueryPageModel;
import com.pzj.core.stock.model.result.SkuStockRelationResult;
import com.pzj.core.stock.model.result.SkuStockResult;
import com.pzj.product.vo.product.SkuProduct;
import com.pzj.product.vo.voParam.queryParam.SkuProductQuery;

public interface IProductReleaseSearchService {
	
	/**
	 * 根据id获取产品信息
	 * @param id
	 * @return
	 */
	ProductRelease findById(Long id);
	
	/**
	 * 根据产品公共参数信息查询产品列表
	 * @param queryParam
	 * @return
	 */
	List<SkuProduct> queryByParam(SkuProductQuery queryParam)throws Exception;
	
	/**
	 * 根据产品公共参数信息查询产品列表
	 * @param queryParam
	 * @return
	 */
	List<ProductRelease> queryByParam(ProductRelease bParam);
	
	/**
	 * 根据产品公共参数信息和产品id列表集合交集取产品列表
	 * @param queryParam
	 * @return
	 */
	List<SkuProduct> queryByParam(SkuProductQuery queryParam, List<Long> skuIds)throws Exception;
	

	/**
	 * 根据产品公共参数信息分页查询产品列表
	 * @param queryParam
	 * @param pageModel
	 * @return
	 */
	QueryPageList<SkuProduct> queryPageByParam(SkuProductQuery bParam,
			QueryPageModel pParam)throws Exception;
	
	
	/**
	 * 根据产品库存关系集合获取有效的产品集合
	 * @param relations 产品库存关系
	 * @return
	 */
	List<SkuStockResult> findValidSkuByRelations(List<SkuStockRelationResult> relations);
	
	

	
	

}
