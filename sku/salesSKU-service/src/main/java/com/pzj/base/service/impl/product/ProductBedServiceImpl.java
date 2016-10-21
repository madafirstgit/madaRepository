/*
 * ProductBedService.java
 
 * www.piaozhijia.coim
 */
package com.pzj.base.service.impl.product;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.pzj.base.common.child.impl.BaseChildCommonServiceImpl;
import com.pzj.base.entity.product.pms.ProductBed;
import com.pzj.base.product.IProductBedMapper;
import com.pzj.base.service.product.IProductBedService;

/**
 * service接口实现.$ENTITY_NOTE$
 * 
 * @author 票之家
 */
@Service
@Lazy
public class ProductBedServiceImpl extends BaseChildCommonServiceImpl<ProductBed, IProductBedMapper>
                                   implements IProductBedService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void setParentId(ProductBed child, Long parentId) {
        if (child == null || parentId == null) {
            return;
        }
        child.setProductReleaseId(parentId);

    }

    @Override
    public List<ProductBed> findByIdList(List<Long> idList) {
        if (idList == null || idList.isEmpty()) {
            return null;
        }
        ProductBed param = new ProductBed();
        param.setQueryIdList(idList);
        return findListByParams(param);
    }

    @Override
    public List<ProductBed> findByParentIdList(List<Long> parentIdList) {
        if (parentIdList == null || parentIdList.isEmpty()) {
            return null;
        }
        ProductBed param = new ProductBed();
        param.setQueryParentIdList(parentIdList);
        return findListByParams(param);
    }

}
