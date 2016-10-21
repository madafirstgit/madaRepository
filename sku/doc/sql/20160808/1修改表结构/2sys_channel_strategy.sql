ALTER TABLE `sys_channel_strategy`
ADD COLUMN `advance_due_days`  integer NULL COMMENT '日期前天数可预订' ,
ADD COLUMN `is_limit_advance_due`  tinyint NULL COMMENT '提前预订时间限制' ,
ADD COLUMN `advance_due_hour`  integer NULL COMMENT '日期前时刻-（时）可预订' AFTER `advance_due_days`,
ADD COLUMN `advance_due_minute`  integer NULL COMMENT '日期前时刻-（分）可预订' AFTER `advance_due_hour`,
ADD COLUMN `is_limit_delay_consume`  tinyint NULL COMMENT '延迟消费时间限制' AFTER `advance_due_minute`,
ADD COLUMN `delay_consume_hour`  integer NULL COMMENT '预订时刻-（时）可兑换' AFTER `is_limit_delay_consume`,
ADD COLUMN `least_perdue_number`  integer NULL COMMENT '每单最少购买份数' AFTER `delay_consume_hour`,
ADD COLUMN `most_perdue_number`  integer NULL COMMENT '每单最多购买份数' AFTER `least_perdue_number`;

 ALTER TABLE `sys_channel_strategy`
 ADD COLUMN `advance_due_unit` TINYINT(4) NULL COMMENT '日期前可预订单位' AFTER `most_perdue_number`;


ALTER TABLE `sys_channel_strategy`
ADD COLUMN `product_id` BIGINT(20) NULL COMMENT '产品id';

ALTER TABLE `sys_channel_strategy`
MODIFY COLUMN `expire`  int(10) NULL DEFAULT 0 COMMENT '购买时限：个数' AFTER `pre_sale_mode`,
MODIFY COLUMN `expire_mode`  tinyint(1) NULL DEFAULT 0 COMMENT '购买时限：计时单位（1 小时，2 日）' AFTER `expire`;

ALTER TABLE `sys_rebate_strategy`
ADD COLUMN `strategy_id` BIGINT NULL COMMENT '返利所属政策id' AFTER `rebate_rate`;


ALTER TABLE `sys_spcre_relation`
MODIFY COLUMN `id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键Id' FIRST ;