/*
 * ProductPackageService.java
 
 * www.piaozhijia.coim
 */
package com.pzj.base.service.product;

import java.util.List;

import com.pzj.base.common.BaseService;
import com.pzj.base.entity.product.ProductPackage;
import com.pzj.base.entity.product.ProductPackageSub;
import com.pzj.base.entity.product.ProductRelation;

/**
 * @Description:service接口.联票子票主表
 * @author: 票之家
 */
public interface IProductPackageService extends BaseService<ProductPackage>{
    public Long insert(ProductPackage entity,List<ProductPackageSub> subList,List<ProductRelation> packageRelList);
    
    public void batchInsert(List<ProductPackage> entityList);
}
