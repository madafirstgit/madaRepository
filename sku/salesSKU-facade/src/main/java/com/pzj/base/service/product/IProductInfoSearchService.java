package com.pzj.base.service.product;

import java.util.List;

import com.pzj.base.entity.product.ProductInfo;
import com.pzj.base.entity.product.ProductRelease;
import com.pzj.common.QueryPageList;
import com.pzj.common.QueryPageModel;
import com.pzj.product.vo.product.SpuProduct;
import com.pzj.product.vo.voParam.queryParam.AppSearchQuery;
import com.pzj.product.vo.voParam.queryParam.SpuProductQuery;

public interface IProductInfoSearchService {
	/**
	 * 按照app端的查询参数和产品组通用查询参数分页查询产品组列表
	 * 
	 * @param pParam
	 *            分页对象
	 * @param queryParamj
	 *            产品组通用查询参数
	 * @param appSearchQuery
	 *            app端的查询参数
	 * @return
	 */
	QueryPageList<SpuProduct> queryPageByAppParam(QueryPageModel pParam,
			SpuProductQuery queryParamj, AppSearchQuery appSearchQuery,
			List<Long> spuIds) throws Exception;

	QueryPageList<SpuProduct> queryPageByCommonsParam(QueryPageModel pParam,
													  SpuProductQuery queryParam,
													  List<Long> spuIds) throws Exception;
	
	
	
	List<ProductInfo> findByAppParam(SpuProductQuery queryParam,
			AppSearchQuery appSearchQuery);
	
	

	/**
	 * 获取产品生成的hashCode唯一索引
	 * 
	 * @param hashCode
	 * @return
	 */
	List<Integer> queryHashCodeForUpdate(Integer hashCode);

	/**
	 * 根据通用供应端产品skuId查询产品组id
	 * 
	 * @param skuId
	 * @return
	 */
	List<Long> queryIdBySkuIdForUpdate(Long skuId);

	QueryPageList<ProductInfo> findSpuproductForSupplier(ProductInfo productInfo, ProductRelease productRelease, QueryPageModel pageModel);


	 /**
     * 根据产品id集合查询产品景区省市
     * @param productIds
     * @return
     */
    List<ProductInfo> findAddressByProductId(List<Long> productIds);
    
    /**
     * 通用查询：根据产品基础信息
     * @param productInfo
     * @return
     */
    List<ProductInfo> findListByParam(ProductInfo productInfo);
    
    /**
     * 根据产品组id集合查询产品组信息
     * @param ids
     * @return
     */
    List<ProductInfo> findListByIds(List<Long> ids);

}
