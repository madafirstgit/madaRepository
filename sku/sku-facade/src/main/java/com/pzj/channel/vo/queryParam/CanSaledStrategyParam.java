package com.pzj.channel.vo.queryParam;

import java.io.Serializable;

public class CanSaledStrategyParam implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -5281008603558971477L;

    /**
     * 产品Id
     */
    private Long              productId;

    /**
     * 渠道Id
     */
    private Long              channelId;

    /**
     * 销售端口
     */
    private String            saleType;

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getSaleType() {
        return saleType;
    }

    public void setSaleType(String saleType) {
        this.saleType = saleType;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

}
