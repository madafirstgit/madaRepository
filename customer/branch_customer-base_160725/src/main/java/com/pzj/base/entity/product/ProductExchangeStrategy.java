/*
 * ProductExchangeStrategy.java
 
 * www.piaozhijia.com
 */
package com.pzj.base.entity.product;

import java.io.Serializable;
import java.util.List;

import com.pzj.base.common.BaseEntity;

/**
 * vo.退换票规则
 * 
 * @author 票之家
 */

public class ProductExchangeStrategy extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -5475484120260577455L;

    private List<Long>        ids;
    /** 规则名称 */
    private String            name;

    /** 退换票时间，(产品有效期结束前的时间) */
    private Integer           beforeExpire;

    /** 退换票时间单位（1小时 2天） */
    private String            expireUnit;

    /** 退票是否扣款（1不扣款 2扣款） */
    private String            returnType;

    /** 退票扣款方式（1固定金额，2产品零售价比例） */
    private String            returnDeductType;

    /** 退票扣除数量 */
    private Integer           returnDeductQuantity;

    /** 换票是否扣款（1不扣款 2扣款） */
    private String            changeType;

    /** 换票扣款方式（1固定金额，2产品零售价比例） */
    private String            changeDeductType;

    /** 换票扣除数量 */
    private Integer           changeDeductQuantity;

    /**  */
    private String            flag;

    private String            supplierId;

    /** 设置 规则名称 */
    public void setName(String name) {
        this.name = name;
    }

    /** 得到 规则名称 */
    public String getName() {
        return name;
    }

    /** 设置 退换票时间，(产品有效期结束前的时间) */
    public void setBeforeExpire(Integer beforeExpire) {
        this.beforeExpire = beforeExpire;
    }

    /** 得到 退换票时间，(产品有效期结束前的时间) */
    public Integer getBeforeExpire() {
        return beforeExpire;
    }

    /** 设置 退换票时间单位（1小时 2天） */
    public void setExpireUnit(String expireUnit) {
        this.expireUnit = expireUnit;
    }

    /** 得到 退换票时间单位（1小时 2天） */
    public String getExpireUnit() {
        return expireUnit;
    }

    /** 设置 退票是否扣款（1不扣款 2扣款） */
    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    /** 得到 退票是否扣款（1不扣款 2扣款） */
    public String getReturnType() {
        return returnType;
    }

    /** 设置 退票扣款方式（1固定金额，2产品零售价比例） */
    public void setReturnDeductType(String returnDeductType) {
        this.returnDeductType = returnDeductType;
    }

    /** 得到 退票扣款方式（1固定金额，2产品零售价比例） */
    public String getReturnDeductType() {
        return returnDeductType;
    }

    /** 设置 退票扣除数量 */
    public void setReturnDeductQuantity(Integer returnDeductQuantity) {
        this.returnDeductQuantity = returnDeductQuantity;
    }

    /** 得到 退票扣除数量 */
    public Integer getReturnDeductQuantity() {
        return returnDeductQuantity;
    }

    /** 设置 换票是否扣款（1不扣款 2扣款） */
    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    /** 得到 换票是否扣款（1不扣款 2扣款） */
    public String getChangeType() {
        return changeType;
    }

    /** 设置 换票扣款方式（1固定金额，2产品零售价比例） */
    public void setChangeDeductType(String changeDeductType) {
        this.changeDeductType = changeDeductType;
    }

    /** 得到 换票扣款方式（1固定金额，2产品零售价比例） */
    public String getChangeDeductType() {
        return changeDeductType;
    }

    /** 设置 换票扣除数量 */
    public void setChangeDeductQuantity(Integer changeDeductQuantity) {
        this.changeDeductQuantity = changeDeductQuantity;
    }

    /** 得到 换票扣除数量 */
    public Integer getChangeDeductQuantity() {
        return changeDeductQuantity;
    }

    /** 设置 */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /** 得到 */
    public String getFlag() {
        return flag;
    }

    /** supplierId */
    public String getSupplierId() {
        return supplierId;
    }

    /** supplierId */
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        StringBuilder strBuff = new StringBuilder();
        strBuff.append(this.getClass().getName() + ":{");
        strBuff.append("id:").append(this.getId()).append(",");
        strBuff.append("name:").append(this.getName()).append(",");
        strBuff.append("beforeExpire:").append(this.getBeforeExpire()).append(",");
        strBuff.append("expireUnit:").append(this.getExpireUnit()).append(",");
        strBuff.append("returnType:").append(this.getReturnType()).append(",");
        strBuff.append("returnDeductType:").append(this.getReturnDeductType()).append(",");
        strBuff.append("returnDeductQuantity:").append(this.getReturnDeductQuantity()).append(",");
        strBuff.append("changeType:").append(this.getChangeType()).append(",");
        strBuff.append("changeDeductType:").append(this.getChangeDeductType()).append(",");
        strBuff.append("changeDeductQuantity:").append(this.getChangeDeductQuantity()).append(",");
        strBuff.append("flag:").append(this.getFlag());
        strBuff.append("}");
        return strBuff.toString();
    }
}
