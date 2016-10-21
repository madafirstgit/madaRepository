-- 设置剧场id=0，为null
update product_release set theater_id  = null where theater_id = 0;

-- 设置老数据都是无限库存
update product_release set unlimited_inventory = 1;

-- 产品图片列表初始化
update product_info i set i.photoinfo_id = i.release_thurl where i.photoinfo_id ='' or i.photoinfo_id is null;

-- 默认设置产品的入园方式为：凭码入园
update product_info i set i.checkin_type = 1 where i.id in(
   select product_id from product_release p where p.pro_category  in 
(1,5,12,13,4,10,11)
);
update product_release p set p.checkIn_type = 1 where p.pro_category  in  (1,5,12,4,11,13,10);

-- 产品游玩时间同步
update product_info i set i.is_need_playtime = 1,i.ordertime_unit = i.playtimeUnit,i.ordertime_value = i.playtimeValue where i.id in(
   select product_id from product_release p where p.pro_category  in 
(1,5,12,4,11,13,10)
);

--通用产品类型 
update product_release p set p.product_type = CONCAT('1:',p.sku_params_name) where p.sku_params_name <> '' and p.sku_params_name is not null;





