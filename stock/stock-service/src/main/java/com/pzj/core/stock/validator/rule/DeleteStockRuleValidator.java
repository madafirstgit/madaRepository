package com.pzj.core.stock.validator.rule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.pzj.core.common.utils.CommonUtils;
import com.pzj.core.stock.model.StockRuleModel;
import com.pzj.framework.context.ServiceContext;
import com.pzj.framework.converter.ObjectConverter;
import com.pzj.framework.toolkit.Check;

/**
 * 更新库存规则基础验证
 * @author YRJ
 *
 */
@Component(value = "deleteStockRuleValidator")
public class DeleteStockRuleValidator implements ObjectConverter<StockRuleModel, ServiceContext, Boolean> {
    private static final Logger logger = LoggerFactory.getLogger(DeleteStockRuleValidator.class);

    @Override
    public Boolean convert(StockRuleModel model, ServiceContext context) {
        if (Check.NuNObject(model, context)) {
            logger.warn("update stock rule param error ,request:{},context:{}.", model, context);
            return Boolean.FALSE;
        }

        if (CommonUtils.checkLongIsNull(model.getId(), true)) {
            logger.warn("update stock rule ruleId param error ,ruleId:{},context:{}.", model.getId(), context);
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }
}
