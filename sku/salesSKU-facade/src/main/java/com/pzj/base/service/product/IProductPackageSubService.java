/*
 * ProductPackageSubService.java
 
 * www.piaozhijia.coim
 */
package com.pzj.base.service.product;

import java.util.List;

import com.pzj.base.common.BaseService;
import com.pzj.base.entity.product.ProductPackageSub;
import com.pzj.base.entity.product.ProductRelation;

/**
 * @Description:service接口.联票子票从表
 * @author: 票之家
 */
public interface IProductPackageSubService extends BaseService<ProductPackageSub>{
    
    /**
     * 根据联票子票id查询返利政策
     * 
     * @param ids
     * @return
     */
    List<ProductPackageSub> findByParentIdList(List<Long> ids);
    
    /**
     * 根据id集合返利政策
     * @param ids
     * @return
     */
    public List<ProductPackageSub> findByIdList(List<Long> ids);
}
