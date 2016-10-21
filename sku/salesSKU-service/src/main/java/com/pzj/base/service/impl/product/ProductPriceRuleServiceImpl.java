/*
 * ProductPriceRuleService.java
 
 * www.piaozhijia.coim
 */
package com.pzj.base.service.impl.product;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.pzj.base.common.child.impl.BaseChildCommonServiceImpl;
import com.pzj.base.entity.product.pms.ProductPriceRule;
import com.pzj.base.service.product.IProductPriceRuleService;

/**
 * service接口实现.$ENTITY_NOTE$
 * 
 * @author 票之家
 */
@Service
@Lazy
public class ProductPriceRuleServiceImpl extends
                                         BaseChildCommonServiceImpl<ProductPriceRule, com.pzj.base.product.IProductPriceRuleMapper>
                                         implements IProductPriceRuleService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void setParentId(ProductPriceRule child, Long parentId) {
        if (child == null || parentId == null) {
            return;
        }
        child.setProductId(parentId);

    }

    @Override
    public List<ProductPriceRule> findByIdList(List<Long> idList) {
        if (idList == null || idList.isEmpty()) {
            return null;
        }
        ProductPriceRule param = new ProductPriceRule();
        param.setQueryIdList(idList);
        return findListByParams(param);
    }

    @Override
    public List<ProductPriceRule> findByParentIdList(List<Long> parentIdList) {
        if (parentIdList == null || parentIdList.isEmpty()) {
            return null;
        }
        ProductPriceRule param = new ProductPriceRule();
        param.setQueryParentIdList(parentIdList);
        return findListByParams(param);
    }

}
