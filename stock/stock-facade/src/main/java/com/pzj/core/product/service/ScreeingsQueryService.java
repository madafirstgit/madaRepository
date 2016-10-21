/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.product.service;

import java.util.ArrayList;

import com.pzj.core.product.model.ScreeingsModel;
import com.pzj.core.product.model.ScreeingsQueryRequestModel;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;

/**
 * 演绎场次读操作
 * @author dongchunfu
 * @version $Id: ActingAreaService.java, v 0.1 2016年8月1日 上午10:37:43 dongchunfu Exp $
 */
public interface ScreeingsQueryService {
    /**
     * 根据ID查询演绎场次
     * @author dongchunfu
     */
    Result<ScreeingsModel> queryScreeingsById(ScreeingsQueryRequestModel model, ServiceContext context);

    /**
     * 获取该供应商持有的所有场次
     * 供应商ID为必传参数
     * @author dongchunfu
     */
    Result<ArrayList<ScreeingsModel>> queryScreeingsesByParam(ScreeingsQueryRequestModel model, ServiceContext context);
}
