/*
 * ProductSiteDataMapper.java
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
import com.pzj.base.entity.product.ProductSiteData;
import com.pzj.base.entity.product.ProductSiteRelation;

/**
 * 点位表包含：检票点，检票点设备，售票点
 * 
 * @author apple
 * 
 */
@MyBatisDao
public interface IProductSiteDataMapper extends BaseMapper<ProductSiteData> {

    List<ProductSiteData> findByIdsMap(Map<String, List<Long>> ids);

    List<ProductSiteData> findByParentIdsMap(Map<String, List<Long>> ids);

    List<ProductSiteData> findByScenicIdsMap(Map<String, List<Long>> ids);

    /**
     * 解除和父对象的绑定
     * 
     * @param parentId
     * @return
     */
    int resetParentId(Long parentId);

    /**
     * 根据id批量删除
     * 
     * @param ids
     * @return
     */
    int deleteByIds(List<Long> ids);

    /**
     * 查询检票点，和景区表联合查询
     * 
     * @param params
     * @return
     */
    List<ProductSiteData> findWithScenic(Map<String, Object> params);

    /**
     * 查询检票点，和景区表联合查询
     * 
     * @param params
     * @return
     */
    int countWithScenic(Map<String, Object> params);

    List<ProductSiteData> queryWithScenic(Map<String, Object> params);

    /**
     * 根据id集合联合景区表查询
     * @param ids
     * @return
     */
    List<ProductSiteData> findByIdsMapWithScenic(Map<String, List<Long>> ids);

    /**
     * 根据mac查询检票设备所属景区入口下所有检票设备的检票次数总和
     * @param mac
     * @return
     */
    Integer getEntryCheckCountByMac(String mac);

    /**
     * 根据景点、景点关系查询景点
     * @param siteData 景点条件
     * @param relation 景点关系条件
     * @return
     */
    List<ProductSiteData> selectSiteDataByProductInfo(@Param("bParam") ProductSiteData siteData,
                                                      @Param("relation") ProductSiteRelation relation);

}