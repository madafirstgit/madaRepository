package com.pzj.base.entity;

import java.util.List;

import com.pzj.base.common.BaseEntity;

public class SysSpcreRelationKey extends BaseEntity {

    private static final long serialVersionUID = 1695932151705655202L;

    /** 政策Id */
    private String            strategyId;

    /** 产品Id */
    private String            productId;

    /** 渠道Id */
    private String            channelId;

    /** 返利Id **/
    private String            rebateId;

    /** 加点返Id **/
    private String            extraRebateId;

    /** 是否通过 1：是 0：否 */
    private String            status;

    /** 拒绝理由 **/
    private String            refuseReason;

    /**
     * 扩展属性，不持久化
     */
    private List<Long>        statusList;

    /**
     * 查询扩展属性，不持久化
     */
    private List<Long>        queryStrategyIds;

    /**
     * 查询扩展属性，不持久化
     */
    private List<Long>        queryProductIds;

    /**
     * 查询扩展属性，不持久化
     */
    private List<Long>        queryChannelIds;

    /**
     * 获取政策Id
     * 
     * @return strategyId 政策Id
     */
    public String getStrategyId() {
        return strategyId;
    }

    /**
     * 设置政策Id
     * 
     * @param strategyId
     *            政策Id
     */
    public void setStrategyId(String strategyId) {
        this.strategyId = strategyId;
    }

    /**
     * 获取产品Id
     * 
     * @return productId 产品Id
     */
    public String getProductId() {
        return productId;
    }

    /**
     * 设置产品Id
     * 
     * @param productId
     *            产品Id
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * 获取渠道Id
     * 
     * @return channelId 渠道Id
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * 设置渠道Id
     * 
     * @param channelId
     *            渠道Id
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    /**
     * 获取返利Id
     * 
     * @return rebateId 返利Id
     */
    public String getRebateId() {
        return rebateId;
    }

    /**
     * 设置返利Id
     * 
     * @param rebateId
     *            返利Id
     */
    public void setRebateId(String rebateId) {
        this.rebateId = rebateId;
    }

    /**
     * 获取加点返Id
     * 
     * @return extraRebateId 加点返Id
     */
    public String getExtraRebateId() {
        return extraRebateId;
    }

    /**
     * 设置加点返Id
     * 
     * @param extraRebateId
     *            加点返Id
     */
    public void setExtraRebateId(String extraRebateId) {
        this.extraRebateId = extraRebateId;
    }

    /**
     * 获取是否通过1：是0：否
     * 
     * @return status 是否通过1：是0：否
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置是否通过1：是0：否
     * 
     * @param status
     *            是否通过1：是0：否
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /** 扩展属性，不持久化 */
    public List<Long> getStatusList() {
        return statusList;
    }

    /** 扩展属性，不持久化 */
    public void setStatusList(List<Long> statusList) {
        this.statusList = statusList;
    }

    /**
     * 获取拒绝理由
     * 
     * @return refuseReason 拒绝理由
     */
    public String getRefuseReason() {
        return refuseReason;
    }

    /**
     * 设置拒绝理由
     * 
     * @param refuseReason
     *            拒绝理由
     */
    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }

    public List<Long> getQueryStrategyIds() {
        return queryStrategyIds;
    }

    public void setQueryStrategyIds(List<Long> queryStrategyIds) {
        this.queryStrategyIds = queryStrategyIds;
    }

    public List<Long> getQueryProductIds() {
        return queryProductIds;
    }

    public void setQueryProductIds(List<Long> queryProductIds) {
        this.queryProductIds = queryProductIds;
    }

    public List<Long> getQueryChannelIds() {
        return queryChannelIds;
    }

    public void setQueryChannelIds(List<Long> queryChannelIds) {
        this.queryChannelIds = queryChannelIds;
    }
    
    public Long getLongFStrategyId(){
    	return this.strategyId == null ? null : Long.valueOf(this.strategyId);
    }
    
    public Long getLongFChannelId(){
    	return this.channelId == null ? null : Long.valueOf(this.channelId);
    }
    
    public Long getLongFProductId(){
    	return this.productId == null ? null : Long.valueOf(this.productId);
    }
    
    public boolean isValidData(){
    	return this.strategyId != null && this.productId != null && this.channelId != null;
    }

}
