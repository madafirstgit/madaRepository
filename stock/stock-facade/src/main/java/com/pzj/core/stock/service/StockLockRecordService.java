/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock.service;

import com.pzj.core.stock.model.LockRecordModel;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;

/**
 * 
 * @author Administrator
 * @version $Id: StockLockRecordService.java, v 0.1 2016年7月26日 下午5:12:00 Administrator Exp $
 */
public interface StockLockRecordService {
    public Result<LockRecordModel> queryStockLockRecordByParam(LockRecordModel lockRecordVO, ServiceContext serviceContext);
}
