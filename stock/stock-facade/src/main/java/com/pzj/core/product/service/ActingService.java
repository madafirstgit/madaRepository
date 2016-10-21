/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.product.service;

import com.pzj.core.product.model.ActingModel;
import com.pzj.core.product.model.AddActingModel;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;

/**
 * 演绎写操作
 * 
 * @author dongchunfu
 * @version $Id: ActingService.java, v 0.1 2016年8月1日 下午2:57:46 dongchunfu Exp $
 */
public interface ActingService {
    /**
     * 创建演绎产品
     * @author dongchunfu
     * @param ActingModel 演绎实体
     * @return Result<Integer> 新增实体数量
     */
    public Result<Long> createActing(ActingModel model, ServiceContext context);

    /**
     * 更新演绎产品
     * @author dongchunfu
     * @param ActingModel 演绎实体
     * @return Result<Integer> 更新数量
     */
    public Result<Integer> updateActing(ActingModel model, ServiceContext context);

    /**
     * web端添加演艺数据
     * @param model
     * @param context
     * @return Result<Boolean> 返回操作结果 true 成功 false 失败
     */
    public Result<Boolean> addActing(AddActingModel model, ServiceContext context);
}
