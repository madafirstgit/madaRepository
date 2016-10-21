/*
 * ProductCombineRelationMapper.java
 
 * www.piaozhijia.com
 */
package com.pzj.base.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pzj.base.common.BaseMapper;
import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.product.ProductCombineRelation;
import com.pzj.base.entity.product.ProductRelease;

/**
 * Mapper接口.组合产品和所包含的产品关系
 * @author 票之家
 */
@MyBatisDao
public interface IProductCombineRelationMapper extends BaseMapper<ProductCombineRelation> {

    List<ProductCombineRelation> findByIdsMap(Map<String, Object> ids);

    List<ProductCombineRelation> selectJoinByParams(@Param("relation") ProductCombineRelation relation,
                                                    @Param("releasee") ProductRelease product,
                                                    @Param("product") ProductRelease productSub);

    /**
     * 根据产品id删除组合关系
     * @param productId
     */
    void deleteByProductId(Long productId);
}
