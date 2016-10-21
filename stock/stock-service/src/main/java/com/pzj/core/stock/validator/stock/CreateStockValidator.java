package com.pzj.core.stock.validator.stock;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.pzj.core.stock.model.CreateStockModel;
import com.pzj.framework.context.ServiceContext;
import com.pzj.framework.converter.ObjectConverter;
import com.pzj.framework.toolkit.Check;

/**
 * 创建库存参数验证器
 * 
 * @version 1.0.0
 * @author dongchunfu
 */
@Component(value = "createStockValidator")
public class CreateStockValidator implements ObjectConverter<CreateStockModel, ServiceContext, Boolean> {

    private static final Logger logger = LoggerFactory.getLogger(CreateStockValidator.class);

    /**
     * @param model 创建库存参数，规则ID不得为空
     * @return <code>true</code> validate success,<code>false</code> validate false.
     */
    @Override
    public Boolean convert(CreateStockModel model, ServiceContext context) {

        if (Check.NuNObject(model)) {
            if (logger.isDebugEnabled()) {
                logger.debug("illegal param ,request:{},context:{}.", model, context);
            }
            return Boolean.FALSE;
        }

        List<Long> ruleIds = model.getRuleIds();
        if (null == ruleIds || ruleIds.size() == 0) {
            if (logger.isDebugEnabled()) {
                logger.debug("illegal param ,ruleIds is null ,context:{}.", context);
            }
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

}
