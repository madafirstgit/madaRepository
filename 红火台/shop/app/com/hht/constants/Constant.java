package com.hht.constants;

/**
 * @author panghui
 * @version 1.0
 * @since 2016/11/18
 */
public class Constant {

    // 生成菜单编号前缀
    public static final String MENU_CODE = "menu";

    // 生成账单编号前缀
    public static final String BILL_CODE = "bill";
    //清台状态
    public static final String  RESULT_CODE="0";//;成功
    public static final String  RESULT_FLAGCODE="1";//;失败


    //请求结果
    public static final int RESULT_CODE_SUCCESS = 0;
    public static final int RESULT_CODE_FAIL = 1;


    // 操作结果   1-成功，0-失败
    public static final int RESULT_SUCCESS = 1;
    public static final int RESULT_FAIL = 0;

    /**查询类型*/
    public final static String SCHEDULE_TYPE_PAY = "PAY";           //支付方式
    public final static String SCHEDULE_TYPE_ACCOUNT = "ACCOUNT";   //员工
    public final static String SCHEDULE_TYPE_DISCOUNT = "DISCOUNT"; //折扣
    public final static String SCHEDULE_TYPE_TABLE = "TABLE";       //桌位
    public final static String SCHEDULE_TYPE_DISH_INFO = "DISH";    //菜品
    public final static String SCHEDULE_TYPE_DISH_TASTE = "TASTE";  //口味
    public final static String SCHEDULE_TYPE_DISH_COOK = "COOK";    //做法

}
