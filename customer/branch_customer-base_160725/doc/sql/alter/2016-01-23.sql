alter table sys_channel_strategy add strategy_expire_type int(1) comment '政策有效期类型（1永久，2设置时长）';
alter table sys_channel_strategy add checkin_expire_type int(1) comment '首检及游玩时间（1当日，2产品有效期内）';
alter table sys_channel_strategy add checkin_expire_num int(10) comment '有效期天数';
alter table sys_channel_strategy add checkin_expire_unit int(1) comment '有效期计时方式（1小时，2日）';
alter table sys_channel_strategy add settlement_price double(10,2) comment '结算价';
alter table sys_channel_strategy add ticket_varie varchar(100) comment '票品（数据字典ticketvarie）';
alter table sys_channel_strategy add sales_type varchar(100) comment '销售端口（type：value，type=）';
alter table sys_channel_strategy add audit_status int(1) comment '审核状态（1待审核，2通过，3拒绝）';
alter table sys_channel_strategy add isMF int(1) comment '是否是魔方渠道政策（1是，0否）';
alter table sys_channel_strategy add refuse_reason varchar(500) comment '审核拒绝原因';
alter table sys_channel_strategy modify column scope varchar(200);

alter table product_site_data add jqrk_name varchar(255) COMMENT '景区入口名称';
alter table product_site_data add jqrk_id bigint(20) COMMENT '景区入口id';

delete from product_dict where id in (356,357,358,370,371,390,391,400,401,410,411,420,421,422,423,424,430,431);
delete from product_dict where type = 'channel:applicationdate';

INSERT INTO `product_dict` (`id`, `label`, `value`, `type`, `description`, `sort`, `create_date`, `create_by`, `update_by`, `update_date`, `remarks`, `flag`, `data_source`, `supplier_id`) VALUES (250, '周一', '1', 'strategy:scope', '政策适用日期', 1, '0000-0-0 00:00:00', 'admin', 'huxn', '0000-0-0 00:00:00', '', '1', '', '');
INSERT INTO `product_dict` (`id`, `label`, `value`, `type`, `description`, `sort`, `create_date`, `create_by`, `update_by`, `update_date`, `remarks`, `flag`, `data_source`, `supplier_id`) VALUES (251, '周二', '2', 'strategy:scope', '政策适用日期', 2, '0000-0-0 00:00:00', 'admin', 'huxn', '0000-0-0 00:00:00', '', '1', '', '');
INSERT INTO `product_dict` (`id`, `label`, `value`, `type`, `description`, `sort`, `create_date`, `create_by`, `update_by`, `update_date`, `remarks`, `flag`, `data_source`, `supplier_id`) VALUES (252, '周三', '3', 'strategy:scope', '政策适用日期', 3, '0000-0-0 00:00:00', 'admin', 'huxn', '0000-0-0 00:00:00', '', '1', '', '');
INSERT INTO `product_dict` (`id`, `label`, `value`, `type`, `description`, `sort`, `create_date`, `create_by`, `update_by`, `update_date`, `remarks`, `flag`, `data_source`, `supplier_id`) VALUES (253, '周四', '4', 'strategy:scope', '政策适用日期', 4, '0000-0-0 00:00:00', 'admin', 'huxn', '0000-0-0 00:00:00', '', '1', '', '');
INSERT INTO `product_dict` (`id`, `label`, `value`, `type`, `description`, `sort`, `create_date`, `create_by`, `update_by`, `update_date`, `remarks`, `flag`, `data_source`, `supplier_id`) VALUES (254, '周五', '5', 'strategy:scope', '政策适用日期', 5, '0000-0-0 00:00:00', 'admin', 'huxn', '0000-0-0 00:00:00', '', '1', '', '');
INSERT INTO `product_dict` (`id`, `label`, `value`, `type`, `description`, `sort`, `create_date`, `create_by`, `update_by`, `update_date`, `remarks`, `flag`, `data_source`, `supplier_id`) VALUES (255, '周六', '6', 'strategy:scope', '政策适用日期', 6, '0000-0-0 00:00:00', 'admin', 'huxn', '0000-0-0 00:00:00', '', '1', '', '');
INSERT INTO `product_dict` (`id`, `label`, `value`, `type`, `description`, `sort`, `create_date`, `create_by`, `update_by`, `update_date`, `remarks`, `flag`, `data_source`, `supplier_id`) VALUES (256, '周日', '7', 'strategy:scope', '政策适用日期', 7, '0000-0-0 00:00:00', 'admin', 'huxn', '0000-0-0 00:00:00', '', '1', '', '');


INSERT INTO `product_dict`(`id`,`label`,`value`,`type`,`description`,`sort`,`create_date`,`create_by`,`update_by`,`update_date`,`remarks`,`flag`,`data_source`,`supplier_id`) VALUES (356, '未启用', '0', 'strategy:status', '政策状态', 1, '2015-12-19 16:22:21', 'huxn', 'huxn', '2015-12-19 16:22:38', NULL, '1', NULL, NULL);
INSERT INTO `product_dict`(`id`,`label`,`value`,`type`,`description`,`sort`,`create_date`,`create_by`,`update_by`,`update_date`,`remarks`,`flag`,`data_source`,`supplier_id`) VALUES (357, '已启用', '1', 'strategy:status', '政策状态', 2, '2015-12-19 16:23:21', 'huxn', 'huxn', '2015-12-19 16:23:32', NULL, '1', NULL, NULL);
INSERT INTO `product_dict`(`id`,`label`,`value`,`type`,`description`,`sort`,`create_date`,`create_by`,`update_by`,`update_date`,`remarks`,`flag`,`data_source`,`supplier_id`) VALUES (358, '已禁用', '2', 'strategy:status', '政策状态', 3, '2015-12-19 16:26:12', 'huxn', 'huxn', '2015-12-19 16:26:23', NULL, '1', NULL, NULL);
INSERT INTO `product_dict`(`id`,`label`,`value`,`type`,`description`,`sort`,`create_date`,`create_by`,`update_by`,`update_date`,`remarks`,`flag`,`data_source`,`supplier_id`) VALUES (370, '永久', '1', 'strategy:expiretype', '政策有效期类型', 1, '2016-1-12 16:27:25', 'huxn', 'huxn', '2016-1-12 16:27:33', NULL, '1', NULL, NULL);
INSERT INTO `product_dict`(`id`,`label`,`value`,`type`,`description`,`sort`,`create_date`,`create_by`,`update_by`,`update_date`,`remarks`,`flag`,`data_source`,`supplier_id`) VALUES (371, '设置时长', '2', 'strategy:expiretype', '政策有效期类型', 2, '2016-1-12 16:28:25', 'huxn', 'huxn', '2016-1-12 16:28:32', NULL, '1', NULL, NULL);
INSERT INTO `product_dict`(`id`,`label`,`value`,`type`,`description`,`sort`,`create_date`,`create_by`,`update_by`,`update_date`,`remarks`,`flag`,`data_source`,`supplier_id`) VALUES (380, '当日', '1', 'strategy:checkinexpiretype', '首检及游玩时间类型', 1, '2016-1-12 16:36:59', 'huxn', 'huxn', '2016-1-12 16:37:07', NULL, '1', NULL, NULL);
INSERT INTO `product_dict`(`id`,`label`,`value`,`type`,`description`,`sort`,`create_date`,`create_by`,`update_by`,`update_date`,`remarks`,`flag`,`data_source`,`supplier_id`) VALUES (381, '产品有效期内', '2', 'strategy:checkinexpiretype', '首检及游玩时间类型', 2, '2016-1-12 16:37:56', 'huxn', 'huxn', '2016-1-12 16:38:03', NULL, '1', NULL, NULL);
INSERT INTO `product_dict`(`id`,`label`,`value`,`type`,`description`,`sort`,`create_date`,`create_by`,`update_by`,`update_date`,`remarks`,`flag`,`data_source`,`supplier_id`) VALUES (390, '小时', '1', 'strategy:checkinexpireunit', '产品有效期计时单位', 1, '2016-1-12 16:43:12', 'huxn', 'huxn', '2016-1-12 16:43:19', NULL, '1', NULL, NULL);
INSERT INTO `product_dict`(`id`,`label`,`value`,`type`,`description`,`sort`,`create_date`,`create_by`,`update_by`,`update_date`,`remarks`,`flag`,`data_source`,`supplier_id`) VALUES (391, '日', '2', 'strategy:checkinexpireunit', '产品有效期计时单位', 2, '2016-1-12 16:43:55', 'huxn', 'huxn', '2016-1-12 16:44:03', NULL, '1', NULL, NULL);
INSERT INTO `product_dict`(`id`,`label`,`value`,`type`,`description`,`sort`,`create_date`,`create_by`,`update_by`,`update_date`,`remarks`,`flag`,`data_source`,`supplier_id`) VALUES (400, '团票', '1', 'strategy:ticketvarie', '政策票品', 1, '2016-1-12 17:10:53', 'huxn', 'huxn', '2016-1-12 17:11:01', NULL, '1', NULL, NULL);
INSERT INTO `product_dict`(`id`,`label`,`value`,`type`,`description`,`sort`,`create_date`,`create_by`,`update_by`,`update_date`,`remarks`,`flag`,`data_source`,`supplier_id`) VALUES (401, '散票', '2', 'strategy:ticketvarie', '政策票品', 2, '2016-1-12 17:11:33', 'huxn', 'huxn', '2016-1-12 17:11:40', NULL, '1', NULL, NULL);
INSERT INTO `product_dict`(`id`,`label`,`value`,`type`,`description`,`sort`,`create_date`,`create_by`,`update_by`,`update_date`,`remarks`,`flag`,`data_source`,`supplier_id`) VALUES (410, '线下窗口', '1', 'strategy:salesType', '政策销售端口', 1, '2016-1-12 17:22:31', 'huxn', 'huxn', '2016-1-12 17:22:46', NULL, '1', NULL, NULL);
INSERT INTO `product_dict`(`id`,`label`,`value`,`type`,`description`,`sort`,`create_date`,`create_by`,`update_by`,`update_date`,`remarks`,`flag`,`data_source`,`supplier_id`) VALUES (411, '二维码微店', '2', 'strategy:salesType', '政策销售端口', 2, '2016-1-12 17:22:29', 'huxn', 'huxn', '2016-1-12 17:22:43', NULL, '1', NULL, NULL);
INSERT INTO `product_dict`(`id`,`label`,`value`,`type`,`description`,`sort`,`create_date`,`create_by`,`update_by`,`update_date`,`remarks`,`flag`,`data_source`,`supplier_id`) VALUES (420, '旅行社PC端', '3', 'strategy:salesType', '政策销售端口', 1, '2016-1-12 17:26:41', 'huxn', 'huxn', '2016-1-12 17:27:09', NULL, '1', NULL, NULL);
INSERT INTO `product_dict`(`id`,`label`,`value`,`type`,`description`,`sort`,`create_date`,`create_by`,`update_by`,`update_date`,`remarks`,`flag`,`data_source`,`supplier_id`) VALUES (421, '导游APP', '4', 'strategy:salesType', '政策销售端口', 2, '2016-1-12 17:26:44', 'huxn', 'huxn', '2016-1-12 17:27:11', NULL, '1', NULL, NULL);
INSERT INTO `product_dict`(`id`,`label`,`value`,`type`,`description`,`sort`,`create_date`,`create_by`,`update_by`,`update_date`,`remarks`,`flag`,`data_source`,`supplier_id`) VALUES (422, '商户APP', '5', 'strategy:salesType', '政策销售端口', 3, '2016-1-12 17:26:46', 'huxn', 'huxn', '2016-1-12 17:27:13', NULL, '1', NULL, NULL);
INSERT INTO `product_dict`(`id`,`label`,`value`,`type`,`description`,`sort`,`create_date`,`create_by`,`update_by`,`update_date`,`remarks`,`flag`,`data_source`,`supplier_id`) VALUES (423, '导游微店', '6', 'strategy:salesType', '政策销售端口', 4, '2016-1-12 17:26:48', 'huxn', 'huxn', '2016-1-12 17:27:15', NULL, '1', NULL, NULL);
INSERT INTO `product_dict`(`id`,`label`,`value`,`type`,`description`,`sort`,`create_date`,`create_by`,`update_by`,`update_date`,`remarks`,`flag`,`data_source`,`supplier_id`) VALUES (424, '商户微店', '7', 'strategy:salesType', '政策销售端口', 5, '2016-1-12 17:26:50', 'huxn', 'huxn', '2016-1-12 17:27:17', NULL, '1', NULL, NULL);
INSERT INTO `product_dict`(`id`,`label`,`value`,`type`,`description`,`sort`,`create_date`,`create_by`,`update_by`,`update_date`,`remarks`,`flag`,`data_source`,`supplier_id`) VALUES (430, '小时', '1', 'strategy:expireMode', '购买时限计时单位', 1, '2016-1-12 17:32:35', 'huxn', 'huxn', '2016-1-12 17:32:49', NULL, '1', NULL, NULL);
INSERT INTO `product_dict`(`id`,`label`,`value`,`type`,`description`,`sort`,`create_date`,`create_by`,`update_by`,`update_date`,`remarks`,`flag`,`data_source`,`supplier_id`) VALUES (431, '日', '2', 'strategy:expireMode', '购买时限计时单位', 2, '2016-1-12 17:32:37', 'huxn', 'huxn', '2016-1-12 17:32:51', NULL, '1', NULL, NULL);