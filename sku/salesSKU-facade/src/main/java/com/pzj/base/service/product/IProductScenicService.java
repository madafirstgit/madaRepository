package com.pzj.base.service.product;

import java.util.List;
import java.util.Map;

import com.pzj.base.common.BaseService;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.product.ProductScenic;
import com.pzj.base.entity.product.ProductSiteData;
import com.pzj.product.vo.voParam.queryParam.AppSearchQuery;

public interface IProductScenicService extends BaseService<ProductScenic> {

	public Long insert(ProductScenic entity, List<ProductSiteData> relList);

	public int update(ProductScenic entity, List<ProductSiteData> relList);

	public List<ProductScenic> findByIdsMap(Map<String, List<Long>> idsMap);

	/**
	 * 根据传入的所属平台来查询其他平台的景区
	 * 
	 * @param source
	 * @return
	 */
	public List<ProductScenic> queryScenicWithOutParentId(Long parentId);

	public List<ProductScenic> queryScenicWithParentId(Long parentId);

	public PageList<ProductScenic> queryByParamMapWithRelation(PageModel pager,
			ProductScenic entity);

	/**
	 * 
	 * @param params
	 * @return
	 */
	public List<ProductScenic> queryListWithRelation(ProductScenic entity);
	/**
	 * 查询所有景区的省份
	 * @return 省份集合
	 */
	public List<String> queryAllProvices();
	
	/**
	 * 按照供应商id精确查询,再根据景区名称,供应商名称模糊查询景区列表
	 * @param localSupplierId 供应商ID
	 * @param scenicName 景区名称（支持模糊查询）
	 * @param supplierName 供应商名称（支持模糊查询）
	 * @return List<ProductScenic> 景区集合
	 */
	public List<ProductScenic> queryLikeScenics(Long localSupplierId,String scenicName ,String supplierName);

	/**
	 * 根据产品ID关系表查询景区
	 * @param scenic
	 * @param productId 产品id
	 * @return
	 */
	List<ProductScenic> queryScenicByProductId(ProductScenic scenic, Long productId);
	/**
	 * 根据查询关键字查询景区名称，景区省市县查询景区信息
	 * @param searchKey
	 * @param province
	 * @param city
	 * @param country
	 * @return
	 */
	List<ProductScenic> queryScenicsByAppSearchKey(AppSearchQuery query); 
	
	 /**
     * 根据产品id集合查询产品景区省市
     * @param productIds
     * @return
     */
    List<ProductScenic> findAddressByProductId(List<Long> productIds);
    
    
    /**
     * 根据景区名称全匹配查找景区
     * @param name
     * @return
     */
	List<ProductScenic> queryScenicsByName(String name); 
	

	
}
