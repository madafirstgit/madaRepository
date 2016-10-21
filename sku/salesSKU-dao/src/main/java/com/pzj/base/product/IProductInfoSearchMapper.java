/*
 * ProductTicketInfoMapper.java
 * 票之家科技有限公司
 * ------------------*
 * 2015-09-28 created
 */
package com.pzj.base.product;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.product.ProductInfo;
import com.pzj.base.entity.product.ProductRelease;
import com.pzj.common.QueryPageModel;

/**
 * 产品信息
 * 
 * @author apple
 * 
 */
@MyBatisDao
public interface IProductInfoSearchMapper {
    List<ProductInfo> selectProductInfoByAppSearchKey(@Param("info") ProductInfo info,@Param("pParam") QueryPageModel pageModel);

    int countProductInfoByAppSearchKey(@Param("info") ProductInfo info);
    
    List<Integer> selectHashCodeForUpdate(Integer hashCode);
    
    List<Long> selectIdBySkuIdForUpdate(@Param("skuId") Long skuId);

    List<ProductInfo> selectSpuproductForSupplier(@Param("info") ProductInfo info, @Param("bParam") ProductRelease release, @Param("pParam") QueryPageModel pageModel);
    int countSpuproductForSupplier(@Param("info") ProductInfo info, @Param("bParam") ProductRelease release);

    /**
     * 根据产品id获取产品景区的省市
     * @param productIds
     * @return
     */
    List<ProductInfo> selectAddressByProductId(@Param("productIds")List<Long> productIds);
    
    /**
     * 通用查询:根据产品组的信息查询
     * @param info
     * @param pageModel
     * @return
     */
    List<ProductInfo> queryByParamMap(@Param("info")ProductInfo info, @Param("pParam") QueryPageModel pageModel);
    
    int countByParamMap(@Param("info")ProductInfo info);
    
    
    
    List<ProductInfo> selectByScenicAppSearchKey(@Param("infoIds")List<Long> infoIds, @Param("scenicIds")List<Long> scenicIds);

}