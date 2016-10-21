package com.pzj.product.vo.product;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class SkuSiteRelation implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -5367220308231074199L;

    /** 景点id*/
    private Long              siteId;

    /** 交通次数*/
    private Integer           trafficCount;

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    public Integer getTrafficCount() {
        return trafficCount;
    }

    public void setTrafficCount(Integer trafficCount) {
        this.trafficCount = trafficCount;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
