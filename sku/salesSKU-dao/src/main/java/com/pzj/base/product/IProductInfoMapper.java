/*
 * ProductTicketInfoMapper.java
 * 票之家科技有限公司
 * ------------------*
 * 2015-09-28 created
 */
package com.pzj.base.product;

import com.pzj.base.common.BaseMapper;
import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.product.ProductInfo;
import com.pzj.base.entity.product.ProductScenic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 产品信息
 * 
 * @author apple
 * 
 */
@MyBatisDao
public interface IProductInfoMapper extends BaseMapper<ProductInfo> {
    List<ProductInfo> selectProductInfoByInfoScenic(@Param("info") ProductInfo info, @Param("scenic") ProductScenic scenic, PageModel pageModel);

    int countProductInfoByInfoScenic(@Param("info") ProductInfo info, @Param("scenic") ProductScenic scenic);

    List<ProductInfo> selectProductInfoWithReleaseByParam(@Param("info") ProductInfo info);

}