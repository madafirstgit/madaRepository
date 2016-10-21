update product_dict d set d.label = '演艺' where id in(32,37 );

update product_dict d set d.label = '景点' where id in(31,33,34,35,36);

update product_dict d set d.flag = 0 where id in(38,39,40);

update product_dict d set d.label = '一日游' where id =41;

update product_dict d set d.label = '交通接驳' where id =43;

update product_dict d set d.label =  '新奇' where id = 44;

update product_dict d set d.label =  '美食' where id = 48;

select * from product_dict d where d.type in('product:procategory','product:proSkucategory');

-- 产品类别排序
update product_dict set sort = 1 where value = 1000;
update product_dict set sort = 2 where value = 7000;
update product_dict set sort = 5 where value = 4002;
update product_dict set sort = 6 where value = 4001;
update product_dict set sort = 4 where value = 5000;
update product_dict set sort = 7 where value = 8000;
update product_dict set sort = 17 where value = 9;
update product_dict set sort = 3 where value = 9000;