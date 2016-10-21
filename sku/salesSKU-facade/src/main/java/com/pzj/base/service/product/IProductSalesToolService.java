package com.pzj.base.service.product;

import java.util.List;

import com.pzj.base.common.BaseService;
import com.pzj.base.entity.product.ProductSalesTool;

/**
 * 直销工具接口
 * 
 * @author apple
 * 
 */
public interface IProductSalesToolService extends BaseService<ProductSalesTool> {
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
