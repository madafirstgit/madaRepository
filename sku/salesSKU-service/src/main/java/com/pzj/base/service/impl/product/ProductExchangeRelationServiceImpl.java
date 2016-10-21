package com.pzj.base.service.impl.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.entity.product.ProductExchangeRelation;
import com.pzj.base.service.product.IProductExchangeRelationService;

@Service
@Lazy
public class ProductExchangeRelationServiceImpl extends
                                                BaseServiceImpl<ProductExchangeRelation, com.pzj.base.product.IProductExchangeRelationMapper>
                                                implements IProductExchangeRelationService {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());
}
