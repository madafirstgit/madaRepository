package com.pzj.product.vo.voParam.queryParam;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class ProductSaledParam implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = -219565908442081061L;

    /**
     * 分销商id
     */
    private Long              distributorId;

    /**
     * 日期
     */
    private Date              date;

    /**
     * 产品id
     */
    private List<Long>        productIds;

    /**
     * 渠道id
     */
    private Long              channelId;

    /**
     * 销售端口
     */
    private String            saleType;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSaleType() {
        return saleType;
    }

    public void setSaleType(String saleType) {
        this.saleType = saleType;
    }

    public Long getDistributorId() {
        return distributorId;
    }

    public void setDistributorId(Long distributorId) {
        this.distributorId = distributorId;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }
}
