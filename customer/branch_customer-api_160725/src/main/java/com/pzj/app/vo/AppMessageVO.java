/*
 * AppMessage.java
 
 * www.piaozhijia.com
 */
package com.pzj.app.vo;

import java.io.Serializable;

import com.pzj.base.common.BaseVO;

/**
 * vo.信息通知
 * 
 * @author 票之家
 */

public class AppMessageVO extends BaseVO implements Serializable {
    /** 标题 */
    private String title;
    /**  */
    private java.util.Date createTime;
    /** 内容 */
    private String content;
    /** 状态 */
    private Integer status;
    /** 用户id */
    private Long userId;

    /** 设置 标题 */
    public void setTitle(String title) {
        this.title = title;
    }

    /** 得到 标题 */
    public String getTitle() {
        return title;
    }

    /** 设置 */
    public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }

    /** 得到 */
    public java.util.Date getCreateTime() {
        return createTime;
    }

    /** 设置 内容 */
    public void setContent(String content) {
        this.content = content;
    }

    /** 得到 内容 */
    public String getContent() {
        return content;
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
        strBuff.append("title:").append(this.getTitle()).append(",");
        strBuff.append("createTime:").append(this.getCreateTime()).append(",");
        strBuff.append("content:").append(this.getContent()).append(",");
        strBuff.append("status:").append(this.getStatus()).append(",");
        strBuff.append("userId:").append(this.getUserId());
        strBuff.append("}");
        return strBuff.toString();
    }
}
