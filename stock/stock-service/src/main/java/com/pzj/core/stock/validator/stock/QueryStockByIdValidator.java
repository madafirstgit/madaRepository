package com.pzj.core.stock.validator.stock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.pzj.core.common.utils.CommonUtils;
import com.pzj.core.stock.model.StockQueryRequestModel;
import com.pzj.framework.context.ServiceContext;
import com.pzj.framework.converter.ObjectConverter;
import com.pzj.framework.toolkit.Check;

/**
 * 主键查库存参数验证器
 * @author dongchunfu
 *
 */
@Component(value = "queryStockByIdValidator")
public class QueryStockByIdValidator implements ObjectConverter<StockQueryRequestModel, ServiceContext, Boolean> {

    private static final Logger logger = LoggerFactory.getLogger(QueryStockByIdValidator.class);

    @Override
    public Boolean convert(StockQueryRequestModel model, ServiceContext context) {
        if (Check.NuNObject(model, context)) {
            if (logger.isDebugEnabled()) {
                logger.debug("illegal param ,request:{},context:{}.", model, context);
            }
            return Boolean.FALSE;
        }
        Long stockId = model.getStockId();
        if (CommonUtils.checkLongIsNull(stockId, true)) {
            if (logger.isDebugEnabled()) {
                logger.debug("illegal param ,stockId:{},context:{}.", stockId, context);
            }
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
