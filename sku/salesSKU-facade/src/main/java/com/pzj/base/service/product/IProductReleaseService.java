package com.pzj.base.service.product;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.pzj.base.common.BaseService;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysChannelStrategy;
import com.pzj.base.entity.product.ProductInfo;
import com.pzj.base.entity.product.ProductRebateRule;
import com.pzj.base.entity.product.ProductRelease;
import com.pzj.base.entity.product.ProductRondaRelation;
import com.pzj.base.entity.product.ProductScenic;
import com.pzj.base.entity.query.ProductUser;
import com.pzj.common.QueryPageList;
import com.pzj.common.QueryPageModel;

import javax.management.Query;

/**
 * 产品发布关系
 * 
 * @author apple
 * 
 */
public interface IProductReleaseService extends BaseService<ProductRelease> {
	
	/**
	 * 通过产品组id更新产品信息
	 * @param entityList
	 * @return
	 */
	Integer updateBatchByInfoId(List<ProductRelease> entityList);

    /**
     * 更新产品Release和关联的Info
     * 
     * @param release
     * @param productInfo
     */
    void updateReleaseAndInfo(ProductRelease release, ProductInfo productInfo);

    /**
     * 调整价格
     * 
     * @param productId
     * @param newPrice
     * @return
     */
    @Deprecated
    Long adjustPrice(Long productId, Double newPrice, Double retailPrice, Double mfPrice);

    /**
     * 
     * @param params
     * @return
     */
    List<ProductRelease> queryByUserRelation(Map<String, Object> params);

    /**
     * 根据产品ID，查询被关联的供应商的产品信息。
     * 
     * 本查询用于加点返产品关联模块。
     * 
     * 业务上，本企业的加点返产品能与多个前置供应商的多个产品关联， 所以本查询查的就是被关联的产品信息。
     * 
     * productId指的是业务是本企业的产品ID，返回的是前置供应商的产品。
     * 
     * @param rebateRule
     * @return
     */
    List<ProductRelease> queryFrontProductOfRebate(ProductRebateRule rebateRule);

    /**
     * 分页查询共享给指定供应商的茶品
     * 
     * @param pager
     * @param release
     * @return
     */
    PageList<ProductRelease> queryPageByUserRelation(PageModel pager, ProductRelease release);

    /**
     * 根据联票子票的id查询能进行组合的产品列表
     * 
     * @param pager
     * @param param
     * @return
     */
    PageList<ProductRelease> queryRelateList(PageModel pager, ProductRelease param);

    /**
     * 根据产品id集合、渠道id查询对应的产品分页集合
     * 
     * @param channelIds
     * @param pager
     * @param param
     * @return
     */
    PageList<ProductRelease> queryProductWithChannelMF(List<Long> channelIds, PageModel pager,
                                                       ProductRelease param,
                                                       SysChannelStrategy strategy);

    /**
     * 根据积分规则id查询产品
     * 
     * @param integralId
     * @return
     */
    List<ProductRelease> findProductByIntegralId(Long integralId);

    /**
     * 查询产品Release信息，同时查询其Info信息。
     * <p/>
     * 分页只对Release进行分页，不对Info分页。
     * 
     * @param param
     * @param page
     * @return
     */
    PageList<ProductRelease> findReleaseAndInfoByParams(ProductRelease param, PageModel page);

    /**
     * 查询产品Release信息，同时查询其Info信息。
     * 
     * @param param
     * @return
     */
    List<ProductRelease> findReleaseAndInfoByParams(ProductRelease param);

    /**
     * 根据供应商查询联票与子票
     * 
     * @param param
     * @param page
     * @return
     */
    PageList<ProductRelease> queryComposeAndGeneralProduct(ProductRelease param, PageModel page);

    /**
     * 根据景区查询产品
     * <p/>
     * 目前只支持对景区名称模糊查询。
     * 
     * @param param
     * @param scenic
     * @param page
     * @return
     */
    PageList<ProductRelease> queryProductByScenic(ProductRelease param, ProductScenic scenic,
                                                  PageModel page);

    /***** pms产品新加接口 start *************************************************************************/
    /**
     * 批量创建或更新房型信息,同时返回房型列表(为了API获取ID)
     * 
     * @param prList
     * @return
     */
    @Deprecated
    public List<ProductRelease> insertOrUpdateBatchAndAuthHaveID(List<ProductRelease> prList);

    /**
     * 批量创建或更新房型信息
     * 
     * @param prList
     * @return
     */
    @Deprecated
    Long insertOrUpdateBatchAndAuthForPMS(List<ProductRelease> prList);

    /**
     * 查询房型信息
     * 
     * @param pager
     * @param vo
     * @return
     */
    @Deprecated
    PageList queryByAllParamForPMS(PageModel pager, ProductRelease vo);

    /***** pms产品新加接口 end ***************************************************************************/

    /**
     * 查询过期的，可以被禁用的产品
     * @param date
     * @param pager
     * @return
     */
    PageList<ProductRelease> queryDisableExpiredProducts(ProductRelease release, Date date,
                                                         PageModel pager);

    /**
     * 启用产品，禁用其它相同productId和productType的产品。
     * @param ids
     * @return
     */
    Integer enableProducts(List<Long> ids, String newflag, String otherFlag);

    @Deprecated
    PageList<ProductUser> findProductWithCustomerForPmsManager(ProductRelease release,
                                                               PageModel page);

    @Deprecated
    PageList<ProductUser> findProductWithCustomerForPmsCheck(ProductRelease release, PageModel page);

    /**
     * 根据 ProductRelease 分页查询，单表通用分页
     * 
     * @param release
     * @return List<ProductRelease> 
     */
    PageList<ProductRelease> queryPage(ProductRelease release, PageModel page);
    
    
    /**
	 * 判断产品是否可退 
	 * @param productIds 产品id集合
	 * @param playDate 游玩或演出开始时间
	 * @param playEndDate 演出结束时间
	 * @param refundDate 退款时间
	 * @param mustRufundAllFlag   如果为true，则判断产品列表中有一个不能退，则productIds中的所有都不能退。如果为false，则只根据退款规则判断每个产品是否可退
	 * @return
	 */
	Map<Long, Boolean> isCanRefund(List<Long> productIds, Date playDate, Date playEndDate, Date refundDate, boolean mustRufundAllFlag);

	
	Integer countReleaseAndInfoByInfoParams(ProductRelease releaseParam, ProductInfo productInfoParam);
	
	List<ProductRelease> findReleaseAndInfoByInfoParams(ProductRelease releaseParam, ProductInfo productInfoParam);

	QueryPageList<ProductRelease> findReleaseAndInfoByInfoParams(ProductRelease releaseParam, ProductInfo productInfoParam, QueryPageModel queryPageModel);


	 /**
     * 根据产品组id批量更新产品状态
     * @param flag 产品状态
     * @param ids 产品id集合
     * @return
     */
    Integer modifyProductReleaseState(String flag,List<Long> ids);
    
    /**
     * 根据产品id批量更新产品状态
     * @param flag 产品状态
     * @param ids 产品id集合
     * @return
     */
    Integer modifyPReleaseStateById(String flag,List<Long> ids);
    
    /**
     * 根据产品id更新产品状态
     * @param flag 产品状态
     * @param ids 产品id集合
     * @return
     */
    Integer modifyPReleaseStateById(String flag, Long id);
    
    
    /**
     * 新建产品与景区，景点，场次区域的关系
     * @param prList
     * @param rondaRelation
     * @param scenicIds
     * @param siteList
     * @return
     */
    Long addProduct(ProductRelease pr,List<ProductRondaRelation> rondaRelation,List<Long> scenicIds,List<Long> siteList);
    
    
    /**
     * 新建产品与景区，景点，场次区域的关系
     * @param prList  产品 
     * @param rondaRelation 场次区域关系
     * @param scenicIds 景区信息
     * @param siteList  景点信息
     * @return
     */
    Long addProduct(List<ProductRelease> prList,
    		Map<ProductRelease, List<ProductRondaRelation>> rondaRelation,List<Long> scenicIds,List<Long> siteList);
    
    
    /**
     * 更新产品信息，更新产品与景区，景点，场次区域的关系
     * @param pr 
     * @param rondaRelation
     * @param scenicIds
     * @param siteList
     * @return
     */
    Integer saveProduct(ProductRelease pr,List<ProductRondaRelation> rondaRelation,List<Long> scenicIds,List<Long> siteList);
    
    
    /**
     * 批量更新产品信息，更新产品与景区，景点，场次区域的关系
     * @param prList  产品 
     * @param rondaRelation 场次区域关系
     * @param scenicIds 景区信息
     * @param siteList  景点信息
     * @return
     */
    Integer saveProduct(List<ProductRelease> prList,
    		Map<ProductRelease, List<ProductRondaRelation>> rondaRelation,List<Long> scenicIds,List<Long> siteList);

    
    


}
