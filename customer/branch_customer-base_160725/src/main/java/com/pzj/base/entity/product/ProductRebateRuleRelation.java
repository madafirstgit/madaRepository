/*
 * ProductRebateRuleRelation.java
 
 * www.piaozhijia.com
 */
package com.pzj.base.entity.product;

import java.io.Serializable;

import com.pzj.base.common.BaseEntity;

/**
 * vo.加点返产品关联类
 * 
 * @author 票之家
 */

public class ProductRebateRuleRelation extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -5907106354334335829L;

    /** 本条记录数据属于的供应商id */
    private Long              supplierId;

    /** 前置景区产品所属的供应商id */
    private String            prepositionSupplierId;

    /** 前置景区产品id */
    private String            prepositionProductId;

    /** 加点返id */
    private Long              rebateRuleId;

    private String            flag;

    /** 设置 供应商id */
    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    /** 得到 供应商id */
    public Long getSupplierId() {
        return supplierId;
    }

    /** 设置 前置景区产品id */
    public void setPrepositionProductId(String prepositionProductId) {
        this.prepositionProductId = prepositionProductId;
    }

    /** 得到 前置景区产品id */
    public String getPrepositionProductId() {
        return prepositionProductId;
    }

    /** 设置 加点返id */
    public void setRebateRuleId(Long rebateRuleId) {
        this.rebateRuleId = rebateRuleId;
    }

    /** 得到 加点返id */
    public Long getRebateRuleId() {
        return rebateRuleId;
    }

    /** 前置景区产品所属的供应商id */
    public String getPrepositionSupplierId() {
        return prepositionSupplierId;
    }

    /** 前置景区产品所属的供应商id */
    public void setPrepositionSupplierId(String prepositionSupplierId) {
        this.prepositionSupplierId = prepositionSupplierId;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        StringBuilder strBuff = new StringBuilder();
        strBuff.append(this.getClass().getName() + ":{");
        strBuff.append("id:").append(this.getId()).append(",");
        strBuff.append("supplierId:").append(this.getSupplierId()).append(",");
        strBuff.append("prepositionProductId:").append(this.getPrepositionProductId()).append(",");
        strBuff.append("rebateRuleId:").append(this.getRebateRuleId());
        strBuff.append("}");
        return strBuff.toString();
    }
}
