package com.pzj.base.entity.product;

import java.io.Serializable;

import com.pzj.base.common.BaseEntity;

/**
 * 结算消息状态
 * 
 * @author apple
 * 
 */
public class ProductBalance extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 7729118780135388217L;

    private String            messageState;

    private String            balanceState;

    private String            message;

    public String getMessageState() {
        return messageState;
    }

    public void setMessageState(String messageState) {
        this.messageState = messageState == null ? null : messageState.trim();
    }

    public String getBalanceState() {
        return balanceState;
    }

    public void setBalanceState(String balanceState) {
        this.balanceState = balanceState == null ? null : balanceState.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }
}