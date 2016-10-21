/*
 * ProductCombineRelationService.java
 
 * www.piaozhijia.com
 */
package com.pzj.base.service.impl.product;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.entity.product.ProductCombineRelation;
import com.pzj.base.entity.product.ProductRelease;
import com.pzj.base.product.IProductCombineRelationMapper;
import com.pzj.base.service.product.IProductCombineRelationService;

/**
 * service接口实现.组合产品和所包含的产品关系
 * @author 票之家
 */
@Service(value = "productCombineRelationServiceImpl")
@Lazy
public class ProductCombineRelationServiceImpl extends
                                               BaseServiceImpl<ProductCombineRelation, IProductCombineRelationMapper>
                                               implements IProductCombineRelationService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<ProductCombineRelation> findByIdsMap(Map<String, Object> ids) {
        return mapper.findByIdsMap(ids);
    }

    @Override
    public void deleteByProductId(Long productId) {
        mapper.deleteByProductId(productId);
    }

    @Override
    public List<ProductCombineRelation> queryJoinByParams(ProductCombineRelation relation,
                                                          ProductRelease product,
                                                          ProductRelease productSub) {
        return mapper.selectJoinByParams(relation, product, productSub);

    }
}
