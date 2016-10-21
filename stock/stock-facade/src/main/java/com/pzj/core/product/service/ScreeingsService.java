/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.product.service;

import com.pzj.core.product.model.ScreeingsModel;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;

/**
 * 演绎场次写操作
 * @author dongchunfu
 * @version $Id: ActingAreaService.java, v 0.1 2016年8月1日 上午10:37:43 dongchunfu Exp $
 */
public interface ScreeingsService {
    /**
     * 创建演绎场次
     * @author dongchunfu
     * @param screeings 场次实体
     * @return Result<Long> 新增实体ID
     */
    public Result<Long> createScreeings(ScreeingsModel model, ServiceContext context);

    /**
     * 更新演绎场次
     * @author dongchunfu
     * @param screeings 场次实体
     * @return Result<Integer> 更新数量
     */
    public Result<Integer> updateScreeings(ScreeingsModel model, ServiceContext context);
}
