package com.pzj.base.service.sku;

import java.util.List;

import com.pzj.base.entity.json.CommonResult;

public interface ProductBatchDeleteService {
	 /**
     * 批量删除
     * @param ids ID集合
     * @return Boolean(成功 为true)
     */
    CommonResult deleteBatch(List<Integer> ids);
}
