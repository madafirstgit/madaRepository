package com.hht.service.impl;

import com.hht.mapper.YBillAccountMapper;
import com.hht.mapper.YBillDetailMapper;
import com.hht.mapper.YNotifyLogMapper;
import com.hht.models.YBillAccount;
import com.hht.models.YBillDetail;
import com.hht.models.YNotifyLog;
import com.hht.service.ReceiveAlipayNotifyService;
import com.hht.utils.DateUtil;
import com.hht.utils.UUidUtil;
import com.hht.utils.alipay.AlipayNotify;
import org.apache.commons.lang3.StringUtils;
import play.data.DynamicForm;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/28.
 */
public class ReceiveAlipayNotifyServiceImpl implements ReceiveAlipayNotifyService{
    private static final Object lock = new Object();
    private YNotifyLogMapper yNotifyLogMapper;
    private YBillAccountMapper yBillAccountMapper;
    private YBillDetailMapper yBillDetailMapper;

    @Inject
    public ReceiveAlipayNotifyServiceImpl(YNotifyLogMapper yNotifyLogMapper,YBillAccountMapper yBillAccountMapper,
                                          YBillDetailMapper yBillDetailMapper){
        this.yNotifyLogMapper = yNotifyLogMapper;
        this.yBillAccountMapper = yBillAccountMapper;
        this.yBillDetailMapper = yBillDetailMapper;
    }

    /**
     * 保存支付宝回调信息
     * @param form
     * @return
     */
    @Override
    public boolean receiveNotify(DynamicForm form,Map<String,String[]> map){
        Boolean flag = Boolean.FALSE;
        try {

            //获取支付宝回调参数，验证
            YNotifyLog aliEntity = this.getAliNotifyParams(form,map);
            if(aliEntity==null)
                return flag;

            //保存回调记录
            aliEntity.setPayType(YNotifyLog.PAY_TYPE_ALIPAY);
            yNotifyLogMapper.insert(aliEntity);

            if(!"TRADE_SUCCESS".equalsIgnoreCase(aliEntity.getTradeStatus()))
                return flag;

            System.out.println("根据orderId="+aliEntity.getBillNo()+"获取订单类型信息");

            //查询订单类型
            YBillAccount yBillAccount = yBillAccountMapper.selectByBillNo(aliEntity.getBillNo());
            if(yBillAccount==null)
                throw new RuntimeException("根据orderId="+aliEntity.getBillNo()+"没有找到相应订单汇总信息");

            if((yBillAccount.getTotal().subtract(yBillAccount.getPayAmount())).compareTo(new BigDecimal(aliEntity.getAmount()))>0)
                throw new RuntimeException("支付宝支付返回金额和订单金额不匹配");

            if(yBillAccount.getStatus().intValue()==YBillAccount.BILL_STATUS_PAY){
                System.out.println("orderId="+aliEntity.getBillNo()+"已经支付");
                return true;
            }

            if(yBillAccount.getStatus().intValue()==YBillAccount.BILL_STATUS_NOT_PAY){
                synchronized (lock) {
                    yBillAccount = yBillAccountMapper.selectByBillNo(aliEntity.getBillNo());
                    if(yBillAccount==null)
                        throw new RuntimeException("根据orderId="+aliEntity.getBillNo()+"没有找到相应订单汇总信息");

                    if(yBillAccount.getStatus().intValue()==YBillAccount.BILL_STATUS_PAY){
                        System.out.println("orderId="+aliEntity.getBillNo()+"已经支付");
                        return true;
                    }

                    if((yBillAccount.getTotal().subtract(yBillAccount.getPayAmount())).compareTo(new BigDecimal(aliEntity.getAmount()))>0)
                        throw new RuntimeException("支付宝支付返回金额和订单金额不匹配");

                    //保存支付明细表
                    YBillDetail yBillDetail = new YBillDetail();
                    yBillDetail.setId(UUidUtil.generateId());//用户id

                    yBillDetail.setPayAmount(new BigDecimal(aliEntity.getAmount()));//交易金额
                    yBillDetail.setPayTime(new Date());//支付时间
                    yBillDetail.setTradeNo(aliEntity.getTradeNo());//第三方支付流水id
                    yBillDetail.setBillNo(aliEntity.getBillNo());//订单号
                    yBillDetail.setPayType(YNotifyLog.PAY_TYPE_ALIPAY);//支付方式
                    yBillDetailMapper.insert(yBillDetail);
                    //修改订单汇总
                    yBillAccount.setPayAmount(yBillAccount.getPayAmount().add(new BigDecimal(aliEntity.getAmount())));
                    yBillAccount.setStatus(YBillAccount.BILL_STATUS_PAY);
                    yBillAccountMapper.updateByPrimaryKey(yBillAccount);
                }

            }
            flag = Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    @Override
    public boolean refundNotify(DynamicForm form) throws Exception{
        Map<String,String> params = form.get().getData();
        //验证
        if(!AlipayNotify.verify(params)){
    System.out.println("支付宝退款回调参数验证失败");
            return Boolean.FALSE;
        }

        String billNO = params.get("out_trade_no");//商户订单号
        String tradeNo = params.get("trade_no");//支付宝交易号
        String buyerUserId = params.get("buyer_user_id");//买家支付宝ID
        String refundTime =params.get("gmt_refund_pay");//退款时间
        String refundFee = params.get("refund_fee");//退款金额
//        String fundChange = params.get("fund_change");//退款是否发生资金变化
//        String send_back_fee = params.get("send_back_fee"); //实际退款金额
        if(StringUtils.isBlank(billNO)||StringUtils.isBlank(tradeNo)
                ||StringUtils.isBlank(buyerUserId)||StringUtils.isBlank(refundTime)
                ||StringUtils.isBlank(refundFee)){
    System.out.println("支付宝退款回调参数无效");
            throw new RuntimeException("支付宝退款回调参数无效");
        }

        YNotifyLog yNotifyLog = new YNotifyLog(billNO,tradeNo,buyerUserId,refundFee, DateUtil.StrToDate(refundTime));
        yNotifyLog.setPayType(YNotifyLog.PAY_TYPE_ALIPAY);
        //保存回调记录
        yNotifyLogMapper.insert(yNotifyLog);
        //查询订单类型
        YBillAccount yBillAccount = yBillAccountMapper.selectByBillNo(billNO);
        if(yBillAccount==null)
            throw new RuntimeException("根据billNo="+yBillAccount.getBillNo()+"没有找到相应订单汇总信息");

        if(yBillAccount.getStatus() == YBillAccount.BILL_STATUS_REFUND){
    System.out.println("billNo="+yBillAccount.getBillNo()+"已退款");
            return Boolean.TRUE;
        }else if(yBillAccount.getStatus() == YBillAccount.BILL_STATUS_PAY){
            synchronized (lock){
                yBillAccount.setStatus(YBillAccount.BILL_STATUS_REFUND);
                yBillAccountMapper.updateByPrimaryKey(yBillAccount);
            }
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    /**
     * @Description:支付宝支付回调
     */
    private YNotifyLog getAliNotifyParams(DynamicForm form,Map<String,String[]> map) throws Exception{

        YNotifyLog aliEntity = new YNotifyLog();

        try {

            System.out.println("******支付宝支付回调开始******");

            Map<String,String> params = new HashMap<String,String>();
            for (Iterator iter = map.keySet().iterator(); iter.hasNext();) {
                String name = (String) iter.next();
                String[] values = map.get(name);
                String valueStr = "";
                for (int i = 0; i < values.length; i++) {
                    valueStr = (i == values.length - 1) ? valueStr + values[i]
                            : valueStr + values[i] + ",";
                }
                //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
                params.put(name, valueStr);
            }

            System.out.println("支付宝支付回调参数resultParam="+params);

            //验证
            if(!AlipayNotify.verify(params)){
                System.out.println("支付宝支付回调参数验证失败");
                return null;
            }

            String out_trade_no = String.valueOf(form.get("out_trade_no"));//商户订单号
            String trade_no = String.valueOf(form.get("trade_no"));//支付宝交易号
            String trade_status = String.valueOf(form.get("trade_status"));//交易状态
            String total_fee =String.valueOf(form.get("total_fee"));//交易金额
            String sign_type = String.valueOf(form.get("sign_type"));//签名方式
            String buyer_email = String.valueOf(form.get("buyer_email"));//支付账号
            String gmt_create = String.valueOf(form.get("gmt_create"));//订单创建时间
            String gmt_payment = String.valueOf(form.get("gmt_payment"));//交易付款时间

            if(StringUtils.isBlank(out_trade_no) || StringUtils.isBlank(trade_no) ||
                    StringUtils.isBlank(trade_status) || StringUtils.isBlank(total_fee) ||
                    StringUtils.isBlank(sign_type)){
                System.out.println("支付宝支付回调参数无效");
                throw new RuntimeException("支付宝支付回调参数无效");
            }

            aliEntity.setAmount(total_fee);
            aliEntity.setBuyerEmail(buyer_email);
            aliEntity.setGmtCreate(gmt_create);
            aliEntity.setGmtPayment(gmt_payment);
            aliEntity.setBillNo(out_trade_no);
            aliEntity.setTradeNo(trade_no);
            aliEntity.setSignType(sign_type);
            aliEntity.setTradeStatus(trade_status);
            aliEntity.setCreateTime(new Date());
            return aliEntity;
        } catch (Exception e) {
            System.out.println("支付宝支付回调参数验证异常");
            throw e;
        }

    }

}
