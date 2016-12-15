package com.hht.models;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 结算账单表
 * Created by WuJiaWen on 2016/11/21.
 */
public class YBillAccount {
    /**ID*/
    private String id;
    /**账单编号*/
    private String billNo;
    /**应付金额*/
    private BigDecimal total;
    /**实付金额*/
    private BigDecimal payAmount;
    /**账单状态: 1-未支付 2-已支付*/
    private int status = 1;
    /**创建时间*/
    private Date createTime;
    /**备注*/
    private String remark;

    public final static int BILL_STATUS_NOT_PAY = 1;//待支付
    public final static int BILL_STATUS_PAY = 2;    //已支付
    public final static int BILL_STATUS_REFUND = 3; //已退款

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }


    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo == null ? null : billNo.trim();
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
