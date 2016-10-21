package com.pzj.base.service.impl.product;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.entity.product.ProductExchangeRelation;
import com.pzj.base.entity.product.ProductExchangeStrategy;
import com.pzj.base.product.IProductExchangeStrategyMapper;
import com.pzj.base.service.product.IProductExchangeRelationService;
import com.pzj.base.service.product.IProductExchangeStrategyService;

/**
 * service接口实现.退换票规则
 * 
 * @author 票之家
 */
@Service
@Lazy
public class ProductExchangeStrategyServiceImpl extends
                                                BaseServiceImpl<ProductExchangeStrategy, IProductExchangeStrategyMapper>
                                                implements IProductExchangeStrategyService {

    private Logger                          logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IProductExchangeRelationService productExchangeRelationService;

    public Long insert(ProductExchangeStrategy entity, List<ProductExchangeRelation> erList) {
        super.insert(entity);
        Long id = entity.getId();
        for (ProductExchangeRelation er : erList) {
            er.setObjId(id);
        }
        productExchangeRelationService.insertBatch(erList);
        return id;
    }
}
