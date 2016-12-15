package com.hht.models;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BAccountDiscount {

    private String id;  // id

    private String discountName;  // 折扣名称

    private BigDecimal discount;   // 折扣率

    private Integer status;    // 状态

    private String createStaffId;  // 服务员id

    private Date createTime;    // 创建时间

    private Date updateTime;    //修改时间

    public String getUpdateTime() {
        SimpleDateFormat fymd = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        String uDate = fymd.format(new Date());
        return uDate;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName == null ? null : discountName.trim();
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateStaffId() {
        return createStaffId;
    }

    public void setCreateStaffId(String createStaffId) {
        this.createStaffId = createStaffId == null ? null : createStaffId.trim();
    }

    public String getCreateTime() {
        SimpleDateFormat fymd = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss");
        String cDate = fymd.format(createTime);
        return cDate;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}