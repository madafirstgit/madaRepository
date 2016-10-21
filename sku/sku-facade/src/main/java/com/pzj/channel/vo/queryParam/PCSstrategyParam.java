package com.pzj.channel.vo.queryParam;

import java.io.Serializable;

import com.pzj.channel.Strategy;

public class PCSstrategyParam implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -5944943977672926559L;

    /**
     * 产品信息
     */
    private Long              productId;

    /**
     * 渠道查询信息
     */
    private Long              channelId;

    /**
     * 政策查询信息
     */
    private Strategy          strategyParam;


    /**
     * 获取产品信息
     * 
     * @return productId 产品信息
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * 设置产品信息
     * 
     * @param productId
     *            产品信息
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * 获取渠道查询信息
     * 
     * @return channelId 渠道查询信息
     */
    public Long getChannelId() {
        return channelId;
    }

    /**
     * 设置渠道查询信息
     * 
     * @param channelId
     *            渠道查询信息
     */
    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Strategy getStrategyParam() {
        return strategyParam;
    }

    public void setStrategyParam(Strategy strategyParam) {
        this.strategyParam = strategyParam;
    }



}
