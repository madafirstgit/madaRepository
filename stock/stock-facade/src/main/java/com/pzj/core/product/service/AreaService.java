/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.product.service;

import com.pzj.core.product.model.AreaModel;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;

/**
 * 演绎区域写操作
 * @author dongchunfu
 * @version $Id: ActingAreaService.java, v 0.1 2016年8月1日 上午10:37:43 dongchunfu Exp $
 */
public interface AreaService {
    /**
     * 创建演绎区域
     * @author dongchunfu
     * @param area 区域实体
     * @return Result<Long> 新增实体ID
     */
    public Result<Long> createArea(AreaModel model, ServiceContext context);

    /**
     * 更新演绎区域
     * @author dongchunfu
     * @param area 区域实体
     * @return Result<Integer> 更新数量
     */
    public Result<Integer> updateArea(AreaModel model, ServiceContext context);
}
