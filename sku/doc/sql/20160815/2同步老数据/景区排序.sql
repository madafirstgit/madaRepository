ALTER TABLE `product_scenic`
MODIFY COLUMN `sort`  tinyint(4) NULL DEFAULT 0 COMMENT '排序' AFTER `update_date`;

update product_scenic set sort = 0;