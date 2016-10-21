package com.pzj.base.product;

import java.util.List;
import java.util.Map;

import com.pzj.base.common.BaseMapper;
import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.product.ProductScenicRelation;

@MyBatisDao
public interface IProductScenicRelationMapper extends BaseMapper<ProductScenicRelation> {

    List<ProductScenicRelation> findByIdsMap(Map<String, Object> ids);

    int deleteByParam(ProductScenicRelation param);

    List<ProductScenicRelation> queryScenicRelationByParam(Map<String, Object> params);

    Integer countScenicRelationByParam(Map<String, Object> params);
}
