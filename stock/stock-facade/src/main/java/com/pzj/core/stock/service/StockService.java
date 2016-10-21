/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock.service;

import com.pzj.core.stock.exception.rule.NotFoundStockRuleException;
import com.pzj.core.stock.model.CreateStockModel;
import com.pzj.core.stock.model.OccupyStockAndSeatModel;
import com.pzj.core.stock.model.OccupyStockRequestModel;
import com.pzj.core.stock.model.StockBatchLockModel;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;

/**
 * 操作库存服务.
 * <ul>
 * <li>占用库存</li>
 * <li>释放库存</li>
 * </ul>
 * @author yhy
 * @version $Id: StockServiceImpl.java, v 0.1 2016年7月26日 上午10:05:12 Administrator Exp $
 */
public interface StockService {
    /**
    *
    * <p><b>接口概述:</b></p>
    * 下单占库存.
    *
    * <p><b>消费端配置 &lt;dubbo:reference id="stockService" interface="com.pzj.stock.service.stock.StockService" timeout="1000" retries="0"/&gt;</b></p>
    * <p>HTTP+Get方式请求</p>
    * <p>
    * <table width='100%' cellpadding='1' cellspacing='1' bgcolor='gray'>
    *      <tr bgcolor="#DDDDDD" style="font-size: 12px;">
    *          <td>参数名</td>
    *          <td>类型</td>
    *          <td>是否必须(是或否)</td>
    *          <td>含义</td>
    *      </tr>
    *      <tr bgcolor="#DDDDDD" style="font-size: 12px;">
    *          <td>orderVO</td>
    *          <td>{@link OccupyStockRequestModel}</td>
    *          <td>是</td>
    *          <td>库存属性</td>
    *      </tr>
    * </table>
    * <p>响应消息:</p>
    * <table width='100%' cellpadding='1' cellspacing='1' bgcolor='gray'>
    *      <tr bgcolor="#DDDDDD" style="font-size: 12px;">
    *          <td>错误码</td><td>描述信息</td>
    *      </tr>
    *      <tr bgcolor="#DDDDDD" style="font-size: 12px;">
    *          <td>40001</td><td>调用方参数传递错误</td>
    *      </tr>
    *      <tr bgcolor="#DDDDDD" style="font-size: 12px;">
    *          <td>50001</td><td>库存服务程序异常</td>
    *      </tr>
    *      <tr bgcolor="#DDDDDD" style="font-size: 12px;">
    *          <td>50002</td><td>找不到相应库存</td>
    *      </tr>
    *      <tr bgcolor="#DDDDDD" style="font-size: 12px;">
    *          <td>50004</td><td>重复调用</td>
    *      </tr>
    *      <tr bgcolor="#DDDDDD" style="font-size: 12px;">
    *          <td>50003</td><td>修改库存数据校验错误</td>
    *      </tr>
    *      <tr bgcolor="#DDDDDD" style="font-size: 12px;">
    *          <td>10000</td><td>正常</td>
    *      </tr>
    * </table>
    * </p>
    * @return
    */
    public Result<Boolean> occupyStock(OccupyStockRequestModel orderStockModel, ServiceContext serviceContext);

    /**
    *
    * <p><b>接口概述:</b></p>
    * 释放库存.
    *
    * <p><b>消费端配置 &lt;dubbo:reference id="stockService" interface="com.pzj.stock.service.stock.StockService" timeout="1000" retries="0"/&gt;</b></p>
    * <p>HTTP+Get方式请求</p>
    * <p>
    * <table width='100%' cellpadding='1' cellspacing='1' bgcolor='gray'>
    *      <tr bgcolor="#DDDDDD" style="font-size: 12px;">
    *          <td>参数名</td>
    *          <td>类型</td>
    *          <td>是否必须(是或否)</td>
    *          <td>含义</td>
    *      </tr>
    *      <tr bgcolor="#DDDDDD" style="font-size: 12px;">
    *          <td>orderVO</td>
    *          <td>{@link OccupyStockRequestModel}</td>
    *          <td>是</td>
    *          <td>库存属性</td>
    *      </tr>
    * </table>
    * <p>响应消息:</p>
    * <table width='100%' cellpadding='1' cellspacing='1' bgcolor='gray'>
    *      <tr bgcolor="#DDDDDD" style="font-size: 12px;">
    *          <td>错误码</td><td>描述信息</td>
    *      </tr>
    *      <tr bgcolor="#DDDDDD" style="font-size: 12px;">
    *          <td>40001</td><td>调用方参数传递错误</td>
    *      </tr>
    *      <tr bgcolor="#DDDDDD" style="font-size: 12px;">
    *          <td>50001</td><td>库存服务程序异常</td>
    *      </tr>
    *      <tr bgcolor="#DDDDDD" style="font-size: 12px;">
    *          <td>50022</td><td>找不到相应库存历史操作数据</td>
    *      </tr>
    *      <tr bgcolor="#DDDDDD" style="font-size: 12px;">
    *          <td>50002</td><td>找不到相应库存</td>
    *      </tr>
    *      <tr bgcolor="#DDDDDD" style="font-size: 12px;">
    *          <td>50004</td><td>重复调用</td>
    *      </tr>
    *      <tr bgcolor="#DDDDDD" style="font-size: 12px;">
    *          <td>50003</td><td>修改库存数据校验错误</td>
    *      </tr>
    *      <tr bgcolor="#DDDDDD" style="font-size: 12px;">
    *          <td>10000</td><td>正常</td>
    *      </tr>
    * </table>
    * </p>
    * @return
    */
    public Result<Boolean> releaseStock(OccupyStockRequestModel orderStockModel, ServiceContext serviceContext);

    /**
     * 供应端批量占库存释放库存接口
     * @param stockBatcgLockList
     * @param serviceContext
     * @return
     */
    public Result<Boolean> stockBatchLock(StockBatchLockModel stockBatchLockModel, ServiceContext serviceContext);

    /**
     * 占库存且占座接口
     * @param occupyStockAndSeatModel
     * @param serviceContext
     * @return
     */
    public Result<Boolean> occupyStockAndSeat(OccupyStockAndSeatModel occupyStockAndSeatModel, ServiceContext serviceContext);

    /**
     * 交易占库存成占座失败后提供回滚库存接口
     * @param stockBatchLockModel
     * @param serviceContext
     * @return
     */
    public Result<Boolean> rollbackOccupyStock(OccupyStockRequestModel orderStockModel, ServiceContext serviceContext);

    /**
     * 创建库存(支持批量创建)
     * 
     * @author dongchunfu
     * @param model 库存Model
     * @return 创建数量
     * @throws NotFoundStockRuleException @see NotFoundStockRuleException
     */
    Result<Integer> createStock(CreateStockModel model, ServiceContext context);
}
