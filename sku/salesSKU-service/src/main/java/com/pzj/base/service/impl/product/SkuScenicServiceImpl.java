package com.pzj.base.service.impl.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzj.base.entity.product.ProductScenic;
import com.pzj.base.service.product.IProductScenicService;
import com.pzj.framework.context.Result;
import com.pzj.product.service.ISkuScenicService;
import com.pzj.product.vo.product.SkuScenic;
import com.pzj.product.vo.voParam.queryParam.SkuScenicQuery;
import com.pzj.util.productConvertUtil.ProductConvert;

@Service
public class SkuScenicServiceImpl implements ISkuScenicService{
   
	@Autowired
	IProductScenicService  productScenicService;

	public Result<ArrayList<SkuScenic>> findSkuScenicByName(SkuScenicQuery query) {
		
		List<ProductScenic> data = productScenicService.queryScenicsByName(query.getName());
		
		ArrayList<SkuScenic> resultData = ProductConvert.convertTSkuScenic(data);
		
		return new Result(resultData);
	}

}
