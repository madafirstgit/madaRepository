package com.pzj.core.smp;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pzj.core.smp.exception.SmpException;
import com.pzj.core.smp.model.MessageModel;
import com.pzj.core.smp.service.SmsSender;



/**
 * @author mada
 *
 */
public class SmsSenderImpl implements SmsSender {
	protected Logger logger = LoggerFactory.getLogger(SmsSenderImpl.class);
	@Override
	public String smsSend(MessageModel messageModel) {
		try {
			// 参数校验
			if (messageModel == null) {
				throw new SmpException("短信发送参数为空，发送失败");
			}
			if (null == messageModel.getPhoneNum() || "".equals(messageModel.getPhoneNum())) {
				throw new SmpException("短信发送参数手机号码为空，发送失败");
			}
			if (null == messageModel.getPlatPriCode() || "".equals(messageModel.getPlatPriCode())) {
				throw new SmpException("短信发送参数业务平台优先级编号为空，发送失败");
			}
			// 手机号码合法性校验,非法的放到list中返回来，方便入库。
			List<String> illegallist = this.blackListCheck(messageModel);
			// 业务平台+优先级 编号,trade_A 校验
			
			// 数据校验:必传校验，手机号码合法性校验。
			
//		jedis.lpush(trade_A, MessageVo .tostring())
//		// 入库sms_record
//		Insert();
//		
			
		} catch (SmpException e) {
			logger.error(e.getMessage(), e);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} 
		return "ok";
	}
	
	


	
		/**
		 * @param messageModel
		 * 多个手机号码校验:合法的留下，非法的滤除且生成短信记录入库
		 */
		private List<String> blackListCheck(MessageModel messageModel) {
			try {
				String[] phoneNums = messageModel.getPhoneNum().split(",");
				List<String> illegallist = new ArrayList <String>();
				StringBuffer sb = new StringBuffer();
				for(int i=0;i<phoneNums.length;i++){
					if(!isMobile(phoneNums[i])){
						illegallist.add(phoneNums[i]);
					} else {
						if(i<phoneNums.length-2){
							sb.append(phoneNums[i]+",");
						} else {
							sb.append(phoneNums[i]);
						}
					}
				}
				messageModel.setPhoneNum(sb.toString());
				System.out.println(messageModel.getPhoneNum());
				System.out.println(illegallist);
				// 遍历blacklist，把黑名单短信添加到待人工处理表
				/*Iterator it1 = blacklist.iterator();
				while(it1.hasNext()){
				    Insert();
				}*/
				return illegallist;
			} catch (SmpException e) {
				throw new SmpException("短信发送参数手机号码可用性校验失败，发送失败");
			}
		}
		
		
	/** 
     * 单个手机号验证 
     *  
     * @param  str 
     * @return 验证通过返回true 
     */
    private boolean isMobile(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[1][3,4,5,8][0-9]{9}$"); // 验证手机号  
        m = p.matcher(str);
        b = m.matches();
        return b;
    } 
    
    
    
	public static void main(String[] args) {
		SmsSenderImpl t = new SmsSenderImpl();
//		MessageModel messageModel= null;
		MessageModel messageModel= new MessageModel();
		messageModel.setPhoneNum("18511760496,18511760496,18511760496,1851176049,18511760496");
		//t.smsSend(messageModel);
		t.blackListCheck(messageModel);
	}





}
