package com.pzj.core.stock.model.result;

import java.io.Serializable;

public class JudgeRelationResult implements Serializable{

	/**
	 * 库存与产品是否有有效的关联关系
	 */
	private Boolean  isHaveRelation;
	
	/** 库存规则id */
	private Long stockRuleId;
	

	public JudgeRelationResult(){
		
	}
	
	public JudgeRelationResult(Long stockRuleId, Boolean isHaveRelation){
		this.stockRuleId = stockRuleId;
		this.isHaveRelation = isHaveRelation;
	}
	
	public Boolean getIsHaveRelation() {
		return isHaveRelation;
	}

	public void setIsHaveRelation(Boolean isHaveRelation) {
		this.isHaveRelation = isHaveRelation;
	}

	public Long getStockRuleId() {
		return stockRuleId;
	}

	public void setStockRuleId(Long stockRuleId) {
		this.stockRuleId = stockRuleId;
	}
	
	
	
	
}
