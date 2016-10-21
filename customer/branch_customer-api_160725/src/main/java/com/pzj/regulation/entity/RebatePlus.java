package com.pzj.regulation.entity;

import java.io.Serializable;
import java.util.List;

import com.pzj.base.entity.SysSpcreRelationKey;

/**
 * 平台 加点返 列表
 * 
 * @author zhangdianliang
 * @email zhangdianliang@mftour.cn
 * @date 2015-11-16 下午6:48:38
 */
public class RebatePlus implements Serializable {

    private static final long serialVersionUID = -1467990725684944963L;

    /**
     * 政策id
     */
    private String strategyId;

    /**
     * 产品id
     */
    private String productId;

    /** 渠道Id */
    private String channelId;

    /** 是否通过 */
    private String status;

    /**
     * 状态集合
     */
    private List<Long> statusList;

    /** 拒绝理由 **/
    private String refuseReason;

    /**
     * 政策返利规则Id
     */
    private String extraRebateId;

    public RebatePlus() {
        super();
    }

    /** 政策id */
    public String getStrategyId() {
        return strategyId;
    }

    /** 政策id */
    public void setStrategyId(String strategyId) {
        this.strategyId = strategyId;
    }

    /** 产品id */
    public String getProductId() {
        return productId;
    }

    /** 产品id */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /** 政策返利规则Id */
    public String getExtraRebateId() {
        return extraRebateId;
    }

    /** 政策返利规则Id */
    public void setExtraRebateId(String extraRebateId) {
        this.extraRebateId = extraRebateId;
    }

    /** 状态集合 */
    public List<Long> getStatusList() {
        return statusList;
    }

    /** 状态集合 */
    public void setStatusList(List<Long> statusList) {
        this.statusList = statusList;
    }

    /** 渠道Id */
    public String getChannelId() {
        return channelId;
    }

    /** 渠道Id */
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    /** 是否通过 */
    public String getStatus() {
        return status;
    }

    /** 是否通过 */
    public void setStatus(String status) {
        this.status = status;
    }

    /** 拒绝理由 */
    public String getRefuseReason() {
        return refuseReason;
    }

    /** 拒绝理由 */
    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }

    public static SysSpcreRelationKey toConver(RebatePlus from) {
        if (from == null) {
            return null;
        }
        SysSpcreRelationKey to = new SysSpcreRelationKey();
        to.setProductId(from.getProductId());
        to.setStrategyId(from.getStrategyId());
        to.setStatusList(from.getStatusList());
        to.setChannelId(from.getChannelId());
        to.setStatus(from.getStatus());
        to.setRefuseReason(from.getRefuseReason());
        to.setExtraRebateId(from.getExtraRebateId());
        return to;
    }

    public static RebatePlus fromConver(SysSpcreRelationKey from) {
        if (from == null) {
            return null;
        }
        RebatePlus to = new RebatePlus();
        to.setProductId(from.getProductId());
        to.setStrategyId(from.getStrategyId());
        to.setStatusList(from.getStatusList());
        to.setChannelId(from.getChannelId());
        to.setStatus(from.getStatus());
        to.setRefuseReason(from.getRefuseReason());
        to.setExtraRebateId(from.getExtraRebateId());
        return to;
    }
}
