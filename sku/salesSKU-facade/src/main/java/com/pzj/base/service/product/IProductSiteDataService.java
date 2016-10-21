package com.pzj.base.service.product;

import java.util.List;
import java.util.Map;

import com.pzj.base.common.BaseService;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.product.ProductRelation;
import com.pzj.base.entity.product.ProductSiteData;
import com.pzj.base.entity.product.ProductSiteRelation;

/**
 * 产品点位接口
 * 
 * @author apple
 * 
 */
public interface IProductSiteDataService extends BaseService<ProductSiteData> {

	/**
	 * 新增站点信息和数据的对应关系
	 * 
	 * @param site
	 * @param siteRelList
	 * @return
	 */
	public Long insert(ProductSiteData site, List<ProductRelation> siteRelList);

	/**
	 * 新增站点信息和数据的对应关系
	 * 
	 * @param site
	 * @param siteRelList
	 *            站点和设备、字典的对应关系
	 * @param scenicRel
	 *            和景区的对应关系
	 * @return
	 */
	public Long insert(ProductSiteData site, List<ProductRelation> siteRelList,
			List<ProductSiteData> siteList);

	/**
	 * 修改站点信息、从新维护和数据的对应关系
	 * 
	 * @param site
	 * @param siteRelList
	 * @return
	 */
	public int update(ProductSiteData site, List<ProductRelation> siteRelList);

	/**
	 * 修改站点信息、从新维护和数据的对应关系
	 * 
	 * @param site
	 * @param siteRelList
	 *            站点和设备、字典的对应关系
	 * @param scenicRel
	 *            和景区的对应关系
	 * @return
	 */
	public int update(ProductSiteData site, List<ProductRelation> siteRelList,
			List<ProductSiteData> siteList);

	/**
	 * 根据objId集合、relId集合、objType，relType查询
	 * 
	 * @param idsMap
	 * @return
	 */
	public List<ProductSiteData> findByIdsMap(Map<String, List<Long>> idsMap);

	/**
	 * 根据景区id集合查询
	 * 
	 * @param idsMap
	 * @return
	 */
	public List<ProductSiteData> findByScenicIdsMap(
			Map<String, List<Long>> idsMap);

	/**
	 * 重置和父对象的关系
	 * 
	 * @param parentId
	 * @return
	 */
	public int resetParentId(Long parentId);

	/**
	 * 根据父对象id集合查询
	 * 
	 * @param ids
	 * @return
	 */
	public List<ProductSiteData> findByParentIdsMap(Map<String, List<Long>> ids);

	public PageList<ProductSiteData> findWithScenic(PageModel pager,
			ProductSiteData entity);

	/**
	 * 根据景区和点位字段联合查询分页结果
	 * 
	 * @param params
	 * @return
	 */
	public List<ProductSiteData> queryWithScenic(Map<String, Object> params);

	/**
	 * 根据id集合联合景区表查询
	 * 
	 * @param ids
	 * @return
	 */
	List<ProductSiteData> findByIdsMapWithScenic(Map<String, List<Long>> ids);
	
	/**
	 * 根据mac查询检票设备所属景区入口下所有检票设备的检票次数总和
	 * @param mac
	 * @return
	 */
	public int getEntryCheckCountByMac(String mac);


	/**
	 * 根据景点、景点关系查询景点
	 * @param siteData 景点条件
	 * @param relation 景点关系条件
	 * @return
	 */
	List<ProductSiteData> querySiteDataByProductInfo(ProductSiteData siteData, ProductSiteRelation relation);
	
	
	/**
	 * 根据产品id获取产品关联的景点
	 * @param productId
	 * @return
	 */
	List<ProductSiteData>  findByProductId(Long productId);
}
