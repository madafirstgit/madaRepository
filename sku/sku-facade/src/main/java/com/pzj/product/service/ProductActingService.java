package com.pzj.product.service;

import java.util.ArrayList;

import com.pzj.core.product.model.ActingProductQueryRequstModel;
import com.pzj.core.product.model.AreaScreeingsRelModel;
import com.pzj.core.product.model.ProScreeningsQueryModel;
import com.pzj.core.product.model.ScreeingsModel;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;

public interface ProductActingService {
    Result<ArrayList<AreaScreeingsRelModel>> queryInfoForSkuProduct(ActingProductQueryRequstModel model, ServiceContext context);
    
    
    /**
     * 根据演艺产品查询场次信息
     * @param model
     * @param context
     * @return
     */
    Result<ScreeingsModel> queryScreeningsByActProductId(ProScreeningsQueryModel model, ServiceContext context);
}
