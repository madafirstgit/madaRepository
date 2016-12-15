package com.hht.models;

import com.hht.utils.UUidUtil;

import java.util.Date;

public class YNotifyLog {

    private String id;
    //订单编号
    private String billNo;
    //支付宝流水编号
    private String tradeNo;
    //买家支付宝ID
    private String buyerEmail;
    //签名方式
    private String signType;
    //交易状态
    private String tradeStatus;
    //交易金额
    private String amount;
    //订单创建日期
    private String gmtCreate;
    //交易付款时间
    private String gmtPayment;
    //退款状态
    private String refundStatus;
    //退款时间
    private Date gmtRefund;
    //创建时间
    private Date createTime;
    //支付方式
    private String payType;

    public final static String PAY_TYPE_ALIPAY="ALIPAY";
    public final static String PAY_TYPE_WX="WX";

    public YNotifyLog(){}

    //退款构造方法
    public YNotifyLog(String billNo,String tradeNo,String buyerEmail,
                      String amount,Date gmtRefund){
        this.id = UUidUtil.generateId();
        this.billNo = billNo;
        this.tradeNo = tradeNo;
        this.buyerEmail = buyerEmail;
        this.amount = amount;
        this.gmtRefund = gmtRefund;
        this.refundStatus = "已退款";
        this.createTime = new Date();
    }

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

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail == null ? null : buyerEmail.trim();
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType == null ? null : signType.trim();
    }

    public String getTradeStatus() {
        return tradeStatus;
    }

    public void setTradeStatus(String tradeStatus) {
        this.tradeStatus = tradeStatus == null ? null : tradeStatus.trim();
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount == null ? null : amount.trim();
    }

    public String getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate == null ? null : gmtCreate.trim();
    }

    public String getGmtPayment() {
        return gmtPayment;
    }

    public void setGmtPayment(String gmtPayment) {
        this.gmtPayment = gmtPayment == null ? null : gmtPayment.trim();
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus == null ? null : refundStatus.trim();
    }

    public Date getGmtRefund() {
        return gmtRefund;
    }

    public void setGmtRefund(Date gmtRefund) {
        this.gmtRefund = gmtRefund;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }
}