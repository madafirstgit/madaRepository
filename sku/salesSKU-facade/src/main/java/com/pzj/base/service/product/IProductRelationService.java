package com.pzj.base.service.product;

import java.util.List;
import java.util.Map;

import com.pzj.base.common.BaseService;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.product.ProductDict;
import com.pzj.base.entity.product.ProductInfo;
import com.pzj.base.entity.product.ProductRelation;
import com.pzj.base.entity.product.ProductRelease;
import com.pzj.base.entity.product.ProductScenicAndSupplier;
import com.pzj.base.entity.query.ProductUser;

/**
 * 产品关系表
 * 
 * @author apple
 * 
 */
public interface IProductRelationService extends BaseService<ProductRelation> {

    int deleteByParam(ProductRelation param);

    /**
     * 增加返利积分规则
     * 
     * @param dict
     *            数据字典对象
     * @param contains
     *            产品id串
     */
    Long insert(ProductDict dict, String contains);

    /**
     * 更新返利积分规则
     * @param dict
     * @param contains
     * @return
     */
    Long update(ProductDict dict, String contains);

    /**
     * 根据objIds或relIds查询
     * 
     * @param ids
     * @return
     */
    List<ProductRelation> findByIdsMap(Map<String, Object> ids);

    /**
     * 查询返利积分规则列表
     * 
     * @param page
     * @param relat
     * @return 翻页列表
     */
    PageList<ProductRelation> queryPageByParams(PageModel page, ProductRelation relat);

    List<ProductRelation> queryListByParams(ProductRelation relat);

    // /**
    // * 通过obj_id集合 查询 关联的 rel_id去除重复的集合
    // *
    // * @param param
    // * @return
    // */
    // List<ProductRelation> queryRels(ProductRelation param);

    /**
     * 查询渠道的最高价格和最低价格
     * 
     * @param pager
     *            翻页对象
     * @param map
     *            渠道id集合
     * @return 翻页对象
     */
    PageList<Map<String, Object>> findMaxMin(PageModel pager, Map<String, Object> map);

    /**
     * 查询产品所含景区集合
     * 
     * @param productIdList
     *            产品id集合
     * @return
     */
    List<Map<String, Object>> findScenicByProductId(List<Long> productIdList);

    /**
     * 根据产品查询景区集合，结果已去重
     * 
     * @param productIdList
     *            产品id集合
     * @return
     */
    List<Map<String, Object>> findScenicByProduct(List<Long> productIdList, String status);

    // /**
    // * 查询产品的管理公司
    // *
    // * @param productIdList
    // * @return
    // */
    // List<Map<String, Object>> findProductSupplier(List<Long> productIdList);

    /**
     * 根据联票子票查询景区
     *
     * 查询的景区是业务上联票子票关联对方供应商的景区。
     *
     * @param productIds
     * @return
     */
    List<ProductScenicAndSupplier> queryPackageWithScenic(List<Long> productIds);

    List<Map<String, Object>> findScenicBySpotProductId(List<Long> productIdList);

    /**
     * 查询产品关联的供应商
     * <p/>
     * 目前的业务是创建联票子票时，要设置期望关联的供应商，此接口就是为了查询这些供应商的。
     * @param pu
     * @return
     */
    List<ProductUser> queryUserByProduct(ProductUser pu);
    
    /**
     * 更新产品与景区关系
     * @param supplierId 关系的提供者id
     * @param list 产品集合
     * @param scenicIds 景区id集合
     * @throws Exception
     */
    public void saveSkuAndScenicRelation(String supplierId, List<ProductRelease> list, List<Long> scenicIds) ;
    
    
    /**
     * 更新产品组与景区关系
     * @param supplierId 关系的提供者id
     * @param infoId 产品组id
     * @param scenicIds 景区id集合
     * @throws Exception
     */
    void saveSpuAndScenicRelation(ProductInfo info, String supplierId,
			List<Long> scenicIds) ;
    
    void saveSkuAndSiteDateRelation(String supplierId, List<ProductRelease> list, List<Long> siteRelations);
    
    
    /**
     * 根据景区id和产品组id集合获取产品组id集合
     * @param scenicIds 景区id集合
     * @param infoIds 产品组id集合
     * @return
     */
    List<Long> queryProductInfoIdsByScenicIds(List<Long> scenicIds,List<Long> infoIds);

    /**
     * 根据景区id集合获取产品id集合
     * @param scenicIds 景区id集合
     * @return
     */
    List<Long> queryProductIdsByScenicIds(List<Long> scenicIds);
    
    /**
     * 根据产品id获取景区id集合
     * @param productId 产品id
     * @return
     */
    List<Long> queryScenicIdByProductId(Long productId);
    
    
    
    /**
     * 根据产品组id集合获取产品组与景区关系
     * @param infoIds 产品组id集合
     * @return
     */
    List<ProductRelation> queryRelationByProductInfoIds(List<Long> infoIds);
    
    /**
     * 根据产品id获取景区id集合
     * @param productId 产品id
     * @return
     */
    List<Long> querySiteIdByProductId(Long productId);

}
