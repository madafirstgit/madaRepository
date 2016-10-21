/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.product.service;

import java.util.ArrayList;

import com.pzj.core.common.exception.ParameterErrorException;
import com.pzj.core.common.exception.StockException;
import com.pzj.core.product.exception.NotFoundAreaScreeingsRelException;
import com.pzj.core.product.model.ActingProductModel;
import com.pzj.core.product.model.ActingProductQueryRequstModel;
import com.pzj.core.product.model.AreaScreeingsRelModel;
import com.pzj.core.product.model.ProScreeningsQueryModel;
import com.pzj.core.product.model.ScreeingsModel;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;

/**
 * 
 * @author dongchunfu
 * @version $Id: CreatActingProductService.java, v 0.1 2016年8月8日 上午10:05:20 dongchunfu Exp $
 */
public interface ActingProductService {
    /**
     * 创建演艺产品
     * @author dongchunfu
     * @param model 演艺产品请求参数，由关系表处理
     * @return 创建数量
     */
    Result<Integer> createActingProduct(ActingProductModel model, ServiceContext context);

    /**
     * 景区创建产品创建时获取相应的区域ID，区域名称，场次ID，场次名称。（供景区使用）
     * 
     * @author dongchunfu
     * @param model 演艺信息参数参数
     * @return 对应集合的key为 acting area screeings 
     */
    Result<ArrayList<AreaScreeingsRelModel>> queryInfoForSkuProduct(ActingProductQueryRequstModel model, ServiceContext context);

    /**
     * 根据演艺产品查询场次信息
     * @param model
     * @param context
     * @return
     */
    Result<ScreeingsModel> queryScreeningsByActProductId(ProScreeningsQueryModel model, ServiceContext context);

    /**
     * 根据供应商ID 及景区ID 获取演艺相关的数据 区域/场次/演艺（供web使用）
     * 
     * @param model 演艺产品请求参数
     * @param context 服务上下文
     * @return 返回符合要求的 演艺/区域/场次集合信息
     */
    Result<ActingProductModel> queryInfoForCreateActingProduct(ActingProductQueryRequstModel model, ServiceContext context);

    /**
     * 根据演绎产品，即中间表ID查询演绎产品的区域信息及场次信息，不含库存相关信息
     * 
     * @param model 演绎产品查询参数
     * @return 演绎产品信息，主要返回参数详见wiki：
     * @throws NotFoundAreaScreeingsRelException @see NotFoundAreaScreeingsRelException
     * @throws ParameterErrorException @see ParameterErrorException
     * @throws StockException @see StockException
     */
    Result<ActingProductModel> queryActProInfo(ActingProductQueryRequstModel model, ServiceContext context);

    /**
     * 根据产品关联演艺ID查询演艺信息详情
     * @param model
     * @param context
     * @return Result<AreaScreeingsRelModel>
     */
    Result<AreaScreeingsRelModel> queryAreaScreeRelByProAct(ActingProductQueryRequstModel model, ServiceContext context);
}
