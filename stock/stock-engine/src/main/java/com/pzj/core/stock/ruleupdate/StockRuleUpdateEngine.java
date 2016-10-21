/**
 * piaozhijia.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved.
 */
package com.pzj.core.stock.ruleupdate;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.pzj.core.common.exception.StockException;
import com.pzj.core.stock.entity.StockRule;
import com.pzj.core.stock.exception.errcode.StockExceptionCode;
import com.pzj.core.stock.model.StockRuleModel;
import com.pzj.core.stock.write.StockRuleWriteMapper;
import com.pzj.framework.context.ServiceContext;

/**
 * 
 * @author dongchunfu
 * @version $Id: StockRuleUpdateStateEngine.java, v 0.1 2016年8月5日 下午4:54:54 dongchunfu Exp $
 */
@Component(value = "stockRuleUpdateEngine")
@Transactional(value = "stock.transactionManager")
public class StockRuleUpdateEngine {

    private static final Logger  logger = LoggerFactory.getLogger(StockRuleUpdateEngine.class);

    @Autowired
    private StockRuleWriteMapper stockRuleWriteMapper;

    public int updateStockRule(StockRuleModel model, ServiceContext context) {
        StockRule rule = new StockRule();

        try {
            PropertyUtils.copyProperties(rule, model);
        } catch (Exception e) {
            logger.error(" copy stock rule model properties to stock rule error ", e);
            throw new StockException(StockExceptionCode.STOCK_ERR_MSG, e);
        }

        int count = stockRuleWriteMapper.updateStockRuleById(rule);
        return count;
    }
}
