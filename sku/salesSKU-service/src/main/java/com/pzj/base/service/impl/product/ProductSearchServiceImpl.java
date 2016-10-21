package com.pzj.base.service.impl.product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.pzj.base.common.global.GlobalDict;
import com.pzj.base.common.global.GlobalParam;
import com.pzj.base.entity.SysChannel;
import com.pzj.base.entity.SysChannelStrategy;
import com.pzj.base.entity.product.ProductCloseTimeslot;
import com.pzj.base.entity.product.ProductInfo;
import com.pzj.base.entity.product.ProductRelation;
import com.pzj.base.entity.product.ProductRelease;
import com.pzj.base.entity.product.ProductScenic;
import com.pzj.base.entity.query.DateQueryParam;
import com.pzj.base.service.exception.SkuServiceException;
import com.pzj.base.service.product.IProductCloseTimeslotService;
import com.pzj.base.service.product.IProductInfoSearchService;
import com.pzj.base.service.product.IProductRelationService;
import com.pzj.base.service.product.IProductReleaseSearchService;
import com.pzj.base.service.product.IProductReleaseService;
import com.pzj.base.service.product.IProductScenicService;
import com.pzj.base.service.product.IProductSearchService;
import com.pzj.base.service.product.IStrategySearchService;
import com.pzj.channel.vo.resultParam.PCStrategyResult;
import com.pzj.common.QueryPageList;
import com.pzj.common.QueryPageModel;
import com.pzj.product.vo.product.SkuCloseTimeSlot;
import com.pzj.product.vo.product.SkuProduct;
import com.pzj.product.vo.product.SpuProduct;
import com.pzj.product.vo.voParam.queryParam.AppSearchQuery;
import com.pzj.product.vo.voParam.queryParam.SkuProductForScenicQuery;
import com.pzj.product.vo.voParam.queryParam.SkuProductQuery;
import com.pzj.product.vo.voParam.queryParam.SpuProductForCommonsQueryParam;
import com.pzj.product.vo.voParam.queryParam.SpuProductQuery;
import com.pzj.product.vo.voParam.queryParam.SpuProductQueryParamVO;
import com.pzj.product.vo.voParam.resultParam.PCAddressResult;
import com.pzj.product.vo.voParam.resultParam.SkuProductForScenic;
import com.pzj.product.vo.voParam.resultParam.SpuProductResultVO;
import com.pzj.util.productConvertUtil.CommonConvert;
import com.pzj.util.productConvertUtil.ProductConvert;
import com.pzj.util.productConvertUtil.StrategyConvert;

/**
 * 产品发布关系服务接口
 *
 * @author apple
 *
 */
@Service
@Lazy
public class ProductSearchServiceImpl implements IProductSearchService {
	private Logger logger = LoggerFactory
			.getLogger(StrategySearchServiceImpl.class);

	@Autowired
	IStrategySearchService strategySearchService;

	@Autowired
	IProductScenicService productScenicService;

	@Autowired
	IProductInfoSearchService productInfoSearchService;

	@Autowired
	IProductReleaseSearchService productReleaseSearchService;

	@Autowired
	IProductRelationService productRelationService;

	@Autowired
	ProductSearchServiceUtil productSearchServiceUtil;

	@Autowired
	IProductReleaseService productReleaseService;

	@Autowired
	IProductCloseTimeslotService productCloseTimeslotService;

	/**
	 * 通用产品的所有类型
	 */
	private List<Integer> spuCommonsProductTypes = Arrays.asList(GlobalDict.ProductCategory.busCharter
			,GlobalDict.ProductCategory.lineProduct
			,GlobalDict.ProductCategory.tripPhotos
			,GlobalDict.ProductCategory.shuttleBus
			,GlobalDict.ProductCategory.nativeProduct
			,GlobalDict.ProductCategory.guideProduct
			,GlobalDict.ProductCategory.room
			,GlobalDict.ProductCategory.restaurant);
	private List<String> skuCommonsProductTypes = Arrays.asList(GlobalDict.ProductCategory.busCharter()
			,GlobalDict.ProductCategory.lineProduct()
			,GlobalDict.ProductCategory.tripPhotos()
			,GlobalDict.ProductCategory.shuttleBus()
			,GlobalDict.ProductCategory.nativeProduct()
			,GlobalDict.ProductCategory.guideProduct()
			,GlobalDict.ProductCategory.room()
			,GlobalDict.ProductCategory.restaurant());

	/**
	 * 景区产品的所有类型
	 */
	private List<String> skuScenicProductTypes = Arrays.asList(GlobalDict.ProductCategory.normal()
			,GlobalDict.ProductCategory.scenic());
	private List<Integer> spuScenicProductTypes = Arrays.asList(GlobalDict.ProductCategory.normal
			,GlobalDict.ProductCategory.scenic);

	@Override
	public List<SpuProductResultVO> querySpuProductForApp(
			SpuProductQueryParamVO vo) throws Exception {
		List<SpuProductResultVO> result = null;
		QueryPageList<SpuProductResultVO> resultPage = querySpuProductForApp(
				vo, null);
		if (resultPage != null) {
			result = resultPage.getResultList();
		}
		return result;
	}

	public QueryPageList<SpuProductResultVO> querySpuProductForApp(
			SpuProductQueryParamVO vo, QueryPageModel queryPageModel)
			throws Exception {
		try{
			QueryPageList<SpuProductResultVO> result = null;
			
			logger.info("querySpuProductForApp的入参:"+vo.toString());
			long strategy_start = System.currentTimeMillis();
			//1.过滤产品数据			
			/*List<Long> q_skuIds = findSkuProductIdsByParam(vo.getSkuProductParam(),vo.getSpuProductParam(),vo.getAppSearchQuery());
			if (CollectionUtils.isEmpty(q_skuIds)) {
				throw new Exception("根据产品参数查询不到产品");
			}		
			logger.info("按照产品查询参数查询产品的效率："+(System.currentTimeMillis() - strategy_start));*/
	        
			
			//1.根据分销商获取政策数据
			//logger.info("进入政策过滤：[IStrategySearchService.querySkuStrategyByDistributorId]");
			Map<Long, List<PCStrategyResult>> pcsMap = strategySearchService.querySkuStrategyByDistributorId(vo.getDistributorId(),vo.getSalesType(), vo.getTicketVarie(),null);
			if (pcsMap == null || pcsMap.isEmpty()) {
				logger.error("根据分销商id:{},销售端口:{}没有查询到有效的政策数据",vo.getDistributorId(),vo.getSalesType());
				return result;
			}

			//2.根据产品id集合查询产品信息
			//logger.info("进入产品过滤：[IProductReleaseSearchService.queryByParam]");
			long sku_start = System.currentTimeMillis();
			List<Long> skuIds = new ArrayList<>(pcsMap.keySet());
			List<SkuProduct> skuList = productReleaseSearchService.queryByParam(vo.getSkuProductParam(),
					skuIds);
			if (CollectionUtils.isEmpty(skuList)) {
				logger.error("根据产品id集合:{}和产品查询参数:{}没有查询到有效的产品数据",vo.getDistributorId(),vo.getSalesType());
				return result;
			}
			logger.debug("政策过滤产品的效率："+(System.currentTimeMillis() - sku_start));

			//3.获取分销商下的产品组
			//logger.info("进入产品过滤：[IProductInfoSearchService.queryPageByAppParam]");
			long spu_start = System.currentTimeMillis();
			QueryPageList<SpuProduct> infoList = productInfoSearchService.queryPageByAppParam(
					queryPageModel, vo.getSpuProductParam(), vo.getAppSearchQuery(),
					ProductConvert.getSpuIdList(skuList));
			logger.debug("查询信息过滤产品组的效率："+(System.currentTimeMillis() - spu_start));

			//4.组织返回对象
			result = getSpuProductResultVOQueryPageList(pcsMap, skuList, infoList);
			if(result == null || result.isEmpty()){
				logger.info("查询产品为空");
			}else{
				List<SpuProductResultVO> resultList = result.getResultList();
				logger.info("querySpuProductForApp的出参：");
				for(SpuProductResultVO vo1 :resultList){
		        	logger.info(vo1.toString());
		        }
			}	
			return result;
		}catch(Exception ex){
			logger.error("查询接口[querySpuProductForApp]出错:{}",ex);
			ex.printStackTrace();
		}
		return null;
	}
	
	private List<Long> findSkuProductIdsByParam(SkuProductQuery queryParam, SpuProductQuery spuProductParam, AppSearchQuery appSearchQuery){
		if(spuProductParam == null){
			spuProductParam = new SpuProductQuery();
		}
		if(queryParam == null){
			queryParam = new SkuProductQuery();
		}
		if(appSearchQuery == null){
			appSearchQuery = new AppSearchQuery();
		}
		List<Long> result = new ArrayList<Long>();
		//1.根据app查询景区信息
		 List<ProductScenic> scenics = productScenicService.queryScenicsByAppSearchKey(appSearchQuery);
		 if(CollectionUtils.isEmpty(scenics)){
			 logger.info("没有符合条件的景区");
		 }else{
			 List<Long> scenicIds = CommonConvert.getIdList(scenics);
		     List<Long> infoIds =  productRelationService.queryProductInfoIdsByScenicIds(scenicIds, null);
		     if(CollectionUtils.isEmpty(scenics)){
				 logger.info("景区里没有关联的产品组");
			 }else{
				 spuProductParam.setIds(CommonConvert.intersectionList(infoIds, spuProductParam.getIds()));
		         List<ProductInfo> spuList2 = productInfoSearchService.findByAppParam(spuProductParam,appSearchQuery);
		         if(CollectionUtils.isEmpty(spuList2)){
		        	 logger.info("没有符合条件的景区产品组");
		         }else{
		        	 List<Long> spuIds2 = CommonConvert.getIdList(spuList2);
					 spuIds2 = CommonConvert.intersectionList(spuIds2, queryParam.getProductIds());
					 queryParam.setProductIds(spuIds2);
			         List<ProductRelease> prList2 = productReleaseSearchService.queryByParam(ProductConvert.convertTProduct(queryParam));
			         List<Long> result2 = CommonConvert.getIdList(prList2);
			         if(CollectionUtils.isNotEmpty(result2)){
						result.addAll(result2);
					 }  
		         }
		         
			 }
	       
		 }	
		//2.根据app查询产品组信息
	    if(appSearchQuery.getId() == null){	    	
	    	spuProductParam.setProductTypes(spuCommonsProductTypes);
	    	List<ProductInfo> spuList1 = productInfoSearchService.findByAppParam(spuProductParam,appSearchQuery);
	    	if(CollectionUtils.isEmpty(spuList1)){
	    		 logger.info("没有符合条件的通用产品组");
	    	}else{
	    		List<Long> spuIds1 = CommonConvert.getIdList(spuList1);
				spuIds1 = CommonConvert.intersectionList(spuIds1, queryParam.getProductIds());
				queryParam.setProductIds(spuIds1);
				List<ProductRelease> prList1 = productReleaseSearchService.queryByParam(ProductConvert.convertTProduct(queryParam));
				List<Long> result1 = CommonConvert.getIdList(prList1);
				if(CollectionUtils.isNotEmpty(result1)){
					result.addAll(result1);
				}
	    	}
			
	    }
         
         return result;
		
		
		
	}
	

	private QueryPageList<SpuProductResultVO> getSpuProductResultVOQueryPageList(Map<Long, List<PCStrategyResult>> pcsMap, List<SkuProduct> skuList, QueryPageList<SpuProduct> infoList) throws Exception {
		QueryPageList<SpuProductResultVO> resultPageList = null;
		if (infoList != null && !infoList.isEmpty()) {
			List<SpuProduct> spuList = infoList.getResultList();
			List<SpuProductResultVO> resultList = ProductConvert
					.combinationSpuProductResult(spuList, skuList, pcsMap);
			resultPageList = new QueryPageList<SpuProductResultVO>();
			resultPageList.setResultList(resultList);
			resultPageList.setPageBean(infoList.getPageBean());
		}
		return resultPageList;
	}

	/**
	 * 根据景区名称，景区省市县查询景区对应的产品id集合
	 *
	 * @param query
	 * @return
	 */
	public List<Long> queryScenicProductIdsByAppSearchKey(AppSearchQuery query) {

		List<ProductScenic> scenics = productScenicService
				.queryScenicsByAppSearchKey(query);
		List<Long> scenicIds = CommonConvert.getIdList(scenics);
		return productRelationService.queryProductIdsByScenicIds(scenicIds);
	}

	/**
	 * 获取分销商可看的产品id集合
	 *
	 * @param distributorId
	 * @param saleType
	 * @return
	 */
	private List<Long> querySkuIdByDistributorId(Long distributorId,
												 String saleType) {
		if (distributorId == null) {
			return null;
		}
		// 1.根据分销商id查询有效的渠道
		List<SysChannel> channels = strategySearchService
				.queryValidChannelsByUSid(distributorId, null);

		// 2.查询渠道id对应的有效政策列表
		List<SysChannelStrategy> strategys = strategySearchService
				.queryValidStrategysByCids(CommonConvert.getIdList(channels),
						saleType);

		//3.获取产品id集合
		return StrategyConvert.getProductIdsByStategys(strategys);
	}




	public List<PCAddressResult> queryAddressByDistributorId(
			Long distributorId, String saleType) {
		List<Long> productIds = null;
		if (distributorId != null) {
			productIds = querySkuIdByDistributorId(distributorId, saleType);
		}
		Set<PCAddressResult> set = new HashSet<PCAddressResult>();
		List<ProductScenic> scenicList = productScenicService
				.findAddressByProductId(productIds);
		List<ProductInfo> infoList = productInfoSearchService
				.findAddressByProductId(productIds);
		ProductConvert.convertPSTPCAddress(scenicList, set);
		ProductConvert.convertPITPCAddress(infoList, set);

		return new ArrayList<PCAddressResult>(set);

	}

	@Override
	public QueryPageList<SpuProductResultVO> querySpuProductForCommons(SpuProductForCommonsQueryParam param,
																	   QueryPageModel queryPageModel) {
		Map<Long, List<PCStrategyResult>> pcsMap = null;
		try {
			//1.根据分销商获取政策数据
			pcsMap = strategySearchService.querySkuStrategyByDistributorId(param.getResellerId(), param.getSalesType(), param.getTicketVarie());
			if (pcsMap == null || pcsMap.isEmpty()) {
				throw new Exception("根据分销商查询没有有效的政策数据与产品关联");
			}

			//2.根据产品id集合查询产品信息
			String start = GlobalParam.FLAG.start().toString();
			String agree = GlobalParam.FLAG.agree().toString();
			SkuProductQuery skuProductParam = param.getSkuProductQuery();
			if (skuProductParam == null)
				skuProductParam = new SkuProductQuery();
			skuProductParam.setFlag(start);
			skuProductParam.setAuditStatus(agree);
			if (CollectionUtils.isEmpty(skuProductParam.getProCategorys())){
				skuProductParam.setProCategorys(skuCommonsProductTypes);
			}

			SpuProductQuery spuProductQuery = param.getSpuProductQuery();
			if (spuProductQuery == null){
				spuProductQuery = new SpuProductQuery();
			}
			List<Integer> productTypes = spuProductQuery.getProductTypes();

			if (CollectionUtils.isEmpty(productTypes)){
				spuProductQuery.setProductTypes(spuCommonsProductTypes);
			}

			List<SkuProduct> skuList = productReleaseSearchService.queryByParam(skuProductParam,
					new ArrayList<Long>(pcsMap.keySet()));
			if (CollectionUtils.isEmpty(skuList)) {
				throw new Exception("根据分销商查询没有有效的产品数据");
			}

			List<Long> spuIdList = ProductConvert.getSpuIdList(skuList);

			//3.获取分销商下的产品组
			QueryPageList<SpuProduct> infoList = productInfoSearchService.queryPageByCommonsParam(
					queryPageModel, spuProductQuery,
					spuIdList);

			QueryPageList<SpuProductResultVO> result = getSpuProductResultVOQueryPageList(pcsMap, skuList, infoList);

			if (result == null)
				return result;


			ProductCloseTimeslot query = new ProductCloseTimeslot();
			query.setProductInfoIds(spuIdList);
			List<ProductCloseTimeslot> productCloseTimeslotList = productCloseTimeslotService.findListByParams(query);

			if (CollectionUtils.isNotEmpty(productCloseTimeslotList)) {
				List<SpuProductResultVO> resultList = result.getResultList();

				Map<Long, SpuProductResultVO> spuProductResultVOMap = new HashedMap(resultList.size());
				for (SpuProductResultVO spuProductResultVO : resultList) {
					spuProductResultVOMap.put(spuProductResultVO.getSpuProduct().getId(), spuProductResultVO);
				}

				for (ProductCloseTimeslot productCloseTimeslot : productCloseTimeslotList) {
					Long productInfoId = productCloseTimeslot.getProductInfoId();
					SpuProductResultVO resultVO = spuProductResultVOMap.get(productInfoId);
					if (resultVO != null) {
						List<SkuCloseTimeSlot> closeTimeSlotList = resultVO.getCloseTimeSlotList();
						if (closeTimeSlotList == null) {
							closeTimeSlotList = new ArrayList<>();
							resultVO.setCloseTimeSlotList(closeTimeSlotList);
						}
						SkuCloseTimeSlot skuCloseTimeSlot = new SkuCloseTimeSlot();
						CommonConvert.copyProperties(skuCloseTimeSlot, productCloseTimeslot);
						closeTimeSlotList.add(skuCloseTimeSlot);

					}
				}
			}


			//4.组织返回对象
			return result;

		} catch (Throwable throwable) {
			logger.error(throwable.getMessage(), throwable);
		}

		return null;
	}

	@Override
	public QueryPageList<SkuProductForScenic> querySpuProductForScenic(SkuProductForScenicQuery param,
																	   QueryPageModel queryPageModel){
		//1.根据分销商获取政策数据
		Map<Long, List<PCStrategyResult>> pcsMap = null;
		try {
			pcsMap = strategySearchService.querySkuStrategyByDistributorId(param.getResellerId(), param.getSalesType(), param.getTicketVarie());
			if (pcsMap == null || pcsMap.isEmpty()) {
				throw new Exception("根据分销商（" + param.getResellerId() + "）查询没有有效的政策数据与产品关联");
			}

			List<Long> skuIds = new ArrayList<>(pcsMap.keySet());

			ProductRelation relationParam = new ProductRelation();
			relationParam.setObjIds(skuIds);
			relationParam.setObjType(GlobalParam.PRORELEASETABEL);
			relationParam.setRelId(param.getScenicId());
			relationParam.setRelType(GlobalParam.SCENIC);

			List<ProductRelation> productRelationList = productRelationService.findListByParams(relationParam);

			if (CollectionUtils.isEmpty(productRelationList)){
				throw new SkuServiceException("所查景区（" + param.getScenicId() + "）没有符合分销商（" + param.getResellerId() + "）的产品");
			}

			skuIds = new ArrayList<>();
			for (ProductRelation relation : productRelationList){
				Long objId = relation.getObjId();
				if (!skuIds.contains(objId)) {
					skuIds.add(objId);
				}
			}

			String start = GlobalParam.FLAG.start().toString();
			String agree = GlobalParam.FLAG.agree().toString();

			//2.根据产品id集合查询产品信息
			SkuProductQuery queryParam = param.getQueryParam();
			ProductRelease productReleaseParam = ProductConvert.convertTProductRelease(queryParam);
			if (productReleaseParam == null)
				productReleaseParam = new ProductRelease();
			if (CollectionUtils.isNotEmpty(productReleaseParam.getIds())){
				productReleaseParam.getIds().addAll(skuIds);
			} else {
				productReleaseParam.setIds(skuIds);
			}
			productReleaseParam.setFlag(start);
			productReleaseParam.setAuditStatus(agree);
			if (CollectionUtils.isEmpty(productReleaseParam.getProCategorys()))
				productReleaseParam.setProCategorys(skuScenicProductTypes);

			ProductInfo	productInfoParam = new ProductInfo();

			com.pzj.base.entity.query.DateQueryParam saleDateQuery = new DateQueryParam();
			saleDateQuery.setStartDate(new Date());

			productInfoParam.setSaleDateQuery(saleDateQuery);

			QueryPageList<ProductRelease> skuProductQueryPageList = productReleaseService.findReleaseAndInfoByInfoParams(productReleaseParam, productInfoParam, queryPageModel);
			List<ProductRelease> skuList = skuProductQueryPageList.getResultList();
			if(CollectionUtils.isEmpty(skuList)){
				throw new Exception("根据分销商查询没有有效的产品数据");
			}

			//4.组织返回对象
			List<SkuProductForScenic> skuProductForScenicList = ProductConvert.convertProductReleaseTSkuProductForScenic(pcsMap, skuList);
			QueryPageList<SkuProductForScenic> queryPageList = new QueryPageList<>(skuProductForScenicList, skuProductQueryPageList.getPageBean());
			return queryPageList;
		} catch (Throwable throwable) {
			logger.error(throwable.getMessage(), throwable);
		}

		return null;
	}

}
