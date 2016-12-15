
package com.hht.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import javax.inject.Inject;

import com.hht.mapper.YBillAccountMapper;
import com.hht.mapper.YBillDetailMapper;
import com.hht.mapper.YNotifyLogMapper;
import com.hht.models.YBillAccount;
import com.hht.models.YBillDetail;
import com.hht.models.YNotifyLog;
import com.hht.service.ReceiveWeiXinPayNotifyService;
import com.hht.utils.UUidUtil;
import com.hht.utils.wxpay.XMLUtil;
import org.jdom.JDOMException;


public class ReceiveWeiXinPayNotifyServiceImpl implements ReceiveWeiXinPayNotifyService {

	private static final Object lock = new Object();
	private YNotifyLogMapper yNotifyLogMapper;
	private YBillAccountMapper yBillAccountMapper;
	private YBillDetailMapper yBillDetailMapper;

	@Inject
	public ReceiveWeiXinPayNotifyServiceImpl(YNotifyLogMapper yNotifyLogMapper, YBillAccountMapper yBillAccountMapper,
										  YBillDetailMapper yBillDetailMapper){
		this.yNotifyLogMapper = yNotifyLogMapper;
		this.yBillAccountMapper = yBillAccountMapper;
		this.yBillDetailMapper = yBillDetailMapper;
	}

	/**
	 * 微信支付回调
	 * @param
	 * @return
	 * @throws Exception
	 */
	@Override
	public Boolean receiveNotify(String xmlStr) throws Exception {

		Boolean flag = Boolean.FALSE;
		try {
			
			//获取微信回调参数，验证
			YNotifyLog notifyLog = this.getWeiXinNotifyParams(xmlStr);
			if(notifyLog==null)
				return flag;
			
			//保存回调记录
			notifyLog.setPayType(YNotifyLog.PAY_TYPE_WX);
			notifyLog.setId(UUidUtil.generateId());
			yNotifyLogMapper.insert(notifyLog);
			
			if(!"SUCCESS".equalsIgnoreCase(notifyLog.getTradeStatus()))
				return flag;
			
			//1：支付回调操作;2:退款回调操作
			flag = this.updateOrderOperateWhenPaySuccess(notifyLog.getBillNo(), notifyLog.getTradeNo(), notifyLog.getAmount(), notifyLog.getAmount());

		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	/**
	 * @Description:微信支付回调参数
	 */
	private YNotifyLog getWeiXinNotifyParams(String xmlStr) throws Exception{
		
		try {
			Map<String, String> map = this.getNotifyMap(xmlStr);
			if(map==null || map.isEmpty())
				throw new RuntimeException("获取微信回调参数异常");
			
			System.out.println("微信回调返回参数map:"+map);

			String out_trade_no = map.get("out_trade_no");//订单号
			String return_code = map.get("result_code");//返回结果
			String err_code = map.get("err_code");//错误结果
			String total_fee = map.get("total_fee");//订单金额
			String cash_fee = map.get("cash_fee");//支付金额
			String transaction_id = map.get("transaction_id");//微信支付流水号
			String mch_id = map.get("mch_id");//商户号
			String nonce_str = map.get("nonce_str");//随机字符串
			String sign = map.get("sign");//加密串
			String appId = map.get("appid");//微信分配的支付id
			String time_end = map.get("time_end");//支付完成时间
			
			//退款参数
			String out_refund_no = map.get("out_refund_no");//商户退款单号
			String refund_id = map.get("refund_id");//微信退款单号
			String refund_fee = map.get("refund_fee");//退款金额
			
			YNotifyLog aliEntity = new YNotifyLog();
			aliEntity.setAmount(total_fee);
			aliEntity.setBuyerEmail(mch_id);
			aliEntity.setGmtCreate(time_end);
			aliEntity.setGmtPayment(time_end);
			aliEntity.setBillNo(out_trade_no);
			aliEntity.setTradeNo(transaction_id);
			aliEntity.setSignType(sign);
			aliEntity.setTradeStatus(return_code);
			aliEntity.setCreateTime(new Date());
			return aliEntity;
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * @Description:解析微信支付回调参数
	 */
	private Map<String,String> getNotifyMap(String xmlStr) throws Exception{
		try {
			Map<String, String> map = null;
			try {
				map = XMLUtil.doXMLParse(xmlStr);
			} catch (JDOMException e) {
				throw e;
			}
			if(map==null || map.isEmpty())
				return null;
			
			return map;
		} catch (Exception e) {
			throw e;
		}
	}
	
	/**
	 * @Description:支付成功后操作订单
	 */
	private Boolean updateOrderOperateWhenPaySuccess(String billNo,
			String tradeNo,String totalAmount,String dealAmount) throws Exception{
		
		Boolean flag = Boolean.FALSE;
		try {
			
			System.out.println("根据billNo="+billNo+"获取订单类型信息");

			//查询订单类型
			YBillAccount yBillAccount = yBillAccountMapper.selectByBillNo(billNo);
			if(yBillAccount==null)
				throw new RuntimeException("根据billNo="+billNo+"没有找到相应订单汇总信息");
			
			//微信是以分为单位
			BigDecimal compareAmount = (yBillAccount.getTotal().subtract(yBillAccount.getPayAmount())).multiply(new BigDecimal(100));
			
			System.out.println("微信支付返回订单金额totalAmount="+totalAmount+"订单金额乘以100后结果amount="+compareAmount);

			if(new BigDecimal(totalAmount).compareTo(compareAmount)<0)
				throw new RuntimeException("微信支付返回订单金额和订单金额不匹配");
			
			System.out.println("订单号billNo:"+billNo+"，订单状态orderStatus="+yBillAccount.getStatus());

			if(yBillAccount.getStatus().intValue()==YBillAccount.BILL_STATUS_PAY){
				System.out.println("billNo="+billNo+"已经支付");
				return true;
			}
			
			if(yBillAccount.getStatus().intValue()==YBillAccount.BILL_STATUS_NOT_PAY){
				synchronized (lock) {
					yBillAccount = yBillAccountMapper.selectByBillNo(billNo);
					if(yBillAccount==null)
						throw new RuntimeException("根据orderId="+billNo+"没有找到相应订单汇总信息");
					
					//微信是以分为单位
					if(new BigDecimal(totalAmount).compareTo(compareAmount)<0)
						throw new RuntimeException("微信支付返回订单金额和订单金额不匹配");
					
					if(yBillAccount.getStatus().intValue()==YBillAccount.BILL_STATUS_PAY){
						System.out.println("billNo="+billNo+"已经支付");
						return true;
					}

					//保存支付明细表
					YBillDetail yBillDetail = new YBillDetail();
					yBillDetail.setId(UUidUtil.generateId());//用户id

					yBillDetail.setPayAmount(new BigDecimal(totalAmount));//交易金额
					yBillDetail.setPayTime(new Date());//支付时间
					yBillDetail.setTradeNo(tradeNo);//第三方支付流水id
					yBillDetail.setBillNo(billNo);//订单号
					yBillDetail.setPayType(YNotifyLog.PAY_TYPE_WX);//支付方式
					yBillDetailMapper.insert(yBillDetail);
					//修改订单汇总
					yBillAccount.setPayAmount(yBillAccount.getPayAmount().add(new BigDecimal(totalAmount)));
					yBillAccount.setStatus(YBillAccount.BILL_STATUS_PAY);
					yBillAccountMapper.updateByPrimaryKey(yBillAccount);
				}
				
			}
			
			flag = Boolean.TRUE;
		} catch (Exception e) {
			throw e;
		}
		
		return flag;
	}
}
