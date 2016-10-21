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





