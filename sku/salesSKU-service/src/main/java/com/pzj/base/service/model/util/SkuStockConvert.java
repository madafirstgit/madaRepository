package com.pzj.base.service.model.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.pzj.base.entity.product.ProductCloseTimeslot;
import com.pzj.base.entity.product.ProductStockRelation;
import com.pzj.base.service.model.queryResult.Product;
import com.pzj.core.stock.model.result.JudgeRelationResult;
import com.pzj.core.stock.model.result.SkuStockListResult;
import com.pzj.core.stock.model.result.SkuStockRelationResult;
import com.pzj.core.stock.model.result.SkuStockResult;

public class SkuStockConvert {
	private static SkuStockConvert convert = new SkuStockConvert();
	private SkuStockConvert(){
		
	}
	public static SkuStockConvert getInstance(){
		return convert;
	}
	
    public SkuStockRelationResult convertTSSRelation(ProductStockRelation rel){
		if(rel == null){
			return null;
		}
		SkuStockRelationResult result = new SkuStockRelationResult();
		convertTSSRelation(rel,result);
		return result;
	}
    
    public void convertTSSRelation(ProductStockRelation rel,SkuStockRelationResult result){
		result.setProductId(rel.getProductId());
		result.setStockRuleId(rel.getStockRuleId());
	}
	
	public ArrayList<SkuStockRelationResult> convertTSSRelation(List<ProductStockRelation> relList){
		
		if(relList == null){
			return null;
		}
		
		ArrayList<SkuStockRelationResult> result = new ArrayList<SkuStockRelationResult>();
		convertTSSRelation(relList,result);
		return result;
	}
	
    public void convertTSSRelation(List<ProductStockRelation> relList,List<SkuStockRelationResult> result){
		for(ProductStockRelation rel : relList){
			result.add(convertTSSRelation(rel));
		}
	}
    
    
    public SkuStockResult convertTSkuStockResult(Product pr){
		if(pr == null){
			return null;
		}
		SkuStockResult result = new SkuStockResult();
		convertTSkuStockResult(pr,result);
		return result;
	}
    
    public void convertTSkuStockResult(Product pr,SkuStockResult result){
		result.setProductId(pr.getRelease().getId());
		result.setStartDate(pr.getInfo().getStartDate());
		result.setEndDate(pr.getInfo().getEndDate());
		result.setProductInfoId(pr.getInfo().getId());
	}
	
	public List<SkuStockResult> convertTSkuStockResult(List<Product> relList){
		
		if(relList == null){
			return null;
		}
		
		List<SkuStockResult> result = new ArrayList<SkuStockResult>();
		convertTSkuStockResult(relList,result);
		return result;
	}
	
    public void convertTSkuStockResult(List<Product> relList,List<SkuStockResult> result){
		for(Product rel : relList){
			result.add(convertTSkuStockResult(rel));
		}
	}

    
    public void combinationTSkuStockResult(List<ProductCloseTimeslot> slotList,List<SkuStockResult> resultList){
    	if(CollectionUtils.isEmpty(slotList)){
    		return ;
    	}
    	if(CollectionUtils.isEmpty(resultList)){
    		return;
    	}
    	for(SkuStockResult result :  resultList){    		
    		for(ProductCloseTimeslot slot : slotList){
    			if(result.getProductInfoId().longValue() == slot.getProductInfoId().longValue()){
    				List<Date> slotDateList = result.getCloseTimeSlots();
    				if(slotDateList == null){
    					slotDateList = new ArrayList<Date>();
    					result.setCloseTimeSlots(slotDateList);
    				}
    				slotDateList.add(slot.getColseDate());  				
    			}
    		}
    	}
    	
    }
    
    
    
    public ArrayList<SkuStockListResult> combinationTSSListResult(List<SkuStockRelationResult> relations,List<SkuStockResult> resultList){
    	if(CollectionUtils.isEmpty(relations)){
    		return null;
    	}
    	if(CollectionUtils.isEmpty(resultList)){
    		return null;
    	}
    	Map<String,ArrayList<SkuStockResult>> map = new HashMap<String,ArrayList<SkuStockResult>>();
    	ArrayList<SkuStockListResult> result = new ArrayList<SkuStockListResult>();
    	for(SkuStockRelationResult rel : relations){
    		Long stockId = rel.getStockRuleId();
    		String stockId_ = String.valueOf(stockId);
    		ArrayList<SkuStockResult> values = map.get(stockId_);
    		if(values == null){
    			values = new ArrayList<SkuStockResult>();
    			SkuStockListResult ssList = new SkuStockListResult();
    			result.add(ssList);
    			ssList.setStockRuleId(stockId);
    			ssList.setSkuList(values);
    			
    			map.put(stockId_, values);
    		}
    		for(SkuStockResult it : resultList){    		
    			if(rel.getProductId().longValue() == it.getProductId().longValue()){
    				values.add(it);		
    			}
    		}
    		
    	}
  	  return result;
    }
    
    public ArrayList<JudgeRelationResult> combinationTJudgeListResult(List<Long> stockRuleIds,List<SkuStockListResult> resultList){
    	if(CollectionUtils.isEmpty(stockRuleIds)){
    		return null;
    	}
  
    	Map<String,List<SkuStockResult>> map = ModelOperateUtil.getInstance().getSkuStockListResultMap(resultList);
    	ArrayList<JudgeRelationResult> result = new ArrayList<JudgeRelationResult>();
    	for(Long stockRuleId : stockRuleIds){
    		JudgeRelationResult judge = new JudgeRelationResult();
    		judge.setStockRuleId(stockRuleId);
    		List<SkuStockResult> skuStockList = map.get(stockRuleId.toString());
    		judge.setIsHaveRelation(CollectionUtils.isNotEmpty(skuStockList));
    		result.add(judge);
    	}
  	  return result;
    }
   
}
