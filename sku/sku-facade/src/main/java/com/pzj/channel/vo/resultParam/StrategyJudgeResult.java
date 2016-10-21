package com.pzj.channel.vo.resultParam;

import java.io.Serializable;
import java.util.List;

import com.pzj.channel.Channel;
import com.pzj.channel.Strategy;
import com.pzj.channel.vo.queryParam.StrategyJudgeParam;

public class StrategyJudgeResult implements Serializable{
	
	/** 判断参数 */
	private StrategyJudgeParam param;

	/**判断结果*/
	private Boolean judgeResult;
	
	/**判断为否的原因*/
	private List<JudgeHaveReason> reason;
	
	public StrategyJudgeResult(){
		
	}
	
	public StrategyJudgeResult(StrategyJudgeParam param,List<JudgeHaveReason> reason){
		this.param = param;
		this.judgeResult = judgeResult;
		this.reason = reason;
		
	}
	

	public Boolean getJudgeResult() {
		return judgeResult;
	}

	public void setJudgeResult(Boolean judgeResult) {
		this.judgeResult = judgeResult;
	}

	public List<JudgeHaveReason> getReason() {
		return reason;
	}

	public void setReason(List<JudgeHaveReason> reason) {
		this.reason = reason;
	}

	public static class JudgeHaveReason implements Serializable{
		/**不可以用的原因：分销商id*/
		private Long userId;
		
		/**当前渠道id*/
		private Long channelId;
		
		/**当前渠道*/
		private Channel channel;
		
		/**其他渠道id*/
		private Long o_channelId;
		
		/**其他渠道*/
		private Channel o_channel;
		
		
		private Long strategyId;
		
		private Strategy strategy;
		
		
		public JudgeHaveReason(){
			
		}
        public JudgeHaveReason(Strategy strategy,Long strategyId,Channel channel,Long channelId,Channel o_channel,Long o_channelId, Long userId){
			this.strategy = strategy;
			this.strategyId = strategyId;
			this.channel = channel;
			this.channelId = channelId;
			this.o_channel = o_channel;
			this.o_channelId = o_channelId;
			this.userId = userId;
		}

		public Channel getChannel() {
			return channel;
		}

		public void setChannel(Channel channel) {
			this.channel = channel;
		}

		public Strategy getStrategy() {
			return strategy;
		}

		public void setStrategy(Strategy strategy) {
			this.strategy = strategy;
		}

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public Long getChannelId() {
			return channelId;
		}

		public void setChannelId(Long channelId) {
			this.channelId = channelId;
		}

		public Long getStrategyId() {
			return strategyId;
		}

		public void setStrategyId(Long strategyId) {
			this.strategyId = strategyId;
		}
		public Long getO_channelId() {
			return o_channelId;
		}
		public void setO_channelId(Long o_channelId) {
			this.o_channelId = o_channelId;
		}
		public Channel getO_channel() {
			return o_channel;
		}
		public void setO_channel(Channel o_channel) {
			this.o_channel = o_channel;
		}
		
		
		
	}
}
