package com.pzj.base.common.global.product;

public class GlobalPorduct {
    public static class FLAG {
        public final static String FLAG_ENABLE  = "1";

        public final static String FLAG_DISABLE = "0";

        public final static String FLAG_ARCHIVE = "2";
    }

    public static class Allocation {
        /** 按天 */
        public final static String DAY      = "D";

        /** 按晚 */
        public final static String NIGHT    = "N";

        /** 按小时 */
        public final static String HOUR     = "H";

        /** 按时间段 */
        public final static String TimeSlot = "TS";

    }

    /**
     * @Author :DongChf
     * @Date :2016年6月5日
     * @Describe:景区退换票时间 对应 TicketRule的 timeType 属性
     */
    public static class TicketRuleType {
        /** 不限 */
        public final static Integer NO_RULE      = 1;
        /** 游玩日期当日 */
        public final static Integer DATE_CURRENT = 2;
        /** 游玩日期前 */
        public final static Integer DATE_BEFORE  = 3;
        /** 游玩日期后 */
        public final static Integer DATE_AFTER   = 4;
        /** 开演时间前 */
        public final static Integer PLAY_BEFORE  = 5;
        /** 演出结束前 */
        public final static Integer STOP_BEFOR   = 6;
    }

    /**
     * @Author :DongChf
     * @Date :2016年6月5日
     * @Describe:产品退款政策
     */
    public static class ProductRuleType {
        /** 不可退 */
        public final static Integer REFUSED    = 7;
        /** 固定时间可退 */
        public final static Integer FIXED_TIME = 8;
    }

    /**
     * @Author :DongChf
     * @Date :2016年6月14日
     * @Describe:扣费方式
     */
    public static class PaymentType {
        /** 固定金额 */
        public final static Byte FIXED   = 1;
        /** 下单比例 */
        public final static Byte PERCENT = 2;
    }
}
