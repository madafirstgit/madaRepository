/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock.validator.stock;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.pzj.core.stock.model.StockQueryRequestModel;
import com.pzj.framework.context.ServiceContext;
import com.pzj.framework.converter.ObjectConverter;
import com.pzj.framework.toolkit.Check;

/**
 * 
 * @author dongchunfu
 * @version $Id: QueryStockRuleValidator.java, v 0.1 2016年8月3日 下午7:44:45 dongchunfu Exp $
 */
@Component(value = "queryStocksValidator")
public class QueryStocksValidator implements ObjectConverter<StockQueryRequestModel, ServiceContext, Boolean> {

    private static final Logger logger = LoggerFactory.getLogger(QueryStocksValidator.class);

    @Override
    public Boolean convert(StockQueryRequestModel model, ServiceContext context) {
        if (Check.NuNObject(model, context)) {
            if (logger.isDebugEnabled()) {
                logger.debug("illegal param ,request:{},context:{}.", model, context);
            }
            return Boolean.FALSE;
        }
        Long ruleId = model.getRuleId();
        List<Long> stockIds = model.getStockIds();

        if (null == ruleId && null == stockIds) {
            if (logger.isDebugEnabled()) {
                logger.debug("illegal param ,ruleId and stockIds are all null ,context:{}.", context);
            }
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

}
