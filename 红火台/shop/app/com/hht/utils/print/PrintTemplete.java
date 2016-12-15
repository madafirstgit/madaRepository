package com.hht.utils.print;

import java.io.*;
import java.net.Socket;

public class PrintTemplete {



	public static byte[] clientPaper()
	{

		try {
			byte[] next2Line = printerCmdUtils.nextLine(2);
			byte[] title = "出餐单（午餐）**万通中心店".getBytes("UTF-8");

			byte[] boldOn = printerCmdUtils.boldOn();
			byte[] fontSize2Big = printerCmdUtils.fontSizeSetBig(3);
			byte[] center= printerCmdUtils.alignCenter();
			byte[] Focus = "网 507".getBytes("UTF-8");
			byte[] boldOff = printerCmdUtils.boldOff();
			byte[] fontSize2Small = printerCmdUtils.fontSizeSetSmall(3);

			byte[] left= printerCmdUtils.alignLeft();
			byte[] orderSerinum = "订单编号：11234".getBytes("UTF-8");
			boldOn = printerCmdUtils.boldOn();
			byte[] fontSize1Big = printerCmdUtils.fontSizeSetBig(2);
			byte[] FocusOrderContent = "韭菜鸡蛋饺子-小份（单）".getBytes("UTF-8");
			boldOff = printerCmdUtils.boldOff();
			byte[] fontSize1Small = printerCmdUtils.fontSizeSetSmall(2);


			next2Line = printerCmdUtils.nextLine(2);

			byte[] priceInfo = "应收:22元 优惠：2.5元 ".getBytes("UTF-8");
			byte[] nextLine = printerCmdUtils.nextLine(1);

			byte[] priceShouldPay = "实收:19.5元".getBytes("UTF-8");
			nextLine = printerCmdUtils.nextLine(1);

			byte[] takeTime = "取餐时间:2015-02-13 12:51:59".getBytes("UTF-8");
			nextLine = printerCmdUtils.nextLine(1);
			byte[] setOrderTime = "下单时间：2015-02-13 12:35:15".getBytes("UTF-8");

			byte[] tips_1 = "微信关注\"***\"自助下单每天免1元".getBytes("UTF-8");
			nextLine = printerCmdUtils.nextLine(1);
			byte[] tips_2 = "饭后点评再奖5毛".getBytes("UTF-8");
			nextLine = printerCmdUtils.nextLine(1);

			byte[] breakPartial = printerCmdUtils.feedPaperCutPartial();

			byte[][] cmdBytes= {
					title,nextLine,
					center,boldOn,fontSize2Big,Focus,boldOff,fontSize2Small,next2Line,
					left,orderSerinum,nextLine,
					center,boldOn,fontSize1Big,FocusOrderContent,boldOff,fontSize1Small,nextLine,
					left,next2Line,
					priceInfo,nextLine,
					priceShouldPay,next2Line,
					takeTime,nextLine,
					setOrderTime,next2Line,
					center,tips_1,nextLine,
					center,tips_2,next2Line,
					breakPartial
			};

			return printerCmdUtils.byteMerger(cmdBytes);

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;





	}

	/**
	 * 外送模板
	 * @param
	 * @return
	 */
	public static byte[] deliverTemplate()
	{
		String title = "派送单（晚餐）五味万通中心店";
		//String title = "派送单";
		String send_num = "网 570";
		String send_order_id = "订单编号:  151723";
		String name = "联系人:  王原";
		String contact_phone = "联系电话:  185 1342 4716";
		String contact_address = "送餐地址:  万通中心 C座906室";

		int index = 0;
		byte[] resultByte = new byte[3000];
		byte[] finalByte = null;

		try {
			byte[] huanhang = {0x0a};
			byte[] huan2hang = {0x0a,0x0a};
			byte[] huan3hang = {0x0a,0x0a,0x0a};

			byte[] jiacu = {0x1b,0x21,8};
			byte[] jiacQuXiao = {0x1b,0x21,0};

			byte[] zitifangda = {0x1b,0x21,(byte)24};
			byte[] zitifangdaQuxiao = {0x1b,0x21,0};


			byte[] center = {0x1b,0x61,2};
			byte[] centerQuxiao = {0x1b,0x61,0};


			byte[] titleByte = title.getBytes("UTF-8");
			byte[] sendNumByte = send_num.getBytes("UTF-8");
			byte[] sendOrderId = send_order_id.getBytes("UTF-8");
			byte[] nameByte = name.getBytes("UTF-8");
			byte[] contactPhoneByte = contact_phone.getBytes("UTF-8");
			byte[] contactAddressByte = contact_address.getBytes("UTF-8");
			byte[] breakPartial = printerCmdUtils.feedPaperCutPartial();

			byte[][] param = {

					huan3hang,
					titleByte,
					huanhang,


					center,
					sendNumByte,
					centerQuxiao,
					huanhang,

					sendOrderId,
					huan2hang,

					nameByte,
					huanhang,

					contactPhoneByte,
					huanhang,

					contactAddressByte,
					huan2hang,
					breakPartial,
			};

			for(int i=0;i<param.length;i++)
			{
				resultByte = connectByte(resultByte, param[i], index);
				index = calResultByteLength(index, param[i]);
			}



			finalByte = new byte[index];
			System.arraycopy(resultByte, 0,finalByte,0, index);
			//CommonUtils.LogWuwei(tag, "^_^"+"index now is "+index+" resultByte is :"+EncodingUtils.getString(finalByte, "UTF-8"));
			resultByte = null;


		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return finalByte;
	}









	public static byte[] connectByte(byte[] resultByte,byte[] srcByte,int dstPos)
	{
		System.arraycopy(srcByte,0, resultByte, dstPos, srcByte.length);
		
		return resultByte;
		
	}
	
	
	public static int calResultByteLength(int now_index,byte[] src)
	{
		now_index = now_index + src.length;
		return now_index;
	}


}
