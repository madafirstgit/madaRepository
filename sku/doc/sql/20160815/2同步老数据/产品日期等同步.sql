
-- 老数据：政策游玩时间 = 新数据：产品销售时间
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

--销售日期历史数据为空，默认设置1970-2037
update product_info set sale_start_date = DATE_FORMAT('1970-01-01','%Y-%c-%d') where sale_start_date is null;

update product_info set sale_end_date = DATE_FORMAT('2037-12-30','%Y-%c-%d') where sale_end_date is null;

-- 老数据：产品有效期= 新数据：产品可用日期
update product_info set start_date = DATE_FORMAT(CONCAT('2006',start_time),'%Y-%c-%d') where start_time <> '' and start_date is null;

update product_info set end_date = DATE_FORMAT(CONCAT('2006',end_time),'%Y-%c-%d') where end_time <> '' and end_date is null;

-- 可用日期历史数据为空，默认设置 1970-2037
update product_info set start_date = DATE_FORMAT('1970-01-01','%Y-%c-%d') where start_date is null;

update product_info set end_date = DATE_FORMAT('2037-12-30','%Y-%c-%d') where end_date is null;


-- 检票时间段默认：00-24
update product_info set start_time = null,end_time = null;

update product_info i set i.start_time = '00:00',i.end_time = '24:00' where i.id in(
   select product_id from product_release p where p.pro_category  in 
(1,5,12,4,11,13,10)
);





