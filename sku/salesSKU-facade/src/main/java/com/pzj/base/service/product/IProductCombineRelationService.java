/*
 * ProductCombineRelationService.java
 
 * www.piaozhijia.com
 */
package com.pzj.base.service.product;

import java.util.List;
import java.util.Map;

import com.pzj.base.common.BaseService;
import com.pzj.base.entity.product.ProductCombineRelation;
import com.pzj.base.entity.product.ProductRelease;

/**
 * @Description:service接口.组合产品和所包含的产品关系
 * @author: 票之家
 */
public interface IProductCombineRelationService extends BaseService<ProductCombineRelation>{
    
    List<ProductCombineRelation> findByIdsMap(Map<String, Object> ids);

    void deleteByProductId(Long productId);

    /**
     * 查询联票与子票的关系。
     * <p/>
     * 设置第一个参数ProductCombineRelation中的needProduct与needSubProduct，可以实现关联查询联票信息和子票信息。
     * @param relation
     * @param product
     * @param productSub
     * @return
     */
    List<ProductCombineRelation> queryJoinByParams(ProductCombineRelation relation, ProductRelease product, ProductRelease productSub);
}
