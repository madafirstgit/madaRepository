/*
 * ProductSalesToolMapper.java
 * 票之家科技有限公司
 * ------------------*
 * 2015-09-28 created
 */
package com.pzj.base.product;

import java.util.List;

import com.pzj.base.common.BaseMapper;
import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.product.ProductSalesTool;

/**
 * 直销工具
 * 
 * @author apple
 * 
 */
@MyBatisDao
public interface IProductSalesToolMapper extends BaseMapper<ProductSalesTool> {
    /**
     * <h3>查询供应商的直销工具</h3>
     * <p>
     * 查询供应商的直销工具，供应商名称保存在SalesToolVO的supplierName中，可设置toolNamse查询多个工具名称。
     * </p>
     * @param param
     * @return
     */
    public List<ProductSalesTool> findSalesToolsWithSupplier(ProductSalesTool param);
}