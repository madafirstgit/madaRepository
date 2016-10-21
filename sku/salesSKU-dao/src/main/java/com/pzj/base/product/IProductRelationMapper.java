/*
 * ProductRelationMapper.java
 * 票之家科技有限公司
 * ------------------*
 * 2015-09-28 created
 */
package com.pzj.base.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pzj.base.common.BaseMapper;
import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.product.ProductRelation;
import com.pzj.base.entity.product.ProductScenicAndSupplier;
import com.pzj.base.entity.query.ProductUser;

/**
 * 产品关系
 * 
 * @author apple
 * 
 */
@MyBatisDao
public interface IProductRelationMapper extends BaseMapper<ProductRelation> {

    int deleteByParam(ProductRelation param);

    List<ProductRelation> findByIdsMap(Map<String, Object> ids);

    List<ProductRelation> queryPageByParams(Map<String, Object> params);

    Integer queryCountByParams(Map<String, Object> params);

    // List<ProductRelation> queryRels(ProductRelation param);

    List<Map<String, Object>> findMaxMin(Map<String, Object> params);

    Integer findCouMaxMin(Map<String, Object> params);

    List<Map<String, Object>> findScenicByProductId(Map<String, Object> params);

    List<Map<String, Object>> findScenicByProduct(Map<String, Object> params);

    // List<Map<String, Object>> findProductSupplier(Map<String, Object>
    // params);

    /**
     * 
     * 根据联票子票查询景区
     * 
     * 查询的景区是业务上联票子票关联对方供应商的景区。
     * 
     * @param packageIds
     *            联票子票产品ID集合
     * @return
     */
    List<ProductScenicAndSupplier> selectPackageWithScenic(List<Long> packageIds);

    /**
     * 根据供应商关系查询，通用分页个数计算
     * 
     * @param params
     * @return
     */
    int countByUserRelation(Map<String, Object> params);

    List<Map<String, Object>> findScenicBySpotProductId(Map<String, Object> params);

    /**
     * 查询产品关联的供应商
     * <p/>
     * 目前的业务是创建联票子票时，要设置期望关联的供应商，此接口就是为了查询这些供应商的。
     * @param pu
     * @return
     */
    List<ProductUser> findUserByProduct(@Param("pu") ProductUser pu);
    
    
    
    //**20160727 二次迭代新加接口 start***************************************************************//
    
    Integer deleteBatchByParam(List<ProductRelation> list);
    //**20160727 二次迭代新加接口 end***************************************************************//
}