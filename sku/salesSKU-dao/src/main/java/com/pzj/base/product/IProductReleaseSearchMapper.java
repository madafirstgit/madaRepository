/*
 * ProductReleaseMapper.java
 * 票之家科技有限公司
 * ------------------*
 * 2015-09-28 created
 */
package com.pzj.base.product;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.SysLabelRelationKey;
import com.pzj.base.entity.product.ProductRelease;
import com.pzj.common.QueryPageModel;


/**
 * 产品发布关系
 * 
 * @author apple
 * 
 */
@MyBatisDao
public interface IProductReleaseSearchMapper {
	
	ProductRelease selectByPrimaryKey(Long id);
	
	List<ProductRelease> selectPageByParam(@Param("bParam") ProductRelease bParam,@Param("pParam") QueryPageModel pParam);

	Integer countByParam(@Param("bParam") ProductRelease bParam);
}