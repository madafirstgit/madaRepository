package com.pzj.core.product.validator.actingproduct;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.pzj.core.common.utils.CommonUtils;
import com.pzj.core.product.model.ActingProductModel;
import com.pzj.core.product.model.AreaModel;
import com.pzj.core.product.model.ScreeingsModel;
import com.pzj.framework.context.ServiceContext;
import com.pzj.framework.converter.ObjectConverter;
import com.pzj.framework.toolkit.Check;

/**
 * 创建演绎产品时收集产品的相关信息验证器
 * @author dongchunfu
 *
 */
@Component(value = "creatActingProductValidator")
public class CreatActingProductValidator implements ObjectConverter<ActingProductModel, ServiceContext, Boolean> {

    private static final Logger logger = LoggerFactory.getLogger(CreatActingProductValidator.class);

    @Override
    public Boolean convert(ActingProductModel model, ServiceContext context) {

        if (Check.NuNObject(model, context)) {
            logger.error("illegal param,request:{},context:{}. ", model, context);
            return Boolean.FALSE;
        }

        Long actingId = model.getActingId();
        if (CommonUtils.checkLongIsNull(actingId, Boolean.TRUE)) {
            logger.error("illegal acting id:{},context:{}. ", actingId, context);
            return Boolean.FALSE;
        }

        ArrayList<AreaModel> areas = model.getAreas();
        if (null == areas || areas.size() == 0) {
            logger.error("illegal areas :{},context:{}. ", areas, context);
            return Boolean.FALSE;
        }

        ArrayList<ScreeingsModel> screeingses = model.getScreeingses();
        if (null == screeingses || screeingses.size() == 0) {
            logger.error("illegal screeingses :{},context:{}. ", screeingses, context);
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }
}
