package com.pzj.service.Impl.model;

import java.util.List;

import com.pzj.channel.Channel;
import com.pzj.product.vo.MapObject;

public class ChannelTree implements MapObject<String, ChannelTree>{

	private Channel channel;
	
	private Long channelId;
	
	private List<Long> userId;
	
	public ChannelTree(){}
	
	public ChannelTree(Long channelId){
		this.channelId  = channelId;
	}
	
    

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public List<Long> getUserId() {
		return userId;
	}

	public void setUserId(List<Long> userId) {
		this.userId = userId;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	
	public boolean isValidData(){
		return this.channelId != null;
		
	}

	@Override
	public String key() {
		// TODO Auto-generated method stub
		return this.channelId.toString();
	}

	@Override
	public ChannelTree value() {
		// TODO Auto-generated method stub
		return this;
	}
	
	
}
