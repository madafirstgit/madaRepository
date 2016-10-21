package com.pzj.core.stock.model.result;

import java.io.Serializable;

public class SkuRondaRelationResult implements Serializable{
	
	/** 场次区域关系表Id*/
	private Long rondaRelationId;
	
	public SkuRondaRelationResult(){
		
	}
	
    public SkuRondaRelationResult(Long rondaRelationId){
    	this.rondaRelationId = rondaRelationId;
		
	}

	public Long getRondaRelationId() {
		return rondaRelationId;
	}

	public void setRondaRelationId(Long rondaRelationId) {
		this.rondaRelationId = rondaRelationId;
	}
	
	

}
