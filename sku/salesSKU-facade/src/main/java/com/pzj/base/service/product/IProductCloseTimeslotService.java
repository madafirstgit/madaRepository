/*
 * ProductCloseTimeslotService.java
 
 * www.piaozhijia.coim
 */
package com.pzj.base.service.product;

import java.util.List;

import com.pzj.base.common.BaseService;
import com.pzj.base.entity.product.ProductCloseTimeslot;
import com.pzj.base.entity.product.ProductInfo;


/**
 * @Description:service接口.区域
 * @author: 票之家
 */
public interface IProductCloseTimeslotService extends BaseService<ProductCloseTimeslot>{
	/**
	 * 更新产品组的关闭事件
	 * @param infoId
	 * @param closeTimeSlotIds
	 * @return
	 */
	Integer saveSkuAndCloseTimeSlotRelation(ProductInfo info,
            List<ProductCloseTimeslot> closeTimeSlotIds);
	
	/**
	 * 根据产品组id获取产品关闭时间事件集合
	 * @param productIds
	 * @return
	 */
	List<ProductCloseTimeslot> findValidListByProductIds(List<Long> productIds);
}
