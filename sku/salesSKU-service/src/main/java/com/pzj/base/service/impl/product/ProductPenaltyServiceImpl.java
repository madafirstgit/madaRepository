package com.pzj.base.service.impl.product;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.pzj.base.common.child.impl.BaseChildCommonServiceImpl;
import com.pzj.base.entity.product.pms.ProductPenalty;
import com.pzj.base.product.IProductPenaltyMapper;
import com.pzj.base.service.product.IProductPenaltyService;

/**
 * service接口实现.$ENTITY_NOTE$
 * 
 * @author 票之家
 */
@Service
@Lazy
public class ProductPenaltyServiceImpl extends
                                       BaseChildCommonServiceImpl<ProductPenalty, IProductPenaltyMapper>
                                       implements IProductPenaltyService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public void setParentId(ProductPenalty child, Long parentId) {
        if (child == null || parentId == null) {
            return;
        }
        child.setProductId(parentId);

    }

    public List<ProductPenalty> findByIdList(List<Long> idList) {
        if (idList == null || idList.isEmpty()) {
            return null;
        }
        ProductPenalty param = new ProductPenalty();
        param.setQueryIdList(idList);
        return findListByParams(param);
    }

    @Override
    public List<ProductPenalty> findByParentIdList(List<Long> parentIdList) {
        if (parentIdList == null || parentIdList.isEmpty()) {
            return null;
        }
        ProductPenalty param = new ProductPenalty();
        param.setQueryParentIdList(parentIdList);
        return findListByParams(param);
    }

}
