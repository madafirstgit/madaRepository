package com.pzj.channel.vo.queryParam;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StrategyJudgeParam implements Serializable{
	
	Logger logger = LoggerFactory.getLogger(StrategyJudgeParam.class);
	
	/**产品id*/
	private Long productId;
	
	
	/**渠道id集合*/
	private List<Long> channelIds;


	public Long getProductId() {
		return productId;
	}


	public void setProductId(Long productId) {
		this.productId = productId;
	}


	public List<Long> getChannelIds() {
		return channelIds;
	}


	public void setChannelIds(List<Long> channelIds) {
		this.channelIds = channelIds;
	}

    public boolean isValidData(){
    	return productId != null && channelIds != null && !channelIds.isEmpty();
    }

}
