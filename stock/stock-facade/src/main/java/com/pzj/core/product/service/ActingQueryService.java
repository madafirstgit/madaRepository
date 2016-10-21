/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.product.service;

import java.util.ArrayList;

import com.pzj.core.product.model.ActingModel;
import com.pzj.core.product.model.ActingQueryRequestModel;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;

/**
 * 演绎读操作
 * 
 * @author dongchunfu
 * @version $Id: ActingQueryService.java, v 0.1 2016年8月1日 下午3:00:06 dongchunfu Exp $
 */
public interface ActingQueryService {
    /**
     * 根据ID查询演绎
     * @author dongchunfu
     */
    Result<ActingModel> queryActingById(ActingQueryRequestModel model, ServiceContext context);

    /**
     * 获取该供应商持有的所有演绎
     * 供应商ID为必传参数
     * @author dongchunfu
     */
    Result<ArrayList<ActingModel>> queryActingByParam(ActingQueryRequestModel model, ServiceContext context);

}
