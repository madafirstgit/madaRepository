/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.product.service;

import java.util.ArrayList;

import com.pzj.core.product.model.AreaModel;
import com.pzj.core.product.model.AreaQueryRequestModel;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;

/**
 * 演绎区域读操作
 * @author dongchunfu
 * @version $Id: ActingAreaService.java, v 0.1 2016年8月1日 上午10:37:43 dongchunfu Exp $
 */
public interface AreaQueryService {
    /**
     * 根据ID查询演绎区域
     * @author dongchunfu
     */
    Result<AreaModel> queryAreaById(AreaQueryRequestModel model, ServiceContext context);

    /**
     * 获取该供应商持有的所有区域
     * 供应商ID为必传参数
     * @author dongchunfu
     */
    Result<ArrayList<AreaModel>> queryAreasByParam(AreaQueryRequestModel model, ServiceContext context);

    /**
     * 座位图界面加载获取区域列表
     * @param model
     * @param context
     * @return
     */
    Result<ArrayList<AreaModel>> queryAreasByWebSeatChartParam(AreaQueryRequestModel model, ServiceContext context);

}
