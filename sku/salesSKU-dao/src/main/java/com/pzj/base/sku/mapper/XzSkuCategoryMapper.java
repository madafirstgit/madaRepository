package com.pzj.base.sku.mapper;

import java.util.List;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.sku.entity.XzSkuCategory;
import com.pzj.base.sku.entity.XzSkuCategoryExample;

@MyBatisDao
public interface XzSkuCategoryMapper {

    /**
     * 通过公司ID查询所有的分类
     * @param bossid 公司ID
     * @return List<XzSkuCategory> 产品类别集合
     */
    List<XzSkuCategory> findCategoriesByBossId(Integer bossid);

    /**
     * 根据通用查询条件获得总条数
     * @param example 通用查询条件
     * @return int 总条数
     */
    int countByExample(XzSkuCategoryExample example);

    /**
     * 根据通用查询条件获得分类集合
     * @param Map<String,Object> map 通用查询条件
     * return List<XzSkuCategory> 产品类别集合
     */

    List<XzSkuCategory> selectByExample(XzSkuCategoryExample example);

    //List<XzSkuCategory> findCategoriesByMap(Map<String,Object> map);
    /**
     * 通过ID查询分类
     * @param id 类别ID
     * @return XzSkuCategory 实体对象
     */
    XzSkuCategory findByPrimaryKey(Integer id);

    /**
     * 通过类别名称查询分类
     * @param name 类别名称
     * @return XzSkuCategory 实体对象
     */
    XzSkuCategory findByCategoryName(String name);

    /**
     * 插入类别
     * @param XzSkuCategory 类别实体
     * @return int 插入ID
     */
    int insertXzSkuCategory(XzSkuCategory category);

    /**
     * 更新类别
     * @param XzSkuCategory 类别实体
     * @return int 影响行数
     */
    int updateByPrimaryKey(XzSkuCategory category);

    /**
    * 根据条件删除类别
    * @return int 影响行数 
    */

    int delete(XzSkuCategory category);

    /*
    int countByExample(XzSkuCategoryExample example);
    int deleteByExample(XzSkuCategoryExample example);
    int deleteByPrimaryKey(Integer id);
    int insertSelective(XzSkuCategory record);
    java.util.List<club.xingzong.product.entity.XzSkuCategory> selectByExample(XzSkuCategoryExample example);
    int updateByExampleSelective(@Param("record") XzSkuCategory record, @Param("example") XzSkuCategoryExample example);
    int updateByExample(@Param("record") XzSkuCategory record, @Param("example") XzSkuCategoryExample example);
    int updateByPrimaryKeySelective(XzSkuCategory record);
     */
}