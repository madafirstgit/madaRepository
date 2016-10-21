package com.pzj.product.service;

import java.util.ArrayList;

import com.pzj.framework.context.Result;
import com.pzj.product.vo.product.SkuScenic;
import com.pzj.product.vo.voParam.queryParam.SkuScenicQuery;

public interface ISkuScenicService {
	
	Result<ArrayList<SkuScenic>> findSkuScenicByName(SkuScenicQuery query);

}
