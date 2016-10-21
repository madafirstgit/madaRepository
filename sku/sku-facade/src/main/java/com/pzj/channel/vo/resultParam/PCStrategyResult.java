package com.pzj.channel.vo.resultParam;

import java.io.Serializable;
import java.util.List;

import com.pzj.channel.Channel;
import com.pzj.channel.SettlementRule;
import com.pzj.channel.Strategy;

public class PCStrategyResult implements Serializable {

    /**
     * 
     */
    private static final long    serialVersionUID = 1952901096614760127L;

    private Long                 productId;

    /**
     * 渠道信息
     */
    private Channel              channel;

    /**
     * 政策信息
     */
    private List<Strategy>       strategyList;

    /**
     * 产品未满结算信息
     */
    private List<SettlementRule> ruleList;
    
    public void PCStrategyResult(){}
    
    public void PCStrategyResult(Long productId, Channel channel, List<Strategy> strategyList){
    	this.productId = productId;
    	this.channel = channel;
    	this.strategyList = strategyList;
    }
    

    /**
     * 获取productId
     * 
     * @return productId productId
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * 设置productId
     * 
     * @param productId
     *            productId
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public List<Strategy> getStrategyList() {
        return strategyList;
    }

    public void setStrategyList(List<Strategy> strategyList) {
        this.strategyList = strategyList;
    }

    public List<SettlementRule> getRuleList() {
        return ruleList;
    }

    public void setRuleList(List<SettlementRule> ruleList) {
        this.ruleList = ruleList;
    }

}
