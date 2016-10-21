package com.pzj.product.vo.voParam.queryParam;

import java.io.Serializable;

/**
 * Created by Administrator on 2016-8-26.
 */
public class SpuProductBasicInfoParam implements Serializable{
    /**
     * SKU产品ID
     */
    private Long spuId;
    /**
     * 渠道ID
     */
    private Long channelId;

    /**
     * 是否团票
     */
    private String ticketVarie;

    public Long getSpuId() {
        return spuId;
    }

    public void setSpuId(Long spuId) {
        this.spuId = spuId;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getTicketVarie() {
        return ticketVarie;
    }

    public void setTicketVarie(String ticketVarie) {
        this.ticketVarie = ticketVarie;
    }
}
