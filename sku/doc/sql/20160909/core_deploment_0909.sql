# product_info
ALTER TABLE `product_info`
MODIFY COLUMN `start_time`  varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '入园开始时间' AFTER `release_thurl`,
MODIFY COLUMN `end_time`  varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '入园结束时间' AFTER `start_time`,
MODIFY COLUMN `playtimeMode`  int(11) NULL DEFAULT NULL COMMENT '游玩时间的开始时间的方式/下单有效日期开始类型' AFTER `supplier_id`,
ADD COLUMN `is_need_scenic`  tinyint NULL COMMENT '产品是否需要绑定景点' AFTER `gainPeopleTimePurchaseNum`,
ADD COLUMN `ronda_name`  varchar(50) NULL COMMENT '场次名称' AFTER `is_need_scenic`,
ADD COLUMN `checkin_address`  varchar(60) NULL COMMENT '入园地址' AFTER `ronda_name`,
ADD COLUMN `sale_start_date`  date NULL COMMENT '产品销售开始日期' AFTER `checkin_address`,
ADD COLUMN `sale_end_date`  date NULL COMMENT '产品销售结束日期' AFTER `sale_start_date`,
ADD COLUMN `is_need_playtime`  tinyint NULL COMMENT '下单是否填写游玩时间' AFTER `sale_end_date`,
ADD COLUMN `no_playtime_ordertime_type`  varchar(2) NULL COMMENT '不填写游玩时间下单计算时间类型' AFTER `is_need_playtime`,
ADD COLUMN `ordertime_value`  int NULL COMMENT '订单支付成功后的时间数值' AFTER `no_playtime_ordertime_type`,
ADD COLUMN `ordertime_unit`  varchar(2) NULL COMMENT '订单支付成功后的时间单位' AFTER `ordertime_value`,
ADD COLUMN `one_word_feature`  varchar(500) NULL COMMENT '一句话特色',
ADD COLUMN `product_info_detail`  text NULL COMMENT '产品详情' AFTER `one_word_feature`,
ADD COLUMN `order_info`  text NULL COMMENT '预订须知' AFTER `product_info_detail`,
ADD COLUMN `expense_info`  text NULL COMMENT '费用说明' AFTER `order_info`,
ADD COLUMN `salesmanship`  text NULL COMMENT '销售技巧' AFTER `expense_info`,
ADD COLUMN `important_clause`  text NULL COMMENT '重要条款' AFTER `salesmanship`,
ADD COLUMN `attentions`  text NULL COMMENT '注意事项' AFTER `important_clause`,
ADD COLUMN `use_method`  text NULL COMMENT '使用方法' AFTER `attentions`,
ADD COLUMN `photoinfo_id`  varchar(50) NULL AFTER `use_method`;



ALTER TABLE `product_info`
ADD COLUMN `province`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '省' AFTER `photoinfo_id`,
ADD COLUMN `city`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '市' AFTER `province`,
ADD COLUMN `county`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '县' AFTER `city`,
ADD COLUMN `checkin_type`  tinyint NULL COMMENT '入园方式',
ADD COLUMN `more_info_url`  varchar(50) NULL COMMENT 'URL' AFTER `checkin_type`,
ADD COLUMN `sku_grouping`  tinyint NULL COMMENT 'SKU分组类型（父产品、组合产品）' AFTER `more_info_url`;


ALTER TABLE `product_info`
MODIFY COLUMN `minutes_node`  int(2) NULL DEFAULT NULL COMMENT '<已废弃>' AFTER `product_no`,
MODIFY COLUMN `hour_node`  int(2) NULL DEFAULT NULL COMMENT '<已废弃>' AFTER `minutes_node`,
MODIFY COLUMN `product_sum_repertory`  int(8) NULL DEFAULT NULL COMMENT '总库存<已废弃>' AFTER `hour_node`,
MODIFY COLUMN `product_usable_repertory`  int(8) NULL DEFAULT NULL COMMENT '可用库存<已废弃>' AFTER `product_sum_repertory`,
ADD COLUMN `email_notification`  varchar(50) NULL COMMENT '邮件通知内容' AFTER `sku_grouping`;


ALTER TABLE `product_info`
ADD COLUMN `start_date` DATETIME NULL COMMENT '产品可用开始日期',
ADD COLUMN `end_date` DATETIME NULL COMMENT '产品可用结束日期';

ALTER TABLE `product_info`
ADD COLUMN `sku_id`  varchar(20) NULL COMMENT '通用供应端产品id' ;


ALTER TABLE `product_info`
ADD COLUMN `hash_code`  integer NULL COMMENT '转过来的产品上架实体的hashCode';





ALTER TABLE `product_info`
MODIFY COLUMN `photoinfo_id`  varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品图片列表集合' AFTER `use_method`;


ALTER TABLE `product_info`
CHANGE COLUMN `is_need_scenic` `is_need_scenic` TINYINT(4) NULL DEFAULT NULL COMMENT '产品是否需要绑定景点（1：需要；0：不需要）' ,
CHANGE COLUMN `is_need_playtime` `is_need_playtime` TINYINT(4) NULL DEFAULT NULL COMMENT '下单是否填写游玩时间（1：需要；0：不需要）' ,
MODIFY COLUMN  `checkin_type` TINYINT(4) NULL DEFAULT NULL COMMENT '入园方式（1：凭码入园；2：换票入园）' ;

ALTER TABLE `product_info`
MODIFY COLUMN `name`  varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注名称' AFTER `id`;

# product_release

ALTER TABLE `product_release`
ADD COLUMN `is_need_take_order`  tinyint(4) NULL DEFAULT NULL COMMENT '是否需要代下单' AFTER `county`,
ADD COLUMN `verification_rule_type`  varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL AFTER `is_need_take_order`,
ADD COLUMN `fixed_verification_type`  varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '固定日期核销日期类型' AFTER `verification_rule_type`,
ADD COLUMN `fixed_verification_unit`  varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '固定日期核销单位' AFTER `fixed_verification_type`,
ADD COLUMN `fixed_verification_time`  int(11) NULL DEFAULT NULL COMMENT '固定日期核销值' AFTER `fixed_verification_unit`,
ADD COLUMN `is_manual_Verification`  tinyint(4) NULL DEFAULT NULL COMMENT '是否手动核销' AFTER `fixed_verification_time`,
ADD COLUMN `refund_date_type`  tinyint(4) NULL DEFAULT NULL COMMENT '退款期限类型' AFTER `is_manual_Verification`,
ADD COLUMN `prerefund_days`  int(11) NULL DEFAULT NULL COMMENT '退款日期前天数' AFTER `refund_date_type`,
ADD COLUMN `prerefund_hour`  int(11) NULL DEFAULT NULL COMMENT '退款日期前当天时刻-(时）' AFTER `prerefund_days`,
ADD COLUMN `prerefund_Minute`  int(11) NULL DEFAULT NULL COMMENT '退款日期前当天时刻-（分）' AFTER `prerefund_hour`,
ADD COLUMN `prerefund_supplier_feetype`  varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退款日期前给供应商退款金额类型' AFTER `prerefund_Minute`,
ADD COLUMN `prerefund_supplier_feevalue`  double NULL DEFAULT NULL COMMENT '退款日期前给供应商退款金额数值' AFTER `prerefund_supplier_feetype`,
ADD COLUMN `publish_date`  timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '通审时间' AFTER `prerefund_supplier_feevalue`,
ADD COLUMN `prerefund_distributor_feetype`  varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退款日期前给分销商退款金额类型' AFTER `publish_date`,
ADD COLUMN `prerefund_distributor_feevalue`  double NULL DEFAULT NULL COMMENT '退款日期前给分销商退款金额数值' AFTER `prerefund_distributor_feetype`,
ADD COLUMN `prorefund_days`  int(11) NULL DEFAULT NULL COMMENT '退款日期后天数' AFTER `prerefund_distributor_feevalue`,
ADD COLUMN `prorefund_hour`  int(11) NULL DEFAULT NULL COMMENT '退款日期后当天时刻-(时）' AFTER `prorefund_days`,
ADD COLUMN `prorefund_Minute`  int(11) NULL DEFAULT NULL COMMENT '退款日期后当天时刻-（分）' AFTER `prorefund_hour`,
ADD COLUMN `prorefund_supplier_feetype`  varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退款日期后给供应商退款金额类型' AFTER `prorefund_Minute`,
ADD COLUMN `prorefund_supplier_feevalue`  double NULL DEFAULT NULL COMMENT '退款日期后给供应商退款金额数值' AFTER `prorefund_supplier_feetype`,
ADD COLUMN `prorefund_distributor_feetype`  varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退款日期后给分销商退款金额类型' AFTER `prorefund_supplier_feevalue`,
ADD COLUMN `prorefund_distributor_feevalue`  double NULL DEFAULT NULL COMMENT '退款日期后给分销商退款金额数值' AFTER `prorefund_distributor_feetype`;

ALTER TABLE `product_release`
MODIFY COLUMN `verification_rule_type`  varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '核销清算规则类型' AFTER `is_need_take_order`,
MODIFY COLUMN `fixed_verification_unit`  varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '核销后固定时间清算单位' AFTER `fixed_verification_type`,
MODIFY COLUMN `fixed_verification_time`  int(11) NULL DEFAULT NULL COMMENT '核销后固定时间清算数值' AFTER `fixed_verification_unit`,
ADD COLUMN `overdue_verification_datetype`  tinyint NULL COMMENT '逾期清算规则日期类型' AFTER `fixed_verification_time`,
ADD COLUMN `overdue_verification_unit`  tinyint NULL COMMENT '逾期清算规则日期单位' AFTER `overdue_verification_datetype`,
ADD COLUMN `overdue_verification_time`  tinyint NULL COMMENT '逾期清算规则日期数值' AFTER `overdue_verification_unit`,
ADD COLUMN `overdue_verification_feetype`  tinyint NULL COMMENT '逾期清算规则金额类型' AFTER `overdue_verification_time`,
ADD COLUMN `overdue_verification_feevalue`  decimal(11,2) NULL COMMENT '逾期清算规则金额' AFTER `overdue_verification_feetype`,
ADD COLUMN `consumer_card_type`  tinyint NULL COMMENT '消费凭证类型' AFTER `overdue_verification_feevalue`,
ADD COLUMN `is_one_vote`  tinyint NULL COMMENT '是否是一证一票' AFTER `consumer_card_type`,
ADD COLUMN `is_select_seat`  tinyint NULL COMMENT '是否需要选坐' AFTER `is_one_vote`;


ALTER TABLE `product_release`
ADD COLUMN `stock_rule_id`  bigint(20) NULL COMMENT '产品库存规则Id' AFTER `prorefund_distributor_feevalue`;


ALTER TABLE `product_info`
MODIFY COLUMN `more_info_url`  varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'URL' AFTER `checkin_type`;


ALTER TABLE `product_release`
MODIFY COLUMN `overdue_verification_time`  int(10) NULL DEFAULT NULL COMMENT '逾期清算规则日期数值' AFTER `overdue_verification_unit`;


ALTER TABLE `product_release`
ADD COLUMN `is_need_prerefund`  tinyint(2) COMMENT '退款日期前是否可退（1:可退，0:不可退）';

ALTER TABLE `product_release`
ADD COLUMN `prerefund_quantity_type`  tinyint(2) COMMENT '退款日期前退款数量类型(1:整单退，2:部分退)';


ALTER TABLE `product_release`
ADD COLUMN `is_need_prorefund`  tinyint(2) COMMENT '退款日期后是否可退（1:可退，0:不可退）';

ALTER TABLE `product_release`
ADD COLUMN `prorefund_quantity_type`  tinyint(2) COMMENT '退款日期后退款数量类型(1:整单退，2:部分退)';

# product_ronda_relation



SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `product_ronda_relation`;
CREATE TABLE `product_ronda_relation` (
  `id` bigint(20) NOT NULL,
  `product_info_id` bigint(20) DEFAULT NULL COMMENT '产品组id',
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  `ronda_id` bigint(20) DEFAULT NULL COMMENT '场次id',
  `ronda_name` varchar(50) DEFAULT NULL COMMENT '场次名称',
  `region_id` bigint(20) DEFAULT NULL COMMENT '区域id',
  `region_name` varchar(50) DEFAULT NULL COMMENT '区域名称',
  `flag` tinyint(4) DEFAULT NULL COMMENT '是否有效',
  `supplier_id` bigint(20) DEFAULT NULL COMMENT '提供者id',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `create_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='产品场次关系表';

# product_site_relation

SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `product_site_relation`;
CREATE TABLE `product_site_relation` (
  `id` bigint(20) NOT NULL,
  `product_info_id` bigint(20) DEFAULT NULL COMMENT '产品组id',
  `site_id` bigint(20) DEFAULT NULL COMMENT '检票点id',
  `traffic_count` int(11) DEFAULT NULL COMMENT '交通次数',
  `flag` tinyint(4) DEFAULT NULL COMMENT '是否有效',
  `supplier_id` bigint(20) DEFAULT NULL COMMENT '提供者id',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `create_date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_date` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `product_id` bigint(20) DEFAULT NULL COMMENT '产品id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# product_close_timeslot.sql


SET FOREIGN_KEY_CHECKS=0;

DROP TABLE IF EXISTS `product_close_timeslot`;
CREATE TABLE `product_close_timeslot` (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `colse_date` date DEFAULT NULL COMMENT '关闭时间点',
  `start_date` date DEFAULT NULL COMMENT '关闭开始时间',
  `end_date` date DEFAULT NULL COMMENT '关闭结束时间',
  `product_info_id` bigint(20) DEFAULT NULL COMMENT '产品组id',
  `flag` tinyint(4) DEFAULT NULL COMMENT '是否有效',
  `supplier_id` bigint(20) DEFAULT NULL COMMENT '提供者id',
  `create_by` varchar(50) DEFAULT NULL COMMENT '创建人',
  `update_by` varchar(50) DEFAULT NULL COMMENT '更新人',
  `create_date` date DEFAULT NULL COMMENT '创建时间',
  `update_date` date DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# product_stock_relation.sql
CREATE TABLE `product_stock_relation` (
`id`  bigint(20) NOT NULL COMMENT '主键id' ,
`product_id`  bigint(20) NOT NULL COMMENT '产品id' ,
`product_info_id`  bigint(20) NOT NULL DEFAULT 0 COMMENT '产品组id' ,
`stock_rule_id`  bigint(20) NOT NULL COMMENT '库存id' ,
`flag`  tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否有效（1：是，0：否）' ,
PRIMARY KEY (`id`)
)
;



insert into product_info (
id,
name,
product_type,
release_thurl,
start_time,
end_time,
product_no,
create_by,
create_date,
update_by,
update_date,
flag,
reease_info,
province,
city,
county,
photoinfo_id,
sku_grouping,
more_info_url,
sku_id,
start_date,
end_date,
supplier_id

)
select 
pr.sku_id,
pr.name,
pr.pro_category,
pr.photos,
pr.sku_start_time,
pr.sku_end_time,
pr.roduct_no,
pr.create_by,
pr.create_date,
pr.update_by,
pr.update_date,
pr.flag,
pr.remarks,
pr.province,
pr.city,
pr.county,
pr.photoinfo_id,
pr.sku_grouping,
pr.more_info_url,
pr.sku_id,
pr.start_date,
pr.end_date,
pr.supplier_id
from product_release pr where not exists (

select i.sku_id from product_info i 
where  i.id = pr.product_id 

)
and  pr.sku_id != 0 and pr.sku_id
group by pr.sku_id;


update product_release pr set pr.product_id = pr.sku_id where pr.product_id = 0 or pr.product_id is null;




update product_dict d set d.label = '演艺' where id in(32,37 );

update product_dict d set d.label = '景点' where id in(31,33,34,35,36);

update product_dict d set d.flag = 0 where id in(38,39,40);

update product_dict d set d.label = '一日游' where id =41;

update product_dict d set d.label = '交通接驳' where id =43;

update product_dict d set d.label =  '新奇' where id = 44;

update product_dict d set d.label =  '美食' where id = 48;

select * from product_dict d where d.type in('product:procategory','product:proSkucategory');

# 产品类别排序
update product_dict set sort = 1 where value = 1000;
update product_dict set sort = 2 where value = 7000;
update product_dict set sort = 5 where value = 4002;
update product_dict set sort = 6 where value = 4001;
update product_dict set sort = 4 where value = 5000;
update product_dict set sort = 7 where value = 8000;
update product_dict set sort = 17 where value = 9;
update product_dict set sort = 3 where value = 9000;



# 老数据：政策游玩时间 = 新数据：产品销售时间
update product_info i 
inner join sys_label_relation r on r.rel_type = 'strategyProduct' 
inner join product_release p on p.id = r.rel_id and p.product_id = i.id
inner join sys_channel_strategy s on r.obj_id = s.id and s.begin_date is not null
set i.sale_start_date = s.begin_date;

update product_info i 
inner join sys_label_relation r on r.rel_type = 'strategyProduct' 
inner join product_release p on p.id = r.rel_id and p.product_id = i.id
inner join sys_channel_strategy s on r.obj_id = s.id and s.end_date is not null
set i.sale_end_date = s.end_date;

#销售日期历史数据为空，默认设置1970-2037
update product_info set sale_start_date = DATE_FORMAT('1970-01-01','%Y-%c-%d') where sale_start_date is null;

update product_info set sale_end_date = DATE_FORMAT('2037-12-30','%Y-%c-%d') where sale_end_date is null;

# 老数据：产品有效期= 新数据：产品可用日期
update product_info set start_date = DATE_FORMAT(CONCAT('2006',start_time),'%Y-%c-%d') where start_time <> '' and start_date is null;

update product_info set end_date = DATE_FORMAT(CONCAT('2006',end_time),'%Y-%c-%d') where end_time <> '' and end_date is null;

# 可用日期历史数据为空，默认设置 1970-2037
update product_info set start_date = DATE_FORMAT('1970-01-01','%Y-%c-%d') where start_date is null;

update product_info set end_date = DATE_FORMAT('2037-12-30','%Y-%c-%d') where end_date is null;


# 检票时间段默认：00-24
update product_info set start_time = null,end_time = null;

update product_info i set i.start_time = '00:00',i.end_time = '24:00' where i.id in(
   select product_id from product_release p where p.pro_category  in 
(1,5,12,4,11,13,10)
);


# 设置剧场id=0，为null
update product_release set theater_id  = null where theater_id = 0;

# 设置老数据都是无限库存
update product_release set unlimited_inventory = 1;

# 产品图片列表初始化
update product_info i set i.photoinfo_id = i.release_thurl where i.photoinfo_id ='' or i.photoinfo_id is null;

# 默认设置产品的入园方式为：凭码入园
update product_info i set i.checkin_type = 1 where i.id in(
   select product_id from product_release p where p.pro_category  in 
(1,5,12,13,4,10,11)
);
update product_release p set p.checkIn_type = 1 where p.pro_category  in  (1,5,12,4,11,13,10);

# 产品游玩时间同步
update product_info i set i.is_need_playtime = 1,i.ordertime_unit = i.playtimeUnit,i.ordertime_value = i.playtimeValue where i.id in(
   select product_id from product_release p where p.pro_category  in 
(1,5,12,4,11,13,10)
);

#通用产品类型 
update product_release p set p.product_type = CONCAT('1:',p.sku_params_name) where p.sku_params_name <> '' and p.sku_params_name is not null;






