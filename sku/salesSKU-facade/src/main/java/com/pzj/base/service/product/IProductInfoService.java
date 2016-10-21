package com.pzj.base.service.product;

import java.util.List;

import com.pzj.base.common.BaseService;
import com.pzj.base.common.utils.PageList;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.SysUser;
import com.pzj.base.entity.product.ProductCloseTimeslot;
import com.pzj.base.entity.product.ProductCombineRelation;
import com.pzj.base.entity.product.ProductInfo;
import com.pzj.base.entity.product.ProductRelease;
import com.pzj.base.entity.product.ProductScenic;
import com.pzj.base.entity.product.ProductSiteData;
import com.pzj.base.entity.product.ProductSiteRelation;

/**
 * 票产品信息表
 * 
 * @author apple
 * 
 */

public interface IProductInfoService extends BaseService<ProductInfo> {

    /**
     * 新增普通票产品
     */
    void saveProduct(List<ProductInfo> piList,
            List<ProductRelease> prList, List<ProductScenic> scenicList,List<ProductSiteData> scenicSpotList);

    /**
     * 新增普通票产品 返回ProductReleaseId集合
     *
     * @param piList
     * @param prList
     * @param scenicList 产品期望关联的景区，早期的需求是关联景区
     * @param scenicSpotList
     * @param userList 产品期望关联的供应商，新一期的需求（2016年01月时）是关联供应商
     * @return
     */
    List<Long> saveProductV2(List<ProductInfo> piList,
            List<ProductRelease> prList, List<ProductScenic> scenicList,List<ProductSiteData> scenicSpotList, List<SysUser> userList);


    /**
     * 创建联票，关联子票
     * @param info 联票的Info信息
     * @param relationList 联票与子票关联关系
     * @param releaseList 子票集合
     * @param composeRelease 联票的release信息
     * @return
     */
    Long insertCompose(ProductInfo info,
            List<ProductCombineRelation> relationList,
            List<ProductRelease> releaseList, ProductRelease composeRelease);


    /**
     * 创建组合票
     * @param info
     * @param compose
     * @param subs
     * @return
     */
    Long insertCompose(ProductInfo info, ProductRelease compose, List<ProductRelease> subs);

    /**
     * 根据景区ID、查询产品基本信息
     * @param info
     * @param scenic
     * @param page
     * @return
     */
    PageList<ProductInfo> findProductInfoByInfoScenic(ProductInfo info, ProductScenic scenic, PageModel page);

    /**
     * 根据产品参数，查询价格信息
     * @param info
     * @return
     */
    List<ProductInfo> findProductInfoWithReleaseByParam(ProductInfo info);
    
    /**
     * 批量更新产品组状态
     * @param flag 产品状态
     * @param ids 产品id集合
     * @return
     */
    Integer modifyProductInfoState(String flag,List<Long> ids);
    
    /**
     * 新建产品组及其关闭时间事件，产品信息
     * @param info 产品组信息
     * @param slotList 关闭时间事件
     * @param scenicList 景区信息
     * @param siteList 景点信息
     * @return
     */
    Long addProduct(ProductInfo info, List<ProductCloseTimeslot> slotList, List<Long> scenicList,List<ProductSiteRelation> siteList);
    
    /**
     * 更新产品组及其关闭时间事件，产品信息
     * @param info
     * @param prList
     * @param slotList
     * @return
     */
    Integer saveProduct(ProductInfo info, List<ProductCloseTimeslot> slotList,List<Long> scenicList,List<ProductSiteRelation> siteList);
    
    
    
   
    
   
    
}
