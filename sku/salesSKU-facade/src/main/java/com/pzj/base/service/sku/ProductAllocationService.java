package com.pzj.base.service.sku;

import com.pzj.base.entity.sku.XzSkuAllocationDto;

/**
 * @author zhengxw
 */
public interface ProductAllocationService {
    /**
     * 查询分配
     * 编码0601
     * @param id
     * @return
     */
    XzSkuAllocationDto queryAllocation(int id);

    /**
     * 查询分配
     * 编码0602
     * @param skuId 产品ID
     * @return
     */
    XzSkuAllocationDto queryAllocationBySkuId(int skuId);
}
