/*
 * AppFeedback.java
 
 * www.piaozhijia.com
 */
package com.pzj.base.entity.app;

import java.util.Date;
import java.io.Serializable;
import java.math.BigDecimal;

import com.pzj.base.common.BaseEntity;
/**
 * vo.意见反馈
 * @author 票之家
 */

public class AppFeedback extends BaseEntity implements Serializable{
    /** 用户id */
    private Long userId;
    /** 内容 */
    private String content;
    /** 电话 */
    private String phone;
    /**  */
    private java.util.Date createTime;
    /** 反馈意见 */
    private String feedbackScenario;
 
    /** 设置 用户id */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /** 得到 用户id */
    public Long getUserId() {
        return userId;
    }
    /** 设置 内容 */
    public void setContent(String content) {
        this.content = content;
    }

    /** 得到 内容 */
    public String getContent() {
        return content;
    }
    /** 设置 电话 */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /** 得到 电话 */
    public String getPhone() {
        return phone;
    }
    /** 设置  */
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    /** 得到  */
    public java.util.Date getCreateTime() {
        return createTime;
    }
    /** 设置 反馈意见 */
    public void setFeedbackScenario(String feedbackScenario) {
        this.feedbackScenario = feedbackScenario;
    }

    /** 得到 反馈意见 */
    public String getFeedbackScenario() {
        return feedbackScenario;
    }

    @Override
    public String toString() {
        StringBuilder strBuff = new StringBuilder();
        strBuff.append(this.getClass().getName() + ":{");	
        strBuff.append("id:").append(this.getId()).append(",");
        strBuff.append("userId:").append(this.getUserId()).append(",");
        strBuff.append("content:").append(this.getContent()).append(",");
        strBuff.append("phone:").append(this.getPhone()).append(",");
        strBuff.append("createTime:").append(this.getCreateTime()).append(",");
        strBuff.append("feedbackScenario:").append(this.getFeedbackScenario());
        strBuff.append("}");
        return strBuff.toString();
    }
}
