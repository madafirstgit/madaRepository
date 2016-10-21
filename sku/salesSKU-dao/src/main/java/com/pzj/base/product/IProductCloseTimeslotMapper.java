/*
 * ProductCloseTimeslotMapper.java
 
 * www.piaozhijia.coim
 */
package com.pzj.base.product;

import com.pzj.base.common.BaseMapper;
import com.pzj.base.common.persistence.annotation.MyBatisDao;
import com.pzj.base.entity.product.ProductCloseTimeslot;



/**
 * Mapper接口.区域
 * @author 票之家
 */
@MyBatisDao
public interface IProductCloseTimeslotMapper extends BaseMapper<ProductCloseTimeslot> {  
    /**
     * 根据产品组信息删除产品关闭事件对象
     * 
     * @param record
     * @return
     */
    Integer deleteByPid(Long pid);
}
