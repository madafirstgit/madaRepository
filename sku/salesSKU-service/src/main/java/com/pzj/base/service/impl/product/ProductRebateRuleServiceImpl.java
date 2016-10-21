/*
 * ProductRebateRuleService.java
 
 * www.piaozhijia.com
 */
package com.pzj.base.service.impl.product;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.entity.product.ProductRebateRule;
import com.pzj.base.entity.product.ProductRebateRuleRelation;
import com.pzj.base.product.IProductRebateRuleMapper;
import com.pzj.base.service.product.IProductRebateRuleRelationService;
import com.pzj.base.service.product.IProductRebateRuleService;

/**
 * service接口实现.加点返产品
 * 
 * @author 票之家
 */
@Service
@Lazy
public class ProductRebateRuleServiceImpl extends
                                          BaseServiceImpl<ProductRebateRule, IProductRebateRuleMapper>
                                          implements IProductRebateRuleService {

    private Logger                            logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IProductRebateRuleRelationService productRebateRuleRelationService;

    public Long insert(ProductRebateRule rebateRule, List<ProductRebateRuleRelation> list) {
        super.insert(rebateRule);
        Long id = rebateRule.getId();
        for (ProductRebateRuleRelation pr : list) {
            pr.setRebateRuleId(id);
        }
        productRebateRuleRelationService.insertBatch(list);
        return id;
    }
}
