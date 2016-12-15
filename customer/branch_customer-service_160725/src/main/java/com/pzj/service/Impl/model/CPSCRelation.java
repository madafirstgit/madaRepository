package com.pzj.service.Impl.model;

import com.pzj.channel.Channel;
import com.pzj.channel.Strategy;


public class CPSCRelation {
	
	
	private Strategy strategy;
	
	private Long strategyId;
	
    private Channel channel;
    
    private Long channelId;
    
    private Long userId;
    
    private Long productId;
    
    

	public Long getStrategyId() {
		return strategyId;
	}

	public void setStrategyId(Long strategyId) {
		this.strategyId = strategyId;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	
	
    public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public Boolean isValidData(){
    	
    	return this.getChannelId() != null && this.getProductId() != null && this.getStrategyId() != null && this.getUserId() != null;
    	
    }
	
	
	
	

}
