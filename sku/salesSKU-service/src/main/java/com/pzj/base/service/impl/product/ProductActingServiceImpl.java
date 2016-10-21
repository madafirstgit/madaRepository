package com.pzj.base.service.impl.product;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.pzj.core.product.model.ActingProductQueryRequstModel;
import com.pzj.core.product.model.AreaScreeingsRelModel;
import com.pzj.core.product.model.ProScreeningsQueryModel;
import com.pzj.core.product.model.ScreeingsModel;
import com.pzj.core.product.service.ActingProductService;
import com.pzj.framework.context.Result;
import com.pzj.framework.context.ServiceContext;
import com.pzj.product.service.ProductActingService;

@Service("productActingServiceImpl")
@Lazy
public class ProductActingServiceImpl implements ProductActingService {
	
	@Autowired
	ActingProductService actingProductService;

	@Override
	public Result<ArrayList<AreaScreeingsRelModel>> queryInfoForSkuProduct(
			ActingProductQueryRequstModel model, ServiceContext context) {
		
		return actingProductService.queryInfoForSkuProduct(model, context);
	}

	@Override
	public Result<ScreeingsModel> queryScreeningsByActProductId(
			ProScreeningsQueryModel model, ServiceContext context) {
		
		return actingProductService.queryScreeningsByActProductId(model, context);
	}

	
}
