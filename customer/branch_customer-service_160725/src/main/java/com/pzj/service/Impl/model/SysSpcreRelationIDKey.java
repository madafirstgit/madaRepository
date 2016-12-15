package com.pzj.service.Impl.model;

import java.util.List;

public class SysSpcreRelationIDKey {
	
	/**政策Id*/
	private List<Long> strategyIds;
	
    /** 产品Id */
    private List<Long>  productIds;
    
    /** 渠道Id */
    private List<Long>  channelIds;

	public List<Long> getStrategyIds() {
		return strategyIds;
	}

	public void setStrategyIds(List<Long> strategyIds) {
		this.strategyIds = strategyIds;
	}

	public List<Long> getProductIds() {
		return productIds;
	}

	public void setProductIds(List<Long> productIds) {
		this.productIds = productIds;
	}

	public List<Long> getChannelIds() {
		return channelIds;
	}

	public void setChannelIds(List<Long> channelIds) {
		this.channelIds = channelIds;
	}
    
    
    
}
