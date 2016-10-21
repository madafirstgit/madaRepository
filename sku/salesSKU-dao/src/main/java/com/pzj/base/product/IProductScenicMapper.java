package com.pzj.base.product;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.pzj.base.common.BaseMapper;
import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.product.ProductScenic;

@MyBatisDao
public interface IProductScenicMapper extends BaseMapper<ProductScenic> {

    public List<ProductScenic> findByIdsMap(Map<String, List<Long>> ids);

    /**
     * 根据景区所属平台查询景区
     * 
     * @param parentId
     *            所属平台
     * @return
     */
    public List<ProductScenic> queryScenicWithParentId(Long parentId);

    /**
     * 根据景区所属平台查询本平台之外的景区
     * 
     * @param parentId
     *            所属平台
     * @return
     */
    public List<ProductScenic> queryScenicWithOutParentId(Long parentId);

    public List<ProductScenic> queryByParamMapWithRelation(Map<String, Object> params);

    int countByParamMapWithRelation(Map<String, Object> params);

    /**
     * 查询数据库中所有的省份信息
     * 
     * @return 省份集合
     */
    List<String> findAllProvinces();

    /**
     * 根据参数模糊查询所有景区
     * @return List<ProductScenic> 景区集合
     */

    List<ProductScenic> findLikeScenics(Map<String, Object> params);

    /**
     * 根据ProductRelation关系表查询景区
     * @param scenic
     * @param objId ProductRelation的objId
     * @param objType ProductRelation的objType
     * @return
     */
    List<ProductScenic> selectScenicByProductRelation(@Param("bParam") ProductScenic scenic,
                                                      @Param("relationObjId") Long objId,
                                                      @Param("relationObjType") String objType);
    
    /**
     * 根据产品id获取产品景区的省市
     * @param productIds
     * @return
     */
    List<ProductScenic> selectAddressByProductId(@Param("productIds")List<Long> productIds);
    
    /**
     * 根据景区名称全匹配查找景区
     * @param scenic
     * @return
     */
    List<ProductScenic> selectScenicByName(@Param("name")String name);
    
    /**
     * 根据景区参数查询景区列表
     * @param scenic
     * @return
     */
    List<ProductScenic> selectScenicsByAppSearchKey(@Param("bParam") ProductScenic scenic);
    

}
