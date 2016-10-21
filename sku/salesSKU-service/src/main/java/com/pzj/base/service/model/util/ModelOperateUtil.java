package com.pzj.base.service.model.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.pzj.base.entity.product.ProductCloseTimeslot;
import com.pzj.base.entity.product.ProductRelease;
import com.pzj.base.entity.product.ProductStockRelation;
import com.pzj.core.stock.model.result.SkuStockListResult;
import com.pzj.core.stock.model.result.SkuStockRelationResult;
import com.pzj.core.stock.model.result.SkuStockResult;

@Component
public class ModelOperateUtil {
	private static ModelOperateUtil util = new ModelOperateUtil();

	private ModelOperateUtil() {

	}

	public static ModelOperateUtil getInstance() {
		return util;
	}

	public List<Long> getProductIdForSSR(List<SkuStockRelationResult> list) {
		if (list == null)
			return null;
		Set<Long> set = new HashSet<Long>();
		for (SkuStockRelationResult key : list) {
			if (key.getProductId() == null) {
				continue;
			}
			set.add(key.getProductId());
		}
		return new ArrayList<Long>(set);
	}
	
	public List<Long> getProductIdForPSR(List<ProductStockRelation> list) {
		if (list == null)
			return null;
		Set<Long> set = new HashSet<Long>();
		for (ProductStockRelation key : list) {
			if (key.getProductId() == null) {
				continue;
			}
			set.add(key.getProductId());
		}
		return new ArrayList<Long>(set);
	}
	
	public List<Long> getInfoIdList(List<ProductRelease> keyList) {
		if (keyList == null)
			return null;
		Set<Long> set = new HashSet<Long>();
		for (ProductRelease key : keyList) {
			if (key.getProductId() == null) {
				continue;
			}
			set.add(Long.valueOf(key.getProductId()));
		}
		return new ArrayList<Long>(set);
	}
	
	/**
	 * 将关闭事件集合，转为按产品组id分组的map集合
	 * @param slotList
	 * @return key=产品组id
	 */
	public Map<String, List<ProductCloseTimeslot>> getInfoCloseSlotMap(List<ProductCloseTimeslot> slotList) {
		if (slotList == null)
			return null;
		Map<String, List<ProductCloseTimeslot>> result = new HashMap<String, List<ProductCloseTimeslot>>();
		for(ProductCloseTimeslot slot : slotList){
		   Long infoId = slot.getProductInfoId();
		   if(infoId == null) continue;
		   List<ProductCloseTimeslot> pslot = result.get(infoId.toString());
		   if(pslot == null){
			   pslot = new ArrayList<ProductCloseTimeslot>();	
			   result.put(infoId.toString(), pslot);
		   }
		   pslot.add(slot);
		}
		
		return result;
	}
	
	
	public Map<String, List<SkuStockResult>> getSkuStockListResultMap(List<SkuStockListResult> resultList) {
		if (resultList == null)
			return null;
		Map<String, List<SkuStockResult>> result = new HashMap<String, List<SkuStockResult>>();
		for(SkuStockListResult stock : resultList){
		   Long stockRuleId = stock.getStockRuleId();
		   if(stockRuleId == null) continue;
		   result.put(stockRuleId.toString(), stock.getSkuList());
		}
		
		return result;
	}

}
