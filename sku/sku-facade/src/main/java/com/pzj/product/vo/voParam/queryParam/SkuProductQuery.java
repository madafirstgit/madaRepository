package com.pzj.product.vo.voParam.queryParam;

import java.util.List;

import com.pzj.product.vo.product.SkuProduct;

public class SkuProductQuery extends SkuProduct {

    /**
    * 
    */
    private static final long serialVersionUID = 2542323448198388542L;

    /** 支持in查询，扩展属性，不持久化 */
    private List<Long>        ids;

    private List<String>      proCategorys;

    /**
     * 审核状态集合,扩展属性，为了支持查询
     */
    private List<Long>        auditStatusList;
    /**
     * 扩展属性，用于查询，产品有效期ids
     */
    private List<Long>        productIds;

    /** 供应商id集合，作为查询条件 */
    private List<String>      supplierIdList;

    /**提审时间段查询*/
    private DateQueryParam    checkDateQuery;

    /**
     * 通审时间端查询
     */
    private DateQueryParam    publishDateQuery;

    /**
     * 用于查询，关联渠道id
     */
    private List<Long>        channelIds;

    /**
     * 用于查询，关联政策id
     */
    private List<Long>        strategyIds;

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public List<String> getProCategorys() {
        return proCategorys;
    }

    public void setProCategorys(List<String> proCategorys) {
        this.proCategorys = proCategorys;
    }

    public List<Long> getAuditStatusList() {
        return auditStatusList;
    }

    public void setAuditStatusList(List<Long> auditStatusList) {
        this.auditStatusList = auditStatusList;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }

    public List<String> getSupplierIdList() {
        return supplierIdList;
    }

    public void setSupplierIdList(List<String> supplierIdList) {
        this.supplierIdList = supplierIdList;
    }

    public DateQueryParam getCheckDateQuery() {
        return checkDateQuery;
    }

    public void setCheckDateQuery(DateQueryParam checkDateQuery) {
        this.checkDateQuery = checkDateQuery;
    }

    public DateQueryParam getPublishDateQuery() {
        return publishDateQuery;
    }

    public void setPublishDateQuery(DateQueryParam publishDateQuery) {
        this.publishDateQuery = publishDateQuery;
    }

    public List<Long> getChannelIds() {
        return channelIds;
    }

    public void setChannelIds(List<Long> channelIds) {
        this.channelIds = channelIds;
    }

    public List<Long> getStrategyIds() {
        return strategyIds;
    }

    public void setStrategyIds(List<Long> strategyIds) {
        this.strategyIds = strategyIds;
    }
}
