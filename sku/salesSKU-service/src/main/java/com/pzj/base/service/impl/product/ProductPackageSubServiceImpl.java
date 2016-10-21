/*
 * ProductPackageSubService.java
 
 * www.piaozhijia.com
 */
package com.pzj.base.service.impl.product;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.pzj.base.common.impl.BaseServiceImpl;
import com.pzj.base.entity.product.ProductPackageSub;

import com.pzj.base.product.IProductPackageSubMapper;
import com.pzj.base.service.product.IProductPackageSubService;

/**
 * service接口实现.联票子票从
 * @author 票之家
 */
@Service
@Lazy
public class ProductPackageSubServiceImpl extends
                                          BaseServiceImpl<ProductPackageSub, IProductPackageSubMapper>
                                          implements IProductPackageSubService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<ProductPackageSub> findByParentIdList(List<Long> ids) {
        return mapper.findByParentIdList(ids);
    }

    @Override
    public List<ProductPackageSub> findByIdList(List<Long> ids) {
        return mapper.findByIdList(ids);
    }
}
