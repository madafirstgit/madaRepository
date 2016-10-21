/*
 * ProductDictMapper.java
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
import com.pzj.base.common.utils.PageModel;
import com.pzj.base.entity.product.ProductDict;
import com.pzj.base.entity.product.ProductRelease;
import com.pzj.base.entity.product.ProductRulesIntegral;

/**
 * 产品字典表
 * 
 * @author apple
 * 
 */
@MyBatisDao
public interface IProductDictMapper extends BaseMapper<ProductDict> {

    List<ProductDict> findByIdsMap(Map<String, List<Long>> ids);

    Long queryMaxVal(String type);

    int countRulesIntegralAndProductByParams(@Param("dict") ProductDict dict,
                                             @Param("releasee") ProductRelease releasee);

    List<ProductRulesIntegral> selectRulesIntegralAndProductByParams(@Param("dict") ProductDict dict,
                                                                     @Param("releasee") ProductRelease releasee,
                                                                     @Param("page") PageModel page);

    List<ProductRulesIntegral> selectProductOfRulesIntegralByParams(@Param("ruleIds") List<Long> ruleIds);
}