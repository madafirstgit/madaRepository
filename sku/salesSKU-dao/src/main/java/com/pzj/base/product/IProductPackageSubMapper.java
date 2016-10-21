/*
 * ProductPackageSubMapper.java
 
 * www.piaozhijia.coim
 */
package com.pzj.base.product;

import java.util.List;

import com.pzj.base.common.BaseMapper;
import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.product.ProductPackageSub;

/**
 * Mapper接口.联票子票从表
 * @author 票之家
 */
@MyBatisDao
public interface IProductPackageSubMapper extends BaseMapper<ProductPackageSub> {
    public List<ProductPackageSub> findByParentIdList(List<Long> ids);

    public List<ProductPackageSub> findByIdList(List<Long> ids);
}
