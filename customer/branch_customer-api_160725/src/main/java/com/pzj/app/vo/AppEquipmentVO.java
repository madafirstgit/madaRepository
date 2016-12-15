/*
 * AppEquipment.java
 
 * www.piaozhijia.com
 */
package com.pzj.app.vo;

import java.io.Serializable;

import com.pzj.base.common.BaseVO;

/**
 * vo.人员设备
 * 
 * @author 票之家
 */

public class AppEquipmentVO extends BaseVO implements Serializable {
    /**  */
    private java.util.Date createTime;
    /**  */
    private java.util.Date updateTime;
    /** 设备标识 */
    private String deviceToken;
    /** 设备类型 */
    private String deviceType;
    /** 状态 */
    private Integer status;
    /** 用户id */
    private Long userId;

    /** 设置 */
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    /** 得到 */
    public java.util.Date getCreateTime() {
        return createTime;
    }

    /** 设置 */
    public void setUpdateTime(java.util.Date updateTime) {
        this.updateTime = updateTime;
    }

    /** 得到 */
    public java.util.Date getUpdateTime() {
        return updateTime;
    }

    /** 设置 设备标识 */
    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    /** 得到 设备标识 */
    public String getDeviceToken() {
        return deviceToken;
    }

    /** 设置 设备类型 */
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    /** 得到 设备类型 */
    public String getDeviceType() {
        return deviceType;
    }

    /** 设置 状态 */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /** 得到 状态 */
    public Integer getStatus() {
        return status;
    }

    /** 设置 用户id */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /** 得到 用户id */
    public Long getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        StringBuilder strBuff = new StringBuilder();
        strBuff.append(this.getClass().getName() + ":{");
        strBuff.append("id:").append(this.getId()).append(",");
        strBuff.append("createTime:").append(this.getCreateTime()).append(",");
        strBuff.append("updateTime:").append(this.getUpdateTime()).append(",");
        strBuff.append("deviceToken:").append(this.getDeviceToken())
                .append(",");
        strBuff.append("deviceType:").append(this.getDeviceType()).append(",");
        strBuff.append("status:").append(this.getStatus()).append(",");
        strBuff.append("userId:").append(this.getUserId());
        strBuff.append("}");
        return strBuff.toString();
    }
}
