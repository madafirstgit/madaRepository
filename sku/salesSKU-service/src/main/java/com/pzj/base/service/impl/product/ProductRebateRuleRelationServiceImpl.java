/*
 * ProductRebateRuleRelationService.java
 
 * www.piaozhijia.com
 */
package com.pzj.base.service.impl.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.entity.product.ProductRebateRuleRelation;
import com.pzj.base.product.IProductRebateRuleRelationMapper;
import com.pzj.base.service.product.IProductRebateRuleRelationService;

/**
 * service接口实现.加点返产品关联类
 * 
 * @author 票之家
 */
@Service
@Lazy
public class ProductRebateRuleRelationServiceImpl extends
                                                  BaseServiceImpl<ProductRebateRuleRelation, IProductRebateRuleRelationMapper>
                                                  implements IProductRebateRuleRelationService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

}
