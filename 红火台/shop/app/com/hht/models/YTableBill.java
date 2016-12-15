package com.hht.models;

import java.math.BigDecimal;

public class YTableBill {

    private String id;
    //桌位编号
    private String tableCode;
    //桌位名称
    private String tableName;
    //服务员工号
    private String operatorId;
    //消费人数
    private Integer personNum;
    //账单金额
    private BigDecimal billAmount;
    //菜品金额
    private BigDecimal dishAmount;
    //服务费
    private BigDecimal serverAmount;
    //折扣金额
    private BigDecimal discountAmount;
    //折让金额
    private BigDecimal allowanceAmount;
    //菜单编号
    private String dishListCode;
    //账单编号
    private String billNo;
    //账单表
    private YBillAccount yBillAccount;
    //账单折扣表
    private YAccountDiscountInfo yAccountDiscountInfo;

    public YAccountDiscountInfo getyAccountDiscountInfo() {
        return yAccountDiscountInfo;
    }

    public void setyAccountDiscountInfo(YAccountDiscountInfo yAccountDiscountInfo) {
        this.yAccountDiscountInfo = yAccountDiscountInfo;
    }

    public YBillAccount getyBillAccount() {
        return yBillAccount;
    }

    public void setyBillAccount(YBillAccount yBillAccount) {
        this.yBillAccount = yBillAccount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTableCode() {
        return tableCode;
    }

    public void setTableCode(String tableCode) {
        this.tableCode = tableCode == null ? null : tableCode.trim();
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    public Integer getPersonNum() {
        return personNum;
    }

    public void setPersonNum(Integer personNum) {
        this.personNum = personNum;
    }

    public BigDecimal getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(BigDecimal billAmount) {
        this.billAmount = billAmount;
    }

    public BigDecimal getDishAmount() {
        return dishAmount;
    }

    public void setDishAmount(BigDecimal dishAmount) {
        this.dishAmount = dishAmount;
    }

    public BigDecimal getServerAmount() {
        return serverAmount;
    }

    public void setServerAmount(BigDecimal serverAmount) {
        this.serverAmount = serverAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getAllowanceAmount() {
        return allowanceAmount;
    }

    public void setAllowanceAmount(BigDecimal allowanceAmount) {
        this.allowanceAmount = allowanceAmount;
    }

    public String getDishListCode() {
        return dishListCode;
    }

    public void setDishListCode(String dishListCode) {
        this.dishListCode = dishListCode == null ? null : dishListCode.trim();
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo == null ? null : billNo.trim();
    }
}