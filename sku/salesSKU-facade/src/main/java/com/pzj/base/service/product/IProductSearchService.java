package com.pzj.base.service.product;

import java.util.List;

import com.pzj.common.QueryPageList;
import com.pzj.common.QueryPageModel;
import com.pzj.product.vo.voParam.queryParam.SkuProductForScenicQuery;
import com.pzj.product.vo.voParam.queryParam.SpuProductForCommonsQueryParam;
import com.pzj.product.vo.voParam.queryParam.SpuProductQueryParamVO;
import com.pzj.product.vo.voParam.resultParam.*;

public interface IProductSearchService {
	public List<SpuProductResultVO> querySpuProductForApp(SpuProductQueryParamVO vo) throws Exception ;
	
	public QueryPageList<SpuProductResultVO> querySpuProductForApp(SpuProductQueryParamVO vo, QueryPageModel queryPageModel)throws Exception;
	
	/**
	 * 根据分销商和销售端口获取可看的省市
	 * @param distributorId
	 * @param saleType
	 * @return
	 */
    public List<PCAddressResult> queryAddressByDistributorId(Long distributorId,
	            String saleType) ;

	QueryPageList<SpuProductResultVO> querySpuProductForCommons(SpuProductForCommonsQueryParam param,
																QueryPageModel queryPageModel);

	QueryPageList<SkuProductForScenic> querySpuProductForScenic(SkuProductForScenicQuery param,
																QueryPageModel queryPageModel);
}
