/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock.validator.stock;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.pzj.core.common.utils.CommonUtils;
import com.pzj.core.stock.enums.OperateStockBussinessType;
import com.pzj.core.stock.model.ParamModel;
import com.pzj.core.stock.model.StockBatchLockModel;
import com.pzj.framework.context.ServiceContext;
import com.pzj.framework.converter.ObjectConverter;

/**
 * 
 * @author Administrator
 * @version $Id: StockBatchLockValidator.java, v 0.1 2016年8月3日 下午7:22:17 Administrator Exp $
 */
@Component("stockBatchLockValidator")
public class StockBatchLockValidator implements ObjectConverter<StockBatchLockModel, ServiceContext, ParamModel> {

    @Override
    public ParamModel convert(StockBatchLockModel stockBatchLockModel, ServiceContext context) {
        ParamModel paramModel = ParamModel.getInstance();
        if (CommonUtils.checkObjectIsNull(stockBatchLockModel)) {
            paramModel.setErrorModel("批量占、释放库存传入StockBatchLockModel数据对象是空!");
            return paramModel;
        }

        Long userId = stockBatchLockModel.getUserId();
        Integer operateType = stockBatchLockModel.getOperateType();
        Map<Long, Integer> stockMap = stockBatchLockModel.getOperateStockMap();
        if (CommonUtils.checkLongIsNull(userId, true)) {
            paramModel.setErrorModel("批量占、释放库存传入userId用户ID是空!");
            return paramModel;
        }
        if (CommonUtils.checkIntegerIsNull(operateType, true)) {
            paramModel.setErrorModel("批量占、释放库存传入operateType操作类型是空!");
            return paramModel;
        }
        if (operateType != OperateStockBussinessType.BATCH_OCCUPY_STOCK.key && operateType != OperateStockBussinessType.BATCH_RELEASE_STOCK.key) {
            paramModel.setErrorModel("批量占、释放库存传入operateType操作类型传入有误!");
            return paramModel;
        }
        if (CommonUtils.checkObjectIsNull(stockMap)) {
            paramModel.setErrorModel("批量占、释放库存传入stockMap操作库存map是空!");
            return paramModel;
        }

        return paramModel;
    }

}
