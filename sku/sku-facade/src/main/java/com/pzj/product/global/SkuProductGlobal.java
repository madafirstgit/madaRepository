package com.pzj.product.global;

public class SkuProductGlobal {
    /** 产品是否是无限库存:是*/
    public static final Integer IS_UNLIMITED_INVENTORY           = 1;
    /** 产品是否是无限库存:否*/
    public static final Integer IS_NOT_UNLIMITED_INVENTORY        = 0;
    
    /** 产品是否可买:可以*/
    public static final Integer isCanSaled_yes                   = 1;
    /** 产品是否可买:不可以*/
    public static final Integer isCanSaled_no                    = 0;
    

    /** 产品入园方式: 凭码入园*/
    public static final Integer IN_BY_CODE                       = 1;
    /** 产品入园方式: 换票入园*/
    public static final Integer IN_BY_TICKET                     = 2;

    /** 产品是否需要绑定景点:需要*/
    public static final Integer NEED_SCENIC                      = 1;
    /** 产品是否需要绑定景点:不需要*/
    public static final Integer NOT_NEED_SCENIC                  = 0;

    /** 下单是否填写游玩时间:需要 */
    public static final Integer NEED_PLAYTIME                    = 1;
    /** 下单是否填写游玩时间:不需要 */
    public static final Integer NOT_NEED_PLAYTIME                = 0;

    /** 不填写游玩时间下单计算时间类型：产品可用日期内有效*/
    public static final Integer IS_PRODUCT_DATE                  = 1;
    /** 不填写游玩时间下单计算时间类型：订单支付成功后有效*/
    public static final Integer AFTER_ORDER_DATE                 = 2;

    /** 二次确认: 是*/
    public static final Integer IS_TWICE_SURE                    = 1;
    /** 二次确认: 否*/
    public static final Integer IS_NOT_TWICE_SURE                = 0;

    /** 是否代下单： 是*/
    public static final Integer IS_NEED_TAKE_ORDER               = 1;
    /** 是否代下单：否*/
    public static final Integer IS_NOT_NEED_TAKE_ORDER           = 0;

    /** 是否手动清算:是*/
    public static final Integer IS_MANUAL_VERIFICATION           = 1;
    /** 是否手动清算:否*/
    public static final Integer IS_NOT_MANUAL_VERIFICATION       = 0;

    /** 清算类型:核销后自动清算*/
    public static final Integer VERIFICATION_TYPE_CHECKIN        = 1;

    /** 清算类型:核销后固定时间清算*/
    public static final Integer VERIFICATION_TYPE_PALYTIME_AFTER = 2;
    
    /** 清算金额类型: 固定比例 */
    public static final Integer VERIFICATION_MONEY_TYPE_RADIO          = 1;
    /** 清算金额类型: 固定金额 */
    public static final Integer VERIFICATION_MONEY_TYPE_VALUE          = 2;
    /** 清算金额类型: 全额清算 */
    public static final Integer VERIFICATION_MONEY_TYPE_ALL            = 3;
    /** 清算金额类型: 不清算 */
    public static final Integer VERIFICATION_MONEY_TYPE_NO             = 4;
    
    

    /** 提前预订是否限制: 是*/
    public static final Integer IS_LIMIT_ADVANCE_DUE             = 1;
    /** 提前预订是否限制: 否*/
    public static final Integer IS_NOT_LIMIT_ADVANCE_DUE         = 0;

    /** 延迟消费是否限制: 是*/
    public static final Integer IS_LIMIT_DELAY_CONSUME           = 1;
    /** 延迟消费是否限制: 否*/
    public static final Integer IS_NOT_LIMIT_DELAY_CONSUME       = 0;
    
    /****退款常量start********************************************************************/
    
    /** 是否可退款: 是*/
    public static final Integer IS_NEED_REFUND           = 1;      
    /** 是否可退款: 否*/
    public static final Integer IS_NOT_NEED_REFUND           = 0;  
    
    
    /** 退款日期类型: 出游日期*/
    public static final Integer REFUND_DATE_TYPE_PLAYTIME        = 1;

    /** 退款日期类型: 产品可用日期结束当天*/
    public static final Integer REFUND_DATE_TYPE_LASTTIME        = 2;

    /** 退款金额类型: 固定比例 */
    public static final Integer REFUND_MONEY_TYPE_RADIO          = 1;
    /** 退款金额类型: 固定金额 */
    public static final Integer REFUND_MONEY_TYPE_VALUE          = 2;
    /** 退款金额类型: 全额退款 */
    public static final Integer REFUND_MONEY_TYPE_ALL            = 3;
    /** 退款金额类型: 不退款 */
    public static final Integer REFUND_MONEY_TYPE_NO             = 4;       
    
    /** 退款数量类型: 整单退 */
    public static final Integer REFUND_QUANTITY_TYPE_ALL           = 1;  
    /** 退款数量类型: 部分退 */
    public static final Integer REFUND_QUANTITY_TYPE_PART           = 2;
    
    /****退款常量end********************************************************************/
    
    /** 时间单位: 年*/
    public static final Integer DATE_UNIT_YEAR                    = 9;
    
    /** 时间单位: 季度*/
    public static final Integer DATE_UNIT_QUARTER                    = 8;
    
    /** 时间单位: 月*/
    public static final Integer DATE_UNIT_MONTH                    = 7;
    
    /** 时间单位: 旬*/
    public static final Integer DATE_UNIT_TEN                      = 6;
    
    /** 时间单位: 星期*/
    public static final Integer DATE_UNIT_WEEK                     = 5;
    
    /** 时间单位: 天*/
    public static final Integer DATE_UNIT_DAY                    = 4;

    /** 时间单位: 时*/
    public static final Integer DATE_UNIT_HOUR                   = 3;

    /** 时间单位: 分*/
    public static final Integer DATE_UNIT_MINUTE                 = 2;
    
    
    /** 时间单位: 分*/
    public static final Integer DATE_UNIT_SECOND                 = 1;


    
    

  
    
    /** 库存产品绑定关系 ：与产品组绑定*/
    public static final Integer RELATION_WITH_SPU                 = 1;
    
    /** 库存产品绑定关系 ：与产品绑定*/
    public static final Integer RELATION_WITH_SKU                 = 2;
    
    /** 逾期清算规则日期类型 : 游玩有效期结束后*/
    public static final Integer OVERDUE_DATE_AFTER_PLAYTIME = 1;
    
    
    /** 产品消费凭证类型 ：未凭证*/
    public static final  Integer CONSUMER_CARDTYPE_NO = 0;
    
    /** 产品消费凭证类型 ：联系人信息*/
    public static final  Integer CONSUMER_CARDTYPE_CONTACTS = 1;
    
    /** 产品消费凭证类型 ：魔方码*/
    public static final  Integer CONSUMER_CARDTYPE_MFOUTRCODE = 2;
    
    /** 产品消费凭证类型 ：身份证*/
    public static final  Integer CONSUMER_CARDTYPE_IDCARD = 3;
    
    
    
    /** 产品票型：散票 */
    public static final Integer SCATTER_TICKET_VARIE = 0;
    
    /** 产品票型：团票 */
    public static final Integer GROUP_TICKET_VARIE = 1;
    
    /** 政策优先：直签*/
    public static final int DIRECT_STRATEGY_FIRST = 1;
        
    /** 政策优先：分销*/
    public static final int DISTRIBUTION_STRATEGY_FIRST = 2;
    
    
    
    
    

    public static void main(String[] args) {
        String str = "distribution_Strategy_first";
        System.out.println("str = " + str.toUpperCase());
    }

}
