/*
 * ProductReleaseMapper.java
 * 票之家科技有限公司
 * ------------------*
 * 2015-09-28 created
 */
package com.pzj.base.product;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.pzj.base.entity.product.ProductInfo;
import com.pzj.common.QueryPageModel;
import org.apache.ibatis.annotations.Param;

import com.pzj.base.common.BaseMapper;
import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.product.ProductRebateRule;
import com.pzj.base.entity.product.ProductRelease;
import com.pzj.base.entity.product.ProductScenic;
import com.pzj.base.entity.query.ProductUser;

/**
 * 产品发布关系
 * 
 * @author apple
 * 
 */
@MyBatisDao
public interface IProductReleaseMapper extends BaseMapper<ProductRelease> {

    /**
     * 根据供应商关系查询，通用分页
     * 
     * @param params
     * @return
     */
    List<ProductRelease> queryByUserRelation(Map<String, Object> params);

    /**
     * 根据供应商关系查询，通用分页查询总个数
     * 
     * @param params
     * @return
     */
    int countByUserRelation(Map<String, Object> params);

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
    List<ProductRelease> selectFrontProductOfRebate(ProductRebateRule rebateRule);

    List<ProductRelease> queryRelateProductList(Map<String, Object> params);

    int countRelateProductList(Map<String, Object> params);

    /**
     * 根据产品id集合、渠道id查询对应的产品id集合
     * 
     * @param params
     * @return
     */
    List<ProductRelease> selectProductIdWithChannelMF(Map<String, Object> params);

    int countProductIdWithChannelMF(Map<String, Object> params);

    /**
     * 查询关联的产品
     * 
     * @param param
     * @return
     */
    List<ProductRelease> findProductByIntegralId(Long param);

    /**
     * 查询产品Release信息，同时查询其Info信息。
     * <p/>
     * 当分页时，只对Release进行分页，不对Info分页。
     * 
     * @param param
     * @param page
     * @return
     */
    List<ProductRelease> selectReleaseAndInfoByParams(@Param("bParam") ProductRelease param,
                                                      @Param("page") PageModel page);

    /**
     * 统计产品Release总数
     * @param param 产品Release条件
     * @param productInfo 产品组Info条件
     * @return
     */
    int countReleaseAndInfoByInfoParams(@Param("bParam") ProductRelease param,  @Param("info") ProductInfo productInfo);

    /**
     * 查询产品Release信息，同时查询其Info信息。
     * @param param 产品Release条件
     * @param productInfo 产品组Info条件
     * @param page 分页参数
     * @return 产品Release信息，通过getProductInfo()可获取产品组信息
     */
    List<ProductRelease> selectReleaseAndInfoByInfoParams(@Param("bParam") ProductRelease param,  @Param("info") ProductInfo productInfo,
                                     @Param("page") QueryPageModel page);

    /**
     * 根据供应商查询联票与子票
     * 
     * @param param
     * @param page
     * @return
     */
    List<ProductRelease> selectComposeAndGeneralProduct(@Param("bParam") ProductRelease param,
                                                        @Param("page") PageModel page);

    /**
     * 合计根据供应商查询联票与子票数据总数，用于selectComposeAndGeneralProduct的分页统计
     * 
     * @param param
     * @return
     */
    int countComposeAndGeneralProduct(@Param("bParam") ProductRelease param);

    /**
     * 根据景区查询产品
     * <p/>
     * 目前只支付根据景区名称模糊查询。
     * 
     * @param param
     * @param scenic
     * @param page
     * @return
     */
    List<ProductRelease> selectProductByScenic(@Param("bParam") ProductRelease param,
                                               @Param("scenic") ProductScenic scenic,
                                               @Param("page") PageModel page);

    /**
     * 根据景区查询产品总数量
     * 
     * @param param
     * @param scenic
     * @return
     */
    int countProductByScenic(@Param("bParam") ProductRelease param,
                             @Param("scenic") ProductScenic scenic);

    /**
     * 禁用过期产品
     * 
     * @param date
     *            检查时间
     * @param page
     *            分页参数
     * @return
     */
    List<ProductRelease> selectDisableExpiredProducts(@Param("releasee") ProductRelease release,
                                                      @Param("date") Date date,
                                                      @Param("page") PageModel page);

    /**
     * 查询相同productId和productType的产品。
     * @param releaseList
     * @return
     */
    List<ProductRelease> selectDisableAllProducts(@Param("releaseList") List<ProductRelease> releaseList);

    /**************************************** psm的所有接口 ***********************************************/
    /**
     * 根据房型信息，房型房间信息，房型价格信息，房型违约金信息
     * 
     * @param param
     * @param page
     * @return
     */
    List<ProductRelease> selectListByAllParam(@Param("bParam") ProductRelease param,
                                              @Param("pParam") PageModel page);

    /**
     * 根据房型信息，房型房间信息，房型价格信息，房型违约金信息统计列表条数
     * 
     * @param param
     * @return
     */
    int countByAllParam(@Param("bParam") ProductRelease param);

    List<ProductUser> selectPorductWithCustomerForPmsManager(@Param("bParam") ProductRelease param,
                                                             @Param("pParam") PageModel page);

    int countPorductWithCustomerForPmsManager(@Param("bParam") ProductRelease param);

    List<ProductUser> selectPorductWithCustomerForPmsCheck(@Param("bParam") ProductRelease param,
                                                           @Param("pParam") PageModel page);

    int countPorductWithCustomerForPmsCheck(@Param("bParam") ProductRelease param);

    /**
     * 根据 供应商ID 分页查询
     * 
     * @param params
     * @return List<ProductRelease> 
     */
    List<ProductRelease> selectPage(Map<String, Object> params);

    /**
     * 根据 ProductRelease 分页查询，单表通用分页计数
     * 
     * @param release
     * @return int (总记录条数)
     */
    Integer countPage(@Param("item") ProductRelease item);

    /**************************************** psm的所有接口 ***********************************************/

    /**************************************** 通用产品接口start********************************************/
    /**
     * 根据skuId批量物理删除产品列表
     * @param skuIdList
     * @return
     */
    int deleteBatchSkuBySkuId(List<Long> skuIdList);

    /**
     * 根据skuId批量逻辑删除产品列表
     * @param skuIdList
     * @return
     */
    int logicDeletelBatchBySkuId(List<Long> skuIdList);

    /**************************************** 通用产品接口end********************************************/

    /**
     * app分页查询 根据景区id和票型查询产品列表
     * @param param
     * @param page
     * @return
     */
    List<ProductRelease> queryByScenic(@Param("bParam") ProductRelease param,
                                       @Param("page") PageModel page,
                                       @Param("ticketVarie") String ticketVarie);

    /**
     * app分页查询 根据景区id和票型查询产品列表
     * @param param
     * @param page
     * @return
     */
    int countByScenic(@Param("bParam") ProductRelease param, @Param("pParam") PageModel page,
                      @Param("ticketVarie") String ticketVarie);
    
    
    int updateBatchByInfoId(List<ProductRelease> entityList);


}