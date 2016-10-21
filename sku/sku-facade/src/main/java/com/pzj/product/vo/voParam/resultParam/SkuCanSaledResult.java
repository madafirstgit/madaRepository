package com.pzj.product.vo.voParam.resultParam;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

public class SkuCanSaledResult implements Serializable {
    /**
     * 
     */
    private static final long   serialVersionUID = -219565908442081061L;

    /**
     * 产品结果集
     */
    private List<ProductResult> productResults;

    /**
     * 分销商id
     */
    private Long                distributorId;

    /**
     * 渠道id集合
     */
    private Long                channelId;

    /**
     * 日期
     */
    private Date                date;

    /**
     * 销售端口
     */
    private String              saleType;

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

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    public List<ProductResult> getProductResults() {
        return productResults;
    }

    public void setProductResults(List<ProductResult> productResults) {
        this.productResults = productResults;
    }

    public static class ProductResult {
        /**
         * 产品id
         */
        private Long    productId;

        /**
         * 是否可买结果
         */
        private Boolean isCanSaleResult;

        public Long getProductId() {
            return productId;
        }

        public void setProductId(Long productId) {
            this.productId = productId;
        }

        public Boolean getCanSaleResult() {
            return isCanSaleResult;
        }

        public void setCanSaleResult(Boolean canSaleResult) {
            isCanSaleResult = canSaleResult;
        }
    }
}
